package com.example.meetingminutes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
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
        listImage.add(new ImageUserModel(R.drawable.camera));
        for(int i = 1; i <= 20; i++){
            listImage.add(new ImageUserModel(R.drawable.logo));
        }
        ImageUserAdapter adapter = new ImageUserAdapter(listImage,this);
        GridView gridView = findViewById(R.id.gv_photo_album_1);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);

                    AlertDialog dialog = builder.setTitle("Menu image")
                            .setCancelable(true)
                            .setMessage("Do you want update your image ?")
                            .setNegativeButton("No", null)
                            .setPositiveButton("Update image", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .create();

                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);

                    AlertDialog dialog = builder.setTitle("Menu image")
                            .setCancelable(true)
                            .setMessage("Can you choose your selection?")
                            .setNegativeButton("Update image", null)
                            .setPositiveButton("Zoom image", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .create();

                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }
            }
        });

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
