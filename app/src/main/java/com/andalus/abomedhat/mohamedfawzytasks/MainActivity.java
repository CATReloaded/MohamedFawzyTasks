package com.andalus.abomedhat.mohamedfawzytasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Recycler.OnItemClickListener {
@BindView(R.id.recycler) RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<DataSet> item=new ArrayList<>();
        for(int i=0;i<10;i++) {
            item.add(new DataSet(R.drawable.ic_launcher_background, "Twitter", "45 MB"));
        }
        Recycler recycler=new Recycler(this, item, this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,numberPossible());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycler);
    }
    public int numberPossible() {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float dpwidth = displayMetrics.widthPixels / displayMetrics.density;
        int numberPossible = (int) (dpwidth / 170);
        return numberPossible;
    }

    @Override
    public void onClick(int position) {
        Intent i=new Intent(this,Item.class);
        startActivity(i);
    }
}
