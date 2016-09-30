package xu.morgan.recyclerviewdemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import xu.morgan.recyclerviewdemo.adapter.GridRecyclerViewAdapter;
import xu.morgan.recyclerviewdemo.model.ShoppingItem;
import xu.morgan.recyclerviewdemo.utility.DataGenerator;

public class GridRecyclerView extends AppCompatActivity {
    private RecyclerView gridRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.grid_toolbar);
        toolbar.setTitle("Shopping List");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridRecyclerView = (RecyclerView) findViewById(R.id.grid_rv);
        gridRecyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 3);
        gridRecyclerView.setLayoutManager(layoutManager);

        GridRecyclerViewAdapter adapter = new GridRecyclerViewAdapter(DataGenerator.generateShoppingList(2));
        gridRecyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.grid_add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity parent = (Activity) view.getContext();
                AlertDialog.Builder builder = new AlertDialog.Builder(parent);
                LayoutInflater inflater = parent.getLayoutInflater();
                final View content = inflater.inflate(R.layout.dialog_create, null);
                builder.setTitle("New Shopping Item")
                        .setView(content)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String item = ((EditText) content.findViewById(R.id.shopping_item_et)).getText().toString();
                                String price = ((EditText) content.findViewById(R.id.price_et)).getText().toString();
                                ShoppingItem shoppingItem = new ShoppingItem(item, Double.parseDouble(price));
                                ((GridRecyclerViewAdapter) gridRecyclerView.getAdapter()).addItem(shoppingItem);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                builder.create().show();
            }
        });
    }
}
