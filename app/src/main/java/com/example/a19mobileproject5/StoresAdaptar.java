package com.example.a19mobileproject5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a19mobileproject5.models.Row;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StoresAdaptar extends RecyclerView.Adapter<StoresAdaptar.ViewHolder> {

    private List<Row> storesModels;
    private Context context;

    public StoresAdaptar(Context context, List<Row> stores){
        this.storesModels = stores;
        this.context=context;
    }

    @NonNull
    @Override
    public StoresAdaptar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stores_list_item,viewGroup,false);
        return new StoresAdaptar.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.store_name.setText(storesModels.get(i).getSHNAME());
        viewHolder.store_desc.setText(storesModels.get(i).getSHINFO().trim());
        Picasso.get().load(storesModels.get(i).getSHPHOTO()).into(viewHolder.store_image);
    }

    @Override
    public int getItemCount() {
        return storesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView store_image;
        private TextView store_name,store_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            store_image=itemView.findViewById(R.id.store_image);
            store_name=itemView.findViewById(R.id.store_name);
            store_desc=itemView.findViewById(R.id.store_desc);
        }
    }
}
