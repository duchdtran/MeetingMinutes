package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.meetingminutes.R;
import com.example.meetingminutes.adapter.MeetingAdapter;
import com.example.meetingminutes.adapter.SessionAdapter;
import com.example.meetingminutes.model.SessionModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class SessionActivity extends AppCompatActivity {

    private RecyclerView myRecycleView;
    private List<SessionModel> lsSession;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        initView();
        setEvent();
        myRecycleView = findViewById(R.id.rcv_session);
        lsSession = new ArrayList<>();
        lsSession.add(new SessionModel("Meeting Minutes", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsSession.add(new SessionModel("Meeting Minutes123", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsSession.add(new SessionModel("Meeting Minutes213", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsSession.add(new SessionModel("Meeting Minutes546", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsSession.add(new SessionModel("Meeting Minutes2657", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsSession.add(new SessionModel("Meeting Minutes2364", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsSession.add(new SessionModel("Meeting Minutes3243", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsSession.add(new SessionModel("Meeting Minutes235", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        SessionAdapter sessionAdapter = new SessionAdapter(this, lsSession);
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleView.setAdapter(sessionAdapter);

    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
    }
    private void setEvent(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
