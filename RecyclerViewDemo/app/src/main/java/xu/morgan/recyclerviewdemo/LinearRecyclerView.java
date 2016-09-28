package xu.morgan.recyclerviewdemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LinearRecyclerView extends AppCompatActivity {
    private RecyclerView linearRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.linear_toolbar);
        toolbar.setTitle("Shopping List");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linearRecyclerView = (RecyclerView) findViewById(R.id.linear_rv);
        linearRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        linearRecyclerView.setLayoutManager(layoutManager);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.linear_add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
