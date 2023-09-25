package com.example.test_spring_varied;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TestSpringVariedApplication {

    public static void main(String[] args) throws Exception{

        Context context = new Context(AppConfig.class);

        System.out.println(context.getBean(MyController.class));

        MyController controller = context.getBean(MyController.class);
        controller.sayMyController();

        MyServiceRel myService = context.getBean(MyServiceRel.class);
        myService.sayMyServiceRel();
    }

}
