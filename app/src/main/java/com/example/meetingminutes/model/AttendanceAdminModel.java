package com.example.meetingminutes.model;

import android.widget.ImageView;

public class AttendanceAdminModel {
    int imgResource;
    String full_name;
    String status_attendance;
    Boolean isAttendance;

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getStatus_attendance() {
        return status_attendance;
    }

    public void setStatus_attendance(String status_attendance) {
        this.status_attendance = status_attendance;
    }

    public Boolean getAttendance() {
        return isAttendance;
    }

    public void setAttendance(Boolean attendance) {
        isAttendance = attendance;
    }

    public AttendanceAdminModel(int imgResource, String full_name, String status_attendance,Boolean isAttendance ) {
        this.imgResource = imgResource;
        this.full_name = full_name;
        this.status_attendance = status_attendance;
        this.isAttendance =isAttendance;
    }
}
