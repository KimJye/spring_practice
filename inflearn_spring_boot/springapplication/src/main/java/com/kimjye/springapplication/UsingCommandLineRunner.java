package com.kimjye.springapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 애플리케이션이 실행된 후 무언가 실행하고 싶을 때
// JVM Argument는 무시하는 결과가 있음.
@Component
@Order(2)
public class UsingCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("using CommandLineRunner");
        Arrays.stream(args).forEach(System.out::println);
    }
}
