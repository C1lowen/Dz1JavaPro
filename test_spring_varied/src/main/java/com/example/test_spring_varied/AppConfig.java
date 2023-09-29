package com.example.test_spring_varied;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class AppConfig {



    @Bean("newBean")
    public MyService myService() {
        return new MyServiceRel();
    }

    @Bean
    MyController myService2(){
        return new MyController();
    }

}
