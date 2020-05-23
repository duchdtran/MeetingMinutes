package com.example.meetingminutes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meetingminutes.R;
import com.example.meetingminutes.activity.SessionActivity;
import com.example.meetingminutes.model.MeetingModel;

import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingHolder>{

    Context mContext;
    List<MeetingModel> mData;

    public MeetingAdapter(Context mContext, List<MeetingModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MeetingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_meeting,parent,false);
        final MeetingHolder vHolder = new MeetingHolder(v);

        vHolder.itemMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = vHolder.getAdapterPosition();
                Toast.makeText(mContext, "Test Click: " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, SessionActivity.class);
                mContext.startActivity(intent);
            }
        });
        vHolder.btnMoreMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = vHolder.getAdapterPosition();
                PopupMenu popupMenu = new PopupMenu(mContext, vHolder.btnMoreMeeting);
                popupMenu.getMenuInflater().inflate(R.menu.option_meeting, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(mContext, "Item clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingHolder holder, int position) {
        holder.tvNameMeeting.setText(mData.get(position).getName());
        holder.tvAddressMeeting.setText("Địa chỉ: " + mData.get(position).getAddress());
        holder.tvTimeMeeting.setText("Thời gian: " + mData.get(position).getTimeStart()+ " - " + mData.get(position).getTimeEnd());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MeetingHolder extends RecyclerView.ViewHolder{
        private RelativeLayout itemMeeting;
        private TextView tvNameMeeting;
        private TextView tvTimeMeeting;
        private TextView tvAddressMeeting;
        private ImageButton btnMoreMeeting;

        public MeetingHolder(View itemView){
            super(itemView);

            itemMeeting = itemView.findViewById(R.id.item_meeting);
            tvNameMeeting = itemView.findViewById(R.id.tv_name_meeting);
            tvTimeMeeting = itemView.findViewById(R.id.tv_time_meeting);
            tvAddressMeeting = itemView.findViewById(R.id.tv_address_meeting);
            btnMoreMeeting = itemView.findViewById(R.id.btn_more_meeting);

        }
    }
}
