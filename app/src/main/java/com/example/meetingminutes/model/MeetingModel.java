package com.example.meetingminutes.model;

import java.sql.Time;
import java.sql.Timestamp;

public class MeetingModel {
    private String Name;
    private String Address;
    private Timestamp TimeStart;
    private Timestamp TimeEnd;
    private String Description;

    public MeetingModel() {
    }

    public MeetingModel(String name, String address, Timestamp timeStart, Timestamp timeEnd, String description) {
        Name = name;
        Address = address;
        TimeStart = timeStart;
        TimeEnd = timeEnd;
        Description = description;
    }

    public String getName() {
        return Name;
    }


    public String getAddress() {
        return Address;
    }


    public Timestamp getTimeStart() {
        return TimeStart;
    }


    public Timestamp getTimeEnd() {
        return TimeEnd;
    }


    public String getDescription() {
        return Description;
    }

}
