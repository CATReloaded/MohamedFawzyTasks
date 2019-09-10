package com.andalus.abomedhat.mohamedfawzytasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Item extends AppCompatActivity {
    @BindView(R.id.size)TextView size;
    @BindView(R.id.thumbnail) ImageView thumbnail;
    @BindView(R.id.title) TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);
        DataSet dataSet=(DataSet)getIntent().getSerializableExtra("dataset");
        thumbnail.setImageResource(dataSet.getThumbnail());
        size.setText(dataSet.getSize());
        title.setText(dataSet.getTitle());
    }
}
