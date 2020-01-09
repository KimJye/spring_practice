package com.kimjye.externalconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ExternalconfigApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ExternalconfigApplication.class);
        app.run(args);
    }

}
