package com.maadi.flightticketbooking.models;

public class PassengerModel {
    String name, age, gender, type;

    public PassengerModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PassengerModel(String name, String age, String gender, String type) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.type = type;
    }
}
