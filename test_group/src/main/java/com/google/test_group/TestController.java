package com.google.test_group;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private TestService service = new TestService();

//    @GetMapping("/tickets")
//    public String test(@RequestParam Integer id){
//        return "feds";
//    }
//
//    @PostMapping("/tickets")
//    public Ticket test2(@RequestBody Ticket body){
//        body.setDest("fdsfds");
//        return body;
//    }



    @GetMapping("/tickets/all")
    public List<Ticket> printAllTicket(){
        return service.execute();
    }

    @GetMapping("/tickets/free")
    public List<Ticket> printFreeTicket(){
        return service.executeFree();
    }
    @PostMapping("tickets/reservation/{src}")
    public String reservation(@RequestBody String src, @RequestBody String dest){

        return src;
//     boolean result = service.executeReservation(src, dest);
//
//        if(result){
//            return "Билет успешно забронирован!";
//        }else {
//            return "Билета не существует или он уже был забронирован";
//        }
    }


}

class Ticket {

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
