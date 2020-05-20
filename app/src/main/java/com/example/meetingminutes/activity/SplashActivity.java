package com.example.meetingminutes.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //The account has been saved or not
        String mail=sharedPreferences.getString("email","");
        if(TextUtils.isEmpty(mail))
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        else
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }
}