package com.google.test_group.controller;


public class Ticket {

    Integer id;
    String src;
    String dest;
    boolean isBooked;


    public Ticket(Integer id, String src, String dest, boolean isBooked) {
        this.id = id;
        this.src = src;
        this.dest = dest;
        this.isBooked = isBooked;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
