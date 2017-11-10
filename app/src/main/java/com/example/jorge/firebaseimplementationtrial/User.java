package com.example.jorge.firebaseimplementationtrial;

import java.util.List;


/**
 * Created by joeanca on 2017-11-08.
 */

public class User {
    private String uID;
    private String name;
    private String email;
    private List<Schedule> scheduleList;
    private List<Zone> zoneList;

    public User(){}

    public User (String uID, String name, String email, List<Schedule> scheduleList, List<Zone> zoneList){
        this.uID = uID;
        this.email = email;
        this.name = name;
        this.zoneList = zoneList;
        this.scheduleList = scheduleList;

    }

    public User(String uID, String email, String name) {
        this.uID = uID;
        this.email = email;
        this.name = name;
    }

    public String getuID() {return uID;}

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Schedule> getScheduleList() {return scheduleList;}

    public void setScheduleList(List<Schedule> scheduleList) {this.scheduleList = scheduleList;}

    public List<Zone> getZoneList() {return zoneList;}

    public void setZoneList(List<Zone> zoneList) {this.zoneList = zoneList;}

}
