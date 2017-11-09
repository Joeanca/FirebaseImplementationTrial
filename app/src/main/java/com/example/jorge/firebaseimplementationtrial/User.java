package com.example.jorge.firebaseimplementationtrial;

import java.util.List;

import javax.swing.text.ZoneView;

/**
 * Created by joeanca on 2017-11-08.
 */

public class User {
    private String uID;
    private String name;
    private String email;

    private List<Schedule> scheduleList;
    private List<Zone> zoneList;

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
}
