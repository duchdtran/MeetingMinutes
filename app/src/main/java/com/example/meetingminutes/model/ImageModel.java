package com.example.meetingminutes.model;

import android.graphics.Bitmap;

public class ImageModel {
    private int imageResource;
    private String title;

    public ImageModel(int imageResource, String title) {
        super();
        this.imageResource = imageResource;
        this.title = title;
    }

    public int getImage() {
        return imageResource;
    }

    public void setImage(int image) {
        this.imageResource = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
