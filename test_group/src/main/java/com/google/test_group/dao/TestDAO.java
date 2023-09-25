package com.google.test_group.dao;

import com.google.test_group.controller.Ticket;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestDAO {
    private List<Ticket> tickets = new ArrayList<>(
           List.of( new Ticket(1, "Киев", "Одесса", true),   //true - Не забронировано
            new Ticket(2, "Мариуполь", "Харьков", false),    //false - забронировано
            new Ticket(3, "Одесса", "Житомир", true))
    );
    public List<Ticket> executeAll(){
        return tickets;
    }

    public List<Ticket> executeFreeTicket(){
        List<Ticket> result = tickets.stream()
                .filter(a -> a.isBooked() == true)
                .collect(Collectors.toList());
        return result;
    }

    public boolean reservationTicket(String src, String dest){
       for(var ticket : tickets){
           if(ticket.getSrc().equals(src) && ticket.getDest().equals(dest) && ticket.isBooked() != false){
               ticket.setBooked(false);
               return true;
           }
       }

       return false;
    }
}
