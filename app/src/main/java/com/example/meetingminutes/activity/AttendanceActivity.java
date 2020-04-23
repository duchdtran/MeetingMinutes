package com.example.meetingminutes.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetingminutes.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class AttendanceActivity extends AppCompatActivity {
    private TextView tvAttendanceList;
    private Button btnCheckin;
    private ImageButton btnBack, btnQRCode;
    private CheckBox cbxWifi, cbxQRCode, cbxFace;
    private Toolbar toolbar;

    WifiManager wifiManager;
    WifiInfo connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        InitView();
        SetEvent();

    }

    private void InitView(){
        tvAttendanceList = findViewById(R.id.tv_attendance_list);
        btnCheckin = findViewById(R.id.btn_checkin);
        btnQRCode = findViewById(R.id.btn_qrcode);
        cbxFace = findViewById(R.id.cbx_face);
        cbxQRCode = findViewById(R.id.cbx_qrcode);
        cbxWifi = findViewById(R.id.cbx_wifi);
        toolbar = findViewById(R.id.toolbar);
    }

    private void SetEvent(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbxQRCode.setChecked(true);
//                try {
//                    new IntentIntegrator(AttendanceActivity.this).initiateScan();
//                }catch (Exception e){
//                    Toast.makeText(AttendanceActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
            }
        });
        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
                connection = wifiManager.getConnectionInfo();

                String display = "SSID: " +connection.getSSID() + "RSSI: " +connection.getRssi() + "Mac Address: " + connection.getMacAddress();

                Toast.makeText(AttendanceActivity.this, display, Toast.LENGTH_SHORT).show();
                cbxWifi.setChecked(true);
            }
        });
    }
    // Get the results qrcode:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
