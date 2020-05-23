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
import com.example.meetingminutes.activity.DetailActivity;
import com.example.meetingminutes.model.SessionModel;

import java.util.List;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionHolder>{

    Context mContext;
    List<SessionModel> mData;

    public SessionAdapter(Context mContext, List<SessionModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public SessionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_session,parent,false);
        final SessionHolder vHolder = new SessionHolder(v);

        vHolder.itemSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = vHolder.getAdapterPosition();
                Toast.makeText(mContext, "Test Click: " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DetailActivity.class);
                mContext.startActivity(intent);
            }
        });
        vHolder.btnMoreSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = vHolder.getAdapterPosition();
                PopupMenu popupMenu = new PopupMenu(mContext, vHolder.btnMoreSession);
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
    public void onBindViewHolder(@NonNull SessionHolder holder, int position) {
        holder.tvNameSession.setText(mData.get(position).getName());
        holder.tvAddressSession.setText("Địa chỉ: " + mData.get(position).getAddress());
        holder.tvTimeSession.setText("Thời gian: " + mData.get(position).getTimeStart()+ " - " + mData.get(position).getTimeEnd());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class SessionHolder extends RecyclerView.ViewHolder{
        private RelativeLayout itemSession;
        private TextView tvNameSession;
        private TextView tvTimeSession;
        private TextView tvAddressSession;
        private ImageButton btnMoreSession;

        public SessionHolder(View itemView){
            super(itemView);

            itemSession = itemView.findViewById(R.id.item_session);
            tvNameSession = itemView.findViewById(R.id.tv_name_session);
            tvTimeSession = itemView.findViewById(R.id.tv_time_session);
            tvAddressSession = itemView.findViewById(R.id.tv_address_session);
            btnMoreSession = itemView.findViewById(R.id.btn_more_session);

        }
    }
}