package com.maadi.flightticketbooking.models;

import java.io.Serializable;

public class MyBooking implements Serializable {
    int id;
    String traveldate, fare,vclass,fromcity,tocity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraveldate() {
        return traveldate;
    }

    public void setTraveldate(String traveldate) {
        this.traveldate = traveldate;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getVclass() {
        return vclass;
    }

    public void setVclass(String vclass) {
        this.vclass = vclass;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public String getTocity() {
        return tocity;
    }

    public void setTocity(String tocity) {
        this.tocity = tocity;
    }

    public MyBooking(int id, String traveldate, String fare, String vclass, String fromcity, String tocity) {
        this.id = id;
        this.traveldate = traveldate;
        this.fare = fare;
        this.vclass = vclass;
        this.fromcity = fromcity;
        this.tocity = tocity;
    }
}
