package com.example.meetingminutes.model;

public class ImageSessionModel {
    private int imageResource;

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public ImageSessionModel(int imageResource)
    {
        this.imageResource = imageResource;
    }
}
