package com.google.test_group;

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
