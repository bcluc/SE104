package com.maadi.flightticketbooking.models;

public class Banner {
    int id,p_id;
    String image;

    public Banner(int id, int p_id, String image) {
        this.id = id;
        this.p_id = p_id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
