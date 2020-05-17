package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.example.meetingminutes.R;
import com.example.meetingminutes.adapter.AttendanceAdminAdapter;
import com.example.meetingminutes.adapter.ImageSessionAdapter;
import com.example.meetingminutes.model.AttendanceAdminModel;
import com.example.meetingminutes.model.ImageSessionModel;

import java.util.ArrayList;
import java.util.List;

public class AttendanceAdminActivity extends AppCompatActivity {

    List<AttendanceAdminModel> list_attendance;
    List<String> list_spinner;
    List<ImageSessionModel> list_grid;
    ArrayAdapter<String> spinner_adapter;
    private Toolbar toolbar;
    Spinner spinner ;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_admin);

        toolbar = findViewById(R.id.toolbar);
        spinner = findViewById(R.id.spn_session);
        gridView = findViewById(R.id.gv_album_session);

        setEvent();

        list_attendance = new ArrayList<>();
        list_attendance.add(new AttendanceAdminModel(R.drawable.logo,"Lê Anh Dũng","Có mặt",true));
        list_attendance.add(new AttendanceAdminModel(R.drawable.logo,"Phạm Thành Nam","Vắng mặt",false));
        list_attendance.add(new AttendanceAdminModel(R.drawable.logo,"Trần Đình Đức","Có mặt",true));

        list_spinner = new ArrayList<>();
        for (int i = 1; i<=10; i++){
            list_spinner.add("Phiên "+i);
        }
        list_grid = new ArrayList<>();
        for(int i = 0; i<=10; i++){
            list_grid.add(new ImageSessionModel(R.drawable.logo));
        }

        ImageSessionAdapter grid_adapter = new ImageSessionAdapter(list_grid,this);
        GridView gridView = findViewById(R.id.gv_album_session);
        gridView.setAdapter(grid_adapter);

        spinner_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list_spinner);
        spinner.setAdapter(spinner_adapter);

        final RecyclerView recyclerView = findViewById(R.id.rcv_attendance_admin);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final AttendanceAdminAdapter adapter = new AttendanceAdminAdapter(list_attendance);
        recyclerView.setAdapter(adapter);



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
