package com.kimjye;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자동 설정파일(Configuration 파일 작성)
// 이후 src/main/resource에 META-INF 안에 spring.factories 만들기
// spring.factories안에 자동설정파일 추가
// @ConditinalOnMissingBean 사용 이유는 ComponentScan에서 설정된 빈을 우선시하기위함이다.
// 즉 이미 빈이 있으면 AutoConfiguration 단계에서 빈을 다시 등록하지 않도록 설정한다.
@Configuration
@EnableConfigurationProperties(RubyProperties.class)
public class RubyConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Ruby ruby(RubyProperties rubyProperties){
        Ruby ruby = new Ruby();
        ruby.setName(rubyProperties.getName());
        ruby.setAge(rubyProperties.getAge());
        return ruby;
    }
}
