package com.kimjye.springapplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class PrintArgument {
    public PrintArgument(ApplicationArguments arguments){
        // --로 오는 것만!
        System.out.println("print Arguments");
        System.out.println("foo: " + arguments.containsOption("foo"));
        System.out.println("bar: " + arguments.containsOption("bar"));
    }
}
