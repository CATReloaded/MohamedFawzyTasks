package com.andalus.abomedhat.mohamedfawzytasks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Recycler extends RecyclerView.Adapter<Recycler.MyViewHolder> {
    List<DataSet> item;
    Context context;

    public Recycler(Context mContext, List<DataSet> data) {
        item = data;
        context=mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.grid_item,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
    myViewHolder.thumbnail.setImageResource(item.get(i).getThumbnail());
    myViewHolder.title.setText(item.get(i).getTitle());
    myViewHolder.size.setText(item.get(i).getSize());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title,size;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.thumbnail);
            title=itemView.findViewById(R.id.title);
            size=itemView.findViewById(R.id.size);
        }
    }
}
