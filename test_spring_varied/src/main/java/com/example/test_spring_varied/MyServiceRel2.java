package com.example.test_spring_varied;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MyServiceRel2 implements MyService {

    @Override
    public void sayMyServiceRel() {
        System.out.println("sayMyServiceRel2");
    }
}
