package com.example.meetingminutes.fragment;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.meetingminutes.R;
import com.example.meetingminutes.adapter.MeetingAdapter;
import com.example.meetingminutes.model.MeetingModel;
import com.example.meetingminutes.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingFragment extends Fragment {
    View view;
    private RecyclerView myRecycleView;
    private List<MeetingModel> lsMeeting;

    private RecyclerView myRecycleView2;
    private List<MeetingModel> lsMeeting2;



    private TextView tv1, tv2;

    public MeetingFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meeting, container, false);

        myRecycleView = view.findViewById(R.id.rcv_meeting);
        MeetingAdapter meetingAdapter = new MeetingAdapter(getContext(), lsMeeting);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(meetingAdapter);

        myRecycleView2 = view.findViewById(R.id.rcv_meeting2);
        MeetingAdapter meetingAdapter2 = new MeetingAdapter(getContext(), lsMeeting);
        myRecycleView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView2.setAdapter(meetingAdapter2);

        tv1 = view.findViewById(R.id.dadienra);
        tv2 = view.findViewById(R.id.dangdienra);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myRecycleView.getVisibility() ==  View.VISIBLE){
                    myRecycleView.setVisibility(View.GONE);
                }else{
                    myRecycleView.setVisibility(View.VISIBLE);
                }
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myRecycleView2.getVisibility() ==  View.VISIBLE){
                    myRecycleView2.setVisibility(View.GONE);
                }else{
                    myRecycleView2.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        volleyJsonArrayRequest();

    }
    private void volleyJsonArrayRequest() {

        lsMeeting = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://10.0.2.2:3000/meetings", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{

                    for(int i=0;i<response.length();i++){

                        JSONObject meeting = response.getJSONObject(i);

                        String tv_name_meeting = meeting.getString("Name");
                        String tv_address_meeting = meeting.getString("Address");
                        String time_start = meeting.getString("Time_Start");
                        String time_end = meeting.getString("Time_End");

                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                          Date date_start = (Date)formatter.parse(time_start);
                          Date date_end = (Date)formatter.parse(time_end);
                        java.sql.Timestamp timeStampDateStart = new Timestamp(date_start.getTime());
                        java.sql.Timestamp timeStampDateEnd = new Timestamp(date_end.getTime());


                        lsMeeting.add(new MeetingModel(tv_name_meeting,tv_address_meeting,timeStampDateStart,timeStampDateEnd,""));

                    }
                }catch (JSONException | ParseException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "JsonArrayRequest onErrorResponse: " + error.getMessage());
            }
        });
        VolleySingleton.getInstance(getContext()).getRequestQueue().add(jsonArrayRequest);
    }

}
