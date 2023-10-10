package com.google.test_group.controller;


import com.google.test_group.dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.google.test_group.service.TestService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestController {
    private TestService service = new TestService();


    @GetMapping("/tickets/all")
    public List<Ticket> printAllTicket() {
        return service.execute();
    }

    @PostMapping("/tickets/add")
    public void addTicket(@RequestBody Ticket ticket) {
        service.addNewTicket(ticket);
    }

//    @GetMapping("/tickets/free")
//    public List<Ticket> printFreeTicket() {
//        return service.executeFree();
//    }




    @GetMapping("/tickets/headers")
    public String test(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("boo");
    }

    @GetMapping("/tickets/headers2")
    public String test2(@RequestHeader("Custom-Header") String httpServletRequest) {
        return "boo = " + httpServletRequest;
    }

    @GetMapping("/tickets/custom-headers")
    public ResponseEntity<String> getResponseWithHeaders() {
       String responseBody = "This response has custom headers";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CustomValue");

        return ResponseEntity.ok()
                .headers(headers)
                .body(responseBody);
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


//    @PostMapping("tickets/reservation")
//    public String reservation3(@RequestBody @Validated ReservationRequest data) {        //3 способ
//
//        boolean result = service.executeReservation(data.getSrc(), data.getDest());
//
//        if (result) {
//            return "Билет успешно забронирован!";
//        } else {
//            return "Билета не существует или он уже был забронирован";
//        }
//    }
}
