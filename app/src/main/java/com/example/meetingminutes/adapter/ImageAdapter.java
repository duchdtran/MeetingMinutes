package com.example.meetingminutes.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.meetingminutes.R;
import com.example.meetingminutes.model.ImageModel;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private int layoutResourceId;
    private List<ImageModel> listImage;

    public ImageAdapter(Context context, int layoutResourceId, List<ImageModel> listImage) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.listImage = listImage;
    }

    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ImageModel item = listImage.get(position);
        holder.image.setImageBitmap(item.getImage());
        return row;
    }

    static class ViewHolder {
        ImageView image;
    }

}
