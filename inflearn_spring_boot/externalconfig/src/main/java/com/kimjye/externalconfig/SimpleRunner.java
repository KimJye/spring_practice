package com.kimjye.externalconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SimpleRunner implements ApplicationRunner {

//    @Value("${kimjye.name}")
//    private String name;

    @Autowired
    KimjyeProperties kimjyeProperties;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=====================");
        System.out.println(kimjyeProperties.getName());
        System.out.println("=====================");
    }
}
