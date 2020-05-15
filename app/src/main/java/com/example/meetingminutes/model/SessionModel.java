package com.example.meetingminutes.model;

import java.sql.Time;

public class SessionModel {
    private String Name;
    private String Address;
    private Time TimeStart;
    private Time TimeEnd;
    private String Description;

    public SessionModel() {
    }

    public SessionModel(String name, String address, Time timeStart, Time timeEnd, String description) {
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


    public Time getTimeStart() {
        return TimeStart;
    }


    public Time getTimeEnd() {
        return TimeEnd;
    }


    public String getDescription() {
        return Description;
    }
}