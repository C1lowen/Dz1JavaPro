package com.example.test_spring_varied;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication

public class TestSpringVariedApplication {

    public static void main(String[] args) throws Exception{


        Context context = new Context(AppConfig.class);



//        MyController controller = context.getBean(MyController.class, "myController");
//        controller.sayMyController();


        MyServiceRel myServiceRel = context.getBean(MyServiceRel.class, "fsdfsd");
        myServiceRel.sayMyServiceRel();

        MyService myService = context.getBean(MyService.class, "myService");








//        MyServiceRel myService = context.getBean(MyServiceRel.class);
//        myService.sayMyServiceRel();

    }

}
