package com.andalus.abomedhat.mohamedfawzytasks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Recycler extends RecyclerView.Adapter<Recycler.MyViewHolder> {
    List<DataSet> item;
    Context context;
    OnItemClickListener onItemClickListener;

    public Recycler(Context mContext, List<DataSet> data,OnItemClickListener listener) {
        item = data;
        context=mContext;
        onItemClickListener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.grid_item,viewGroup,false);

        return new MyViewHolder(view,onItemClickListener);
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.thumbnail) ImageView thumbnail;
        @BindView(R.id.title) TextView title;
        @BindView(R.id.size) TextView size;
        OnItemClickListener listener;
        public MyViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.listener=listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        listener.onClick(getAdapterPosition());
        }
    }
    interface OnItemClickListener{
         void onClick(int position);

    }
}
