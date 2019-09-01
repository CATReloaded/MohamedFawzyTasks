package com.andalus.abomedhat.mohamedfawzytasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<DataSet> item=new ArrayList<>();
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        item.add(new DataSet(R.drawable.ic_launcher_background,"Twitter","45 MB"));
        Recycler recycler=new Recycler(this,item);
        RecyclerView recyclerView=findViewById(R.id.recycler);
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

}
