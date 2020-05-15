package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.meetingminutes.R;
import com.example.meetingminutes.fragment.CalendarFragment;
import com.example.meetingminutes.fragment.NotificationFragment;
import com.example.meetingminutes.fragment.MeetingFragment;
import com.example.meetingminutes.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        setEvent();
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        bottomNav = findViewById(R.id.bottom_navigation);


    }
    private void setEvent(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_account_circle_white_24dp);

        bottomNav.setOnNavigationItemSelectedListener(navLisener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MeetingFragment()).commit();
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navLisener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_project:
                            selectedFragment = new MeetingFragment();
                            toolbar.setTitle(R.string.meeting);
                            break;
                        case R.id.nav_calendar:
                            selectedFragment = new CalendarFragment();
                            toolbar.setTitle(R.string.calendar);
                            break;
                        case R.id.nav_notification:
                            selectedFragment = new NotificationFragment();
                            toolbar.setTitle(R.string.notification);
                            break;
                        case R.id.nav_setting:
                            selectedFragment = new SettingFragment();
                            toolbar.setTitle(R.string.setting);
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return  true;
                }
            };

}
