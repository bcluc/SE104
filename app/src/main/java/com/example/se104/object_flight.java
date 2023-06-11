package com.example.se104;

import java.util.Date;

public class object_flight {
    private String code;
    private boolean isOneWay;
    private Date date_start;
    private Date date_end;
    private String dest_start;
    private String dest_land;

    public object_flight() {
        isOneWay = true;
    }
// flight one way
    public object_flight(Date date_start, String dest_start, String dest_land) {
        isOneWay = true;
        this.date_start = date_start;
        this.dest_start = dest_start;
        this.dest_land = dest_land;
    }
// flight go and back
    public object_flight(Date date_start, Date date_end, String dest_start, String dest_land) {

        this.isOneWay = false;
        this.date_start = date_start;
        this.date_end = date_end;
        this.dest_start = dest_start;
        this.dest_land = dest_land;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isOneWay() {
        return isOneWay;
    }

    public void setOneWay(boolean oneWay) {
        isOneWay = oneWay;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getDest_start() {
        return dest_start;
    }

    public void setDest_start(String dest_start) {
        this.dest_start = dest_start;
    }

    public String getDest_land() {
        return dest_land;
    }

    public void setDest_land(String dest_land) {
        this.dest_land = dest_land;
    }
}
