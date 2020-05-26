package com.example.meetingminutes.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.meetingminutes.model.ImageUserModel;

import java.util.List;

public class ImageUserAdapter extends BaseAdapter {

    List<ImageUserModel> listImage;
    Context context;
    int itemWidth;

    public ImageUserAdapter(List<ImageUserModel> listImage, Context context) {
        this.listImage = listImage;
        this.context = context;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int space = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,28,displayMetrics);
        itemWidth = (displayMetrics.widthPixels-space)/4;

    }

    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public Object getItem(int i) {
        return listImage.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ImageView imageView;
        if(view ==null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(itemWidth,itemWidth));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        else{
            imageView = (ImageView)view;
        }
        imageView.setImageResource(listImage.get(i).getImage());
        return imageView;
    }

}
