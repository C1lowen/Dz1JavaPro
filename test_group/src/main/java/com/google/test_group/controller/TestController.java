package com.google.test_group.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.google.test_group.service.TestService;

import java.util.List;

@RestController
public class TestController {
    private TestService service = new TestService();


    @GetMapping("/tickets/all")
    public List<Ticket> printAllTicket() {
        return service.execute();
    }

    @GetMapping("/tickets/free")
    public List<Ticket> printFreeTicket() {
        return service.executeFree();
    }


//    @PostMapping("tickets/reservation/{src}/{dest}")
//    public String reservation(@PathVariable String src, @PathVariable String dest){ //1 способ

//     boolean result = service.executeReservation(src, dest);
//
//        if(result){
//            return "Билет успешно забронирован!";
//        }else {
//            return "Билета не существует или он уже был забронирован";
//        }
//    }

//    @PostMapping("tickets/reservation")
//    public String reservation2(@RequestBody Map<String, String> data) {                    //2 способ
//
//        boolean result = service.executeReservation(data.get("src"), data.get("dest"));
//
//        if (result) {
//            return "Билет успешно забронирован!";
//        } else {
//            return "Билета не существует или он уже был забронирован";
//        }
//    }


    @PostMapping("tickets/reservation")
    public String reservation3(@RequestBody ReservationRequest data) {        //3 способ             //2 способ

        boolean result = service.executeReservation(data.getSrc(), data.getDest());

        if (result) {
            return "Билет успешно забронирован!";
        } else {
            return "Билета не существует или он уже был забронирован";
        }
    }
}
