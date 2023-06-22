package com.maadi.flightticketbooking.models;

public class City {
    private String cityname;
    private  int cityid;

    public City() {
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public City(String cityname, int cityid) {
        this.cityname = cityname;
        this.cityid = cityid;
    }
}
