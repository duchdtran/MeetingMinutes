package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.meetingminutes.R;

public class DetailActivity extends AppCompatActivity {
    private TextView tvTime, tvLocation, tvPreside, tvDetail;
    private Button btnAttendance;
    private ImageButton btnBack;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setEvent();
    }
    private void initView(){
        tvTime = findViewById(R.id.tv_time);
        tvDetail = findViewById(R.id.tv_detail);
        tvLocation = findViewById(R.id.tv_location);
        tvPreside = findViewById(R.id.tv_preside);
        btnAttendance = findViewById(R.id.btn_attendance);
        toolbar = findViewById(R.id.toolbar);
    }
    private void setEvent(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, AttendanceAdminActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
