package com.maadi.flightticketbooking.models;

import java.io.Serializable;

public class Vehical implements Serializable {
     int rid, fromcityid, tocityid;
     String fromcity, tocity, deptime, arivaltime, efare, bfare, duration, vehicle_name;

     public int getRid() {
          return rid;
     }

     public void setRid(int rid) {
          this.rid = rid;
     }

     public int getFromcityid() {
          return fromcityid;
     }

     public void setFromcityid(int fromcityid) {
          this.fromcityid = fromcityid;
     }

     public int getTocityid() {
          return tocityid;
     }

     public void setTocityid(int tocityid) {
          this.tocityid = tocityid;
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

     public String getDeptime() {
          return deptime;
     }

     public void setDeptime(String deptime) {
          this.deptime = deptime;
     }

     public String getArivaltime() {
          return arivaltime;
     }

     public void setArivaltime(String arivaltime) {
          this.arivaltime = arivaltime;
     }

     public String getEfare() {
          return efare;
     }

     public void setEfare(String efare) {
          this.efare = efare;
     }

     public String getBfare() {
          return bfare;
     }

     public void setBfare(String bfare) {
          this.bfare = bfare;
     }

     public String getDuration() {
          return duration;
     }

     public void setDuration(String duration) {
          this.duration = duration;
     }

     public String getVehicle_name() {
          return vehicle_name;
     }

     public void setVehicle_name(String vehicle_name) {
          this.vehicle_name = vehicle_name;
     }

     public Vehical(int rid, int fromcityid, int tocityid, String fromcity, String tocity, String deptime, String arivaltime, String efare, String bfare, String duration, String vehicle_name) {
          this.rid = rid;
          this.fromcityid = fromcityid;
          this.tocityid = tocityid;
          this.fromcity = fromcity;
          this.tocity = tocity;
          this.deptime = deptime;
          this.arivaltime = arivaltime;
          this.efare = efare;
          this.bfare = bfare;
          this.duration = duration;
          this.vehicle_name = vehicle_name;
     }
}
