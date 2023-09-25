package com.example.test_spring_varied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyController {
    @Autowired
    private MyService myService;


    public void sayMyController(){
        System.out.println("MyController " + myService);
    }
}
