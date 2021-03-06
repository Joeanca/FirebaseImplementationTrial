package com.example.jorge.firebaseimplementationtrial;

/**
 * Created by joeanca on 2017-11-08.
 */

import java.util.ArrayList;

/**
 * Created by jason on 10/28/2017.
 */

public class Zone {

    private boolean zOnOff;
    private String zGUID, zName;
    private ArrayList<zSchedule> zoneSchedule = new ArrayList<zSchedule>();

    //default constructor for empty zone
    public Zone(String zGUID) {
        this.zGUID = zGUID;
    }

    //constructor allows for full zone config
    public Zone(String zGUID, String zName, boolean zOnOff) {
        this.zGUID = zGUID;
        this.zName = zName;
        this.zOnOff = zOnOff;
    }public Zone(){}

    public String getzGUID() {
        return zGUID;
    }

    public void setzGUID(String zGUID) {
        this.zGUID = zGUID;
    }

    public String getzName() {
        return zName;
    }

    public void setzName(String zName) {
        this.zName = zName;
    }

    public boolean iszOnOff() {
        return zOnOff;
    }

    public void setzOnOff(boolean zOnOff) {
        this.zOnOff = zOnOff;
    }

    public ArrayList<zSchedule> getZoneSchedule() {
        return zoneSchedule;
    }

    public void setZoneSchedule(ArrayList<zSchedule> zoneSchedule) {
        this.zoneSchedule = zoneSchedule;
    }

    public void addToSchedule(int aDay, Long aStartTime, Long aDuration) {
        zoneSchedule.add(new zSchedule(aDay, aStartTime, aDuration));
    }

    //TODO remove schedule function(s)

    private class zSchedule {
        private int day;
        private Long startTime;
        private Long duration;

        public zSchedule(int day, Long startTime, Long duration) {
            this.day = day;
            this.startTime = startTime;
            this.duration = duration;
        }

    }
}