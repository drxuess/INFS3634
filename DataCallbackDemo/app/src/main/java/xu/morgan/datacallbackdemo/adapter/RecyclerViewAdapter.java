package xu.morgan.datacallbackdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xu.morgan.datacallbackdemo.R;
import xu.morgan.datacallbackdemo.model.PokemonUrl;

/**
 * Created by morganxu on 2/10/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<PokemonUrl> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView urlTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.item_tv);
            urlTextView = (TextView) itemView.findViewById(R.id.url_tv);
        }
    }

    public RecyclerViewAdapter(List<PokemonUrl> dataSet){
        this.dataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameTextView.setText(dataSet.get(position).getPokemonName());
        holder.urlTextView.setText(dataSet.get(position).getPokeUrl());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addItem(PokemonUrl item){
        dataSet.add(item);
        this.notifyDataSetChanged();
    }
}
