package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.animation.Animator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.meetingminutes.R;
import com.example.meetingminutes.adapter.AttendanceAdminAdapter;
import com.example.meetingminutes.adapter.ImageSessionAdapter;
import com.example.meetingminutes.model.AttendanceAdminModel;
import com.example.meetingminutes.model.ImageSessionModel;
import android.hardware.Camera;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.example.meetingminutes.animation.ZoomImageAnimation;

public class AttendanceAdminActivity extends AppCompatActivity {

    List<AttendanceAdminModel> list_attendance;
    List<String> list_spinner;
    List<ImageSessionModel> list_grid;
    ArrayAdapter<String> spinner_adapter;
    private Toolbar toolbar;
    Spinner spinner ;
    GridView gridView;
    private ImageView imageView;
    private ImageView imageView2;


    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_VIDEO_CAPTURE = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_admin);

        toolbar = findViewById(R.id.toolbar);
        spinner = findViewById(R.id.spn_session);
        gridView = findViewById(R.id.gv_album_session);

        setEvent();
    // them data cho diem danh
        list_attendance = new ArrayList<>();
        list_attendance.add(new AttendanceAdminModel(R.drawable.logo,"Lê Anh Dũng","Có mặt",true));
        list_attendance.add(new AttendanceAdminModel(R.drawable.logo,"Phạm Thành Nam","Vắng mặt",false));
        list_attendance.add(new AttendanceAdminModel(R.drawable.logo,"Trần Đình Đức","Có mặt",true));
        // fake data cho phien hop
        list_spinner = new ArrayList<>();
        for (int i = 1; i<=10; i++){
            list_spinner.add("Phiên "+i);
        }
        // fake data cho image session
        list_grid = new ArrayList<>();
        for(int i = 0; i<=10; i++){
            list_grid.add(new ImageSessionModel(R.drawable.logo));
        }

        final ImageSessionAdapter grid_adapter = new ImageSessionAdapter(list_grid,this);
        final GridView gridView = findViewById(R.id.gv_album_session);
        gridView.setAdapter(grid_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AttendanceAdminActivity.this);

                AlertDialog dialog = builder.setTitle("Annotication")
                        .setMessage("Can you choose your selection?")
                        .setNegativeButton("Zoom image", null)
                        .setPositiveButton("Update image", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                captureImage();
                            }
                        })
                        .create();

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

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


    private void captureImage() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
    }

    protected void onActivityResult( int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {


            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }
    }

}
