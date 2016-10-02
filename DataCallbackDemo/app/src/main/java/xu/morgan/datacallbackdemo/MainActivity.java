package xu.morgan.datacallbackdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import xu.morgan.datacallbackdemo.adapter.RecyclerViewAdapter;
import xu.morgan.datacallbackdemo.adapter.RecyclerViewDivider;
import xu.morgan.datacallbackdemo.model.PokemonUrl;
import xu.morgan.datacallbackdemo.services.DataCallback;
import xu.morgan.datacallbackdemo.services.PokeDataProvider;

public class MainActivity extends AppCompatActivity implements DataCallback<List<PokemonUrl>>{
    private List<PokemonUrl> dataList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        progressDialog = ProgressDialog.show(this, "Please Wait", "Loading");

        PokeDataProvider provider = new PokeDataProvider(this);
        dataList = new ArrayList<>();
        provider.getPokemon(this);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new RecyclerViewDivider(this));
    }

    @Override
    public void onSuccess(List<PokemonUrl> result) {
        dataList = result;
        recyclerView.setAdapter(new RecyclerViewAdapter(dataList));
        progressDialog.dismiss();
    }

    @Override
    public void onFailure(String error) {
        Log.e("Error", error);
    }
}
