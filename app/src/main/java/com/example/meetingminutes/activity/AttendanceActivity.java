package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetingminutes.R;

public class AttendanceActivity extends AppCompatActivity {
    public static final int QRCODE_REQUEST = 1;

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

        initView();
        setEvent();

    }

    private void initView(){
        tvAttendanceList = findViewById(R.id.tv_attendance_list);
        btnCheckin = findViewById(R.id.btn_checkin);
        btnQRCode = findViewById(R.id.btn_qrcode);
        cbxFace = findViewById(R.id.cbx_face);
        cbxQRCode = findViewById(R.id.cbx_qrcode);
        cbxWifi = findViewById(R.id.cbx_wifi);
        toolbar = findViewById(R.id.toolbar);
    }

    private void setEvent(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendanceActivity.this, ScanCodeActivity.class);
                startActivityForResult(intent, QRCODE_REQUEST);
                //startActivity(intent);
            }
        });
        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                connection = wifiManager.getConnectionInfo();

                String display = "SSID: " +connection.getSSID() + "RSSI: " +connection.getRssi() + "Mac Address: " + connection.getMacAddress();

                Toast.makeText(AttendanceActivity.this, display, Toast.LENGTH_SHORT).show();
                cbxWifi.setChecked(true);
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //QRCode
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == QRCODE_REQUEST){
            String result = data.getStringExtra("QRCODE");
            if(result.contains("Hello world")){
                Toast.makeText(this, "Điểm danh QRCode thành công.", Toast.LENGTH_SHORT).show();
                cbxQRCode.setChecked(true);
                return;
            }
        }
        Toast.makeText(this, "Mã QRCode không chính xác.", Toast.LENGTH_SHORT).show();
    }
}
