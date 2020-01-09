package com.kimjye.springapplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 애플리케이션이 실행된 후 무언가 실행하고 싶을 때
// ApplicationRunner는 JVM Argument와 Application Argument 둘다 보여줌.
@Component
@Order(1)
public class UsingApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("usingApplicationRunner");
        System.out.println("foo: " + args.containsOption("foo"));
        System.out.println("bar: " + args.containsOption("bar"));
    }
}
