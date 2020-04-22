package com.example.meetingminutes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.meetingminutes.R;

import java.util.ArrayList;

public class SesstionActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesstion);

        listView = findViewById(R.id.lv_session);
        ArrayList<String> session = new ArrayList<>();
        session.add("Buổi 1");
        session.add("Buổi 2");
        session.add("Buổi 3");
        session.add("Buổi 4");
        session.add("Buổi 5");
        session.add("Buổi 6");
        session.add("Buổi 7");
        session.add("Buổi 8");
        ArrayAdapter adapter = new ArrayAdapter(SesstionActivity.this, android.R.layout.simple_dropdown_item_1line, session);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SesstionActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
