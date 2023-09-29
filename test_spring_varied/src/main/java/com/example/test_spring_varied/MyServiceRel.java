package com.example.test_spring_varied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("fsdfsd")
@Primary
public class MyServiceRel implements MyService {

    @Override
    public void sayMyServiceRel() {
        System.out.println("sayMyServiceRel");
    }
}
