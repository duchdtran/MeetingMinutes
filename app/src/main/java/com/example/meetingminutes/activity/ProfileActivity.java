package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.meetingminutes.R;

public class ProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvNameUser, tvEmailUser, tvPhoneUser, tvAddressUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initView();
        setEvent();
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        tvNameUser = findViewById(R.id.tv_name_user);
        tvAddressUser = findViewById(R.id.tv_address_user);
        tvEmailUser = findViewById(R.id.tv_email_user);
        tvPhoneUser = findViewById(R.id.tv_phone_user);
    }
    private void setEvent(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
