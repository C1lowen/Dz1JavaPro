package com.google.test_group.service;

import com.google.test_group.controller.Ticket;
import com.google.test_group.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDAO testDAO;
    public List<Ticket> execute(){
        return testDAO.executeTicketsAll();
    }

    public void addNewTicket(Ticket newTicket){
        testDAO.executeNewTickets(newTicket);
    }
//
//    public List<Ticket> executeFree(){
//        return testDAO.executeFreeTicket();
//    }



//    public boolean executeReservation(String src, String dest){
//       return testDAO.reservationTicket(src, dest);
//    }
}
