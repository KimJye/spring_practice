package com.kimjye.demospringcorsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemospringcorsserverApplication {

//    @CrossOrigin("http://localhost:18080")
    @GetMapping("/hello")
    public String hello(){return "hello";}

    public static void main(String[] args) {
        SpringApplication.run(DemospringcorsserverApplication.class, args);
    }

}
