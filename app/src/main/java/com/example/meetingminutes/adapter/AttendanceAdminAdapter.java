package com.example.meetingminutes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meetingminutes.R;
import com.example.meetingminutes.model.AttendanceAdminModel;

import java.util.List;

public class AttendanceAdminAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<AttendanceAdminModel> list_attendances;
    boolean isChecked = true;

    public AttendanceAdminAdapter(List<AttendanceAdminModel> list_attendances) {
        this.list_attendances = list_attendances;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attendance_admin, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AttendanceViewHolder attendanceViewHolder = (AttendanceViewHolder) holder;
        AttendanceAdminModel iteam = list_attendances.get(position);
        attendanceViewHolder.img_avt.setImageResource(iteam.getImgResource());
        attendanceViewHolder.tv_fullname.setText(iteam.getFull_name());

        if(iteam.getAttendance()){
            attendanceViewHolder.tv_status.setText("Có mặt");
            attendanceViewHolder.cb_attendance.setChecked(iteam.getAttendance());
        }
        else{
            attendanceViewHolder.tv_status.setText("Vắng mặt");
            attendanceViewHolder.cb_attendance.setChecked(iteam.getAttendance());
        }
    }
    @Override
    public int getItemCount() {
        return list_attendances.size();
    }
    class AttendanceViewHolder extends RecyclerView.ViewHolder {

        ImageView img_avt;
        TextView tv_fullname;
        TextView tv_status;
        CheckBox cb_attendance;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            img_avt = itemView.findViewById(R.id.img_image);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            tv_status = itemView.findViewById(R.id.tv_status_attendance);
            cb_attendance = itemView.findViewById(R.id.cb_attendance_admin);
            cb_attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Code khi trạng thái check thay đổi
                    boolean isChecked = list_attendances.get(getAdapterPosition()).getAttendance();
                    list_attendances.get(getAdapterPosition()).setAttendance(!isChecked);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
