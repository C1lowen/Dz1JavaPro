package com.example.test_spring_varied;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication

public class TestSpringVariedApplication {

    public static void main(String[] args) throws Exception{

//        ApplicationContext applicationContext = SpringApplication.run(TestSpringVariedApplication.class);
//
//        Map<String, MyService> beansOfType = applicationContext.getBeansOfType(MyService.class);
//        System.out.println(1);


//        Context context = new Context(AppConfig.class);
//
//        System.out.println(context.getBean(MyController.class));
//
//        MyController controller = context.getBean(MyController.class);
//
//
//        MyServiceRel myServiceRel = context.getBean(MyServiceRel.class);
//
//        MyService myService = context.getBean(MyService.class);

        System.out.println(Integer.bitCount(1));
        System.out.println(Integer.bitCount(2));
        System.out.println(Integer.bitCount(3));






//        MyServiceRel myService = context.getBean(MyServiceRel.class);
//        myService.sayMyServiceRel();

    }

}
