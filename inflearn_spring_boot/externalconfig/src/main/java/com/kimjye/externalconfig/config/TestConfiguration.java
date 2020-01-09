package com.kimjye.externalconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// 이 빈 설정은 test라는 profile 일때만 사용이 된다.
@Profile("test")
@Configuration
public class TestConfiguration {
    @Bean
    public String hello(){
        return "hello Test";
    }
}
