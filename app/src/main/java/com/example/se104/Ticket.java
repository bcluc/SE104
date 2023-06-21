package com.example.se104;

public class Ticket {
    private String departure_point;
    private String departure_time;
    private String flight_time;
    private String destination_point;
    private String destination_time;
    private String ticket_price;
    private String space_seat;


    public Ticket(String departure_point, String departure_time, String flight_time, String destination_point, String destination_time, String ticket_price, String space_seat) {
        this.departure_point = departure_point;
        this.departure_time = departure_time;
        this.flight_time = flight_time;
        this.destination_point = destination_point;
        this.destination_time = destination_time;
        this.ticket_price = ticket_price;
        this.space_seat = space_seat;
    }

    public String getDeparture_point() {
        return departure_point;
    }
    public void setDeparture_point(String departure_point) {
        this.departure_point = departure_point;
    }
    public String getDeparture_time() {
        return departure_time;
    }
    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }
    public String getFlight_time() {
        return flight_time;
    }
    public void setFlight_time(String flight_time) {
        this.flight_time = flight_time;
    }
    public String getDestination_point() {
        return destination_point;
    }
    public void setDestination_point(String destination_point) {
        this.destination_point = destination_point;
    }
    public String getDestination_time() {
        return destination_time;
    }
    public void setDestination_time(String destination_time) {
        this.destination_time = destination_time;
    }
    public String getTicket_price() {
        return ticket_price;
    }
    public void setTicket_price(String ticket_price) {
        this.ticket_price = ticket_price;
    }
    public String getSpace_seat() {
        return space_seat;
    }
    public void setSpace_seat(String space_seat) {
        this.space_seat = space_seat;
    }
}
