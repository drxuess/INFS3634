package xu.morgan.activitiesintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import xu.morgan.activitiesintents.adapter.CustomListViewAdapter;
import xu.morgan.activitiesintents.model.ListItemA;
import xu.morgan.activitiesintents.model.ListItemB;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        ArrayList<ListItemA> listA = new ArrayList<>();
        listA.add(new ListItemA("You can do anything, but not everything.", "David Allen"));
        listA.add(new ListItemA("Perfection is achieved, not when there is nothing more to add, but when there is nothing left to take away.", "Antoine de Saint-Exupery"));
        listA.add(new ListItemA("The richest man is not he who has the most, but he who needs the least.", "Anonymous"));
        listA.add(new ListItemA("You miss 100 percent of the shots you never take.", "Wayne Gretzky"));
        listA.add(new ListItemA("You must be the change you wish to see in the world.", "Gandhi"));
        listA.add(new ListItemA("We are what we repeatedly do; excellence, then, is not an act but a habit.", "Aristotle"));
        listA.add(new ListItemA("Work like you don’t need money, love like you’ve never been hurt, and dance like no one’s watching", "Unknown"));
        listA.add(new ListItemA("What the world needs is more geniuses with humility, there are so few of us left.", "Oscar Levant"));
        listA.add(new ListItemA("Always forgive your enemies; nothing annoys them so much.", "Oscar Wilde"));

        ArrayList<ListItemB> listB = new ArrayList<>();
        listB.add(new ListItemB("Warning: List Item 1"));
        listB.add(new ListItemB("Warning: List Item 2"));
        listB.add(new ListItemB("Warning: List Item 3"));
        listB.add(new ListItemB("Warning: List Item 4"));
        listB.add(new ListItemB("Warning: List Item 5"));
        listB.add(new ListItemB("Warning: List Item 6"));
        listB.add(new ListItemB("Warning: List Item 7"));
        listB.add(new ListItemB("Warning: List Item 8"));
        listB.add(new ListItemB("Warning: List Item 9"));
        listB.add(new ListItemB("Warning: List Item 0"));

        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(getLayoutInflater(), listA, listB);

        ListView listView = (ListView) findViewById(R.id.custom_container_lv);

        listView.setAdapter(customListViewAdapter);

    }
}
