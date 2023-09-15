package com.google.test_group.service;

import com.google.test_group.controller.Ticket;
import com.google.test_group.dao.TestDAO;


import java.util.List;

public class TestService {
    private TestDAO testDAO = new TestDAO();
    public List<Ticket> execute(){
        return testDAO.executeAll();
    }

    public List<Ticket> executeFree(){
        return testDAO.executeFreeTicket();
    }

    public boolean executeReservation(String src, String dest){
       return testDAO.reservationTicket(src, dest);
    }
}
