package com.example.meetingminutes.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meetingminutes.R;
import com.example.meetingminutes.model.ImageModel;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    List<ImageModel> listImage;
    Context context;
    int itemWidth;

    public ImageAdapter(List<ImageModel> listImage,Context context) {
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


    public static class ImageHolder extends RecyclerView.ViewHolder {
        ImageView img_image;
        TextView tv_name_image;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            img_image = itemView.findViewById(R.id.img_image);
            tv_name_image = itemView.findViewById(R.id.tv_name_image);
        }
    }

}
