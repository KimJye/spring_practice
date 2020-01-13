package com.kimjye.demospringaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemospringaopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemospringaopApplication.class, args);
    }

    @Bean
    public String kimjye() {return "kimjye Bean";}
}
