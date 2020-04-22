package com.example.meetingminutes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.meetingminutes.R;

public class DetailActivity extends AppCompatActivity {
    private TextView tvTime, tvLocation, tvPreside, tvDetail;
    private Button btnAttendance;
    private ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        InitView();

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DetailActivity.this, SesstionActivity.class);
//                startActivity(intent);
//            }
//        });
        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, AttendanceActivity.class);
                startActivity(intent);
            }
        });
    }
    private void InitView(){
        tvTime = findViewById(R.id.tv_time);
        tvDetail = findViewById(R.id.tv_detail);
        tvLocation = findViewById(R.id.tv_location);
        tvPreside = findViewById(R.id.tv_preside);
        btnAttendance = findViewById(R.id.btn_attendance);
//        btnBack = findViewById(R.id.btn_back);
    }
}
