package com.andalus.abomedhat.mohamedfawzytasks;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class DataSet implements Serializable {
    private int thumbnail;
    private String title;
    private String size;

    public DataSet(int thumbnail, String title, String size) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.size = size;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
