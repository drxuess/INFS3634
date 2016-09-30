package xu.morgan.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xu.morgan.recyclerviewdemo.R;
import xu.morgan.recyclerviewdemo.model.ShoppingItem;

/**
 * Created by xumo on 28/09/2016.
 */
public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.ViewHolder> {

    private List<ShoppingItem> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTextView;
        public TextView priceTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.item_tv);
            priceTextView = (TextView) itemView.findViewById(R.id.price_tv);
        }
    }

    public GridRecyclerViewAdapter(List<ShoppingItem> dataSet){
        this.dataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view_holder, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemTextView.setText(dataSet.get(position).getName());
        holder.priceTextView.setText(dataSet.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addItem(ShoppingItem item){
        dataSet.add(item);
        this.notifyDataSetChanged();
    }
}
