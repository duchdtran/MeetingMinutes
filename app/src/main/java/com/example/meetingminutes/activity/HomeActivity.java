package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;


import com.example.meetingminutes.R;
import com.example.meetingminutes.fragment.CalendarFragment;
import com.example.meetingminutes.fragment.NotificationFragment;
import com.example.meetingminutes.fragment.MeetingFragment;
import com.example.meetingminutes.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        InitView();
    }

    private void InitView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Bottom Navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navLisener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MeetingFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
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
