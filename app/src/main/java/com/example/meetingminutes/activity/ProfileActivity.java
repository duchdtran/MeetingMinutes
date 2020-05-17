package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import com.example.meetingminutes.R;
import com.example.meetingminutes.adapter.ImageUserAdapter;
import com.example.meetingminutes.model.ImageUserModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvNameUser, tvEmailUser, tvPhoneUser, tvAddressUser;
    List<ImageUserModel> listImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initView();
        setEvent();
        listImage = new ArrayList<>();
        listImage.add(new ImageUserModel(R.drawable.ic_image_black_24dp));
        for(int i = 1; i <= 20; i++){
            listImage.add(new ImageUserModel(R.drawable.logo));
        }
        ImageUserAdapter adapter = new ImageUserAdapter(listImage,this);
        GridView gridView = findViewById(R.id.gv_photo_album_1);
        gridView.setAdapter(adapter);
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        tvNameUser = findViewById(R.id.tv_fullname);
        tvAddressUser = findViewById(R.id.tv_address);
        tvEmailUser = findViewById(R.id.tv_email);
        tvPhoneUser = findViewById(R.id.tv_phone);
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
