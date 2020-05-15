package com.example.meetingminutes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meetingminutes.R;
import com.example.meetingminutes.adapter.MeetingAdapter;
import com.example.meetingminutes.model.MeetingModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MeetingFragment extends Fragment {
    View view;
    private RecyclerView myRecycleView;
    private List<MeetingModel> lsMeeting;

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
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lsMeeting = new ArrayList<>();
        lsMeeting.add(new MeetingModel("Meeting Minutes", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsMeeting.add(new MeetingModel("Meeting Minutes123", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsMeeting.add(new MeetingModel("Meeting Minutes213", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsMeeting.add(new MeetingModel("Meeting Minutes546", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsMeeting.add(new MeetingModel("Meeting Minutes2657", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsMeeting.add(new MeetingModel("Meeting Minutes2364", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsMeeting.add(new MeetingModel("Meeting Minutes3243", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
        lsMeeting.add(new MeetingModel("Meeting Minutes235", "Đại học bách khoa Hà Nội", new Time(16, 20,0), new Time(17, 20,0), ""));
    }
}
