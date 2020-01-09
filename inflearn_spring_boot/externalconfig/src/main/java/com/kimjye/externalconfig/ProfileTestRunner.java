package com.kimjye.externalconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ProfileTestRunner implements ApplicationRunner {

    @Autowired
    private String hello;

    @Autowired
    KimjyeProperties kimjyeProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=====================");
        System.out.println(hello);
        System.out.println(kimjyeProperties.getName());
        System.out.println("=====================");
    }
}
