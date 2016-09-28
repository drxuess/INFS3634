package xu.morgan.activitiesintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private ListView lvContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvContainer = (ListView) findViewById(R.id.container_lv);

        final String[] data = new String[]{"List View Item 1", "List View Item 2", "List View Item 3", "List View Item 4",
                "List View Item 5", "List View Item 6", "List View Item 7", "List View Item 8", "List View Item 9",
                "List View Item 10", "List View Item 11", "List View Item 12", "List View Item 13", "List View Item 14"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        lvContainer.setAdapter(adapter);

        lvContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), data[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
