package com.google.test_group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TestGroupApplication {
    public static void main(String[] args) {

        SpringApplication.run(TestGroupApplication.class, args);
    }

}
