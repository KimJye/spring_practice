package com.kimjye.externalconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleRunner implements ApplicationRunner {

//    @Value("${kimjye.name}")
//    private String name;

    @Autowired
    KimjyeProperties kimjyeProperties;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=====================");
        System.out.println(kimjyeProperties.getFullName());
        System.out.println("=====================");
    }
}
