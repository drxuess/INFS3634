package xu.morgan.activitiesintents.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import xu.morgan.activitiesintents.R;
import xu.morgan.activitiesintents.model.ListItemA;
import xu.morgan.activitiesintents.model.ListItemB;

/**
 * Created by morganxu on 21/08/2016.
 */
public class CustomListViewAdapter extends BaseAdapter {

    private static final int TYPE_A = 0;
    private static final int TYPE_B = 1;

    private LayoutInflater inflater;
    private ArrayList<ListItemA> listA;
    private ArrayList<ListItemB> listB;

    public CustomListViewAdapter(LayoutInflater inflater, ArrayList<ListItemA> listA, ArrayList<ListItemB> listB){
        this.inflater = inflater;
        this.listA = listA;
        this.listB = listB;
    }

    @Override
    public int getCount() {
        return listA.size() + listB.size();
    }

    @Override
    public Object getItem(int position) {
        if(position%2 == 0){
            return listB.get(position/2);
        } else{
            return listA.get(position/2);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if(type == TYPE_A){
            convertView = inflater.inflate(R.layout.list_item_a, parent, false);
            ListItemA item = listA.get(position / 2);
            ((TextView) convertView.findViewById(R.id.text_tv)).setText(item.getText());
            ((TextView) convertView.findViewById(R.id.subtext_tv)).setText(item.getSubText());
        } else{
            convertView = inflater.inflate(R.layout.list_item_b, parent, false);
            ListItemB item = listB.get(position / 2);
            ((TextView) convertView.findViewById(R.id.text_tv)).setText(item.getText());
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2 == 0){
            return TYPE_B;
        } else{
            return TYPE_A;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
