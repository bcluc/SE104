package com.maadi.flightticketbooking.models;

public class User {
    private int user_id, cityid;
        private String user_name, user_email, user_password, user_mobile, user_image, cityname, address;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(int user_id, int cityid, String user_name, String user_email, String user_password, String user_mobile, String user_image, String cityname, String address) {
        this.user_id = user_id;
        this.cityid = cityid;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_mobile = user_mobile;
        this.user_image = user_image;
        this.cityname = cityname;
        this.address = address;
    }
}
