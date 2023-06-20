package com.example.se104;

public class object_Airline_Brand {
    private String ID;
    private String Name;
    private String Phone;
    private String Number;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public object_Airline_Brand(String ID, String name, String phone, String number) {
        this.ID = ID;
        Name = name;
        Phone = phone;
        Number = number;
    }
}
