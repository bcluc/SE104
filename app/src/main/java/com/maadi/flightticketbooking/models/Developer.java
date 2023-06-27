package com.maadi.flightticketbooking.models;

public class Developer {
    private String url_demo = "https://youtu.be/4LabJ-G1FuU";
    private String url_pay = "https://youtu.be/yb4TCWw_WOU";
    private String phone_number = "tel:" + "01234567";

    public Developer() {
    }

    public String getUrl_demo() {
        return url_demo;
    }

    public void setUrl_demo(String url_demo) {
        this.url_demo = url_demo;
    }

    public String getUrl_pay() {
        return url_pay;
    }

    public void setUrl_pay(String url_pay) {
        this.url_pay = url_pay;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
