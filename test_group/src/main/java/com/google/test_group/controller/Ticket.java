package com.google.test_group.controller;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;


public class Ticket {

   private int id;
    private String src;
    private String dest;
    private boolean isBooked;


    public Ticket( Integer id, String src, String dest, boolean isBooked) {
        this.id = id;
        this.src = src;
        this.dest = dest;
        this.isBooked = isBooked;
    }

    public Ticket() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }


}
