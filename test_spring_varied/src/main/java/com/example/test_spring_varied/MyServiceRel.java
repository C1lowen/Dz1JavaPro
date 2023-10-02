package com.example.test_spring_varied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("fsdfsd")
@Primary
public class MyServiceRel implements MyService {
    @Timing
    @Override
    public void sayMyServiceRel() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sayMyServiceRel");
    }
}
