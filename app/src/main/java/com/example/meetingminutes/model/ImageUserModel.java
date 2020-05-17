package com.example.meetingminutes.model;

import android.graphics.Bitmap;

public class ImageUserModel {
    private int imageResource;

    public ImageUserModel(int imageResource) {
        super();
        this.imageResource = imageResource;
    }

    public int getImage() {
        return imageResource;
    }

    public void setImage(int image) {
        this.imageResource = image;
    }

}
