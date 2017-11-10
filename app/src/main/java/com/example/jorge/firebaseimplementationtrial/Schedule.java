package com.example.jorge.firebaseimplementationtrial;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joeanca on 2017-11-08.
 */
class Schedule {
    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<String> getSmtgelse() {
        return smtgelse;
    }

    public void setSmtgelse(List<String> smtgelse) {
        this.smtgelse = smtgelse;
    }

    private List<String> times = new ArrayList<String>();
    private List<String> smtgelse = new ArrayList<String>();
    public Schedule(){}


}
