package com.kimjye.demospringbootmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /ruby/**로 요청이 들어오면 r디렉토리 밑에서 리소스를 제공하겠다.
        registry.addResourceHandler("/ruby/**")
                .addResourceLocations("classpath:/r/")
                .setCachePeriod(20);
    }
}
