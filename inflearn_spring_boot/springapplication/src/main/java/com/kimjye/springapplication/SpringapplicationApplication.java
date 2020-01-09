package com.kimjye.springapplication;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringapplicationApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringapplicationApplication.class, args);
        SpringApplication application = new SpringApplication(SpringapplicationApplication.class);

        // 기본적으로 서블릿이 있으면 타입이 Servlet이다.
        application.setWebApplicationType(WebApplicationType.NONE);

        // 배너 끄기
        application.setBannerMode(Banner.Mode.OFF);

        // SimpleListener의 리스닝 시점이 ApplicationStartingEvent이기 때문에 빈으로 등록해도 리스너가 잘 동작하지 않아서
        // 직접 등록을 이렇게 해줘야만 리스너가 정상적으로 작동한다.
//        application.addListeners(new SimpleListener());
        application.run(args);
    }

}
