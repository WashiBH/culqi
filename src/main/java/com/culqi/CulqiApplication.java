package com.culqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CulqiApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CulqiApplication.class, args);
    }
}
