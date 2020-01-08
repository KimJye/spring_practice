package com.kimjye;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ruby")
public class RubyProperties {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
}
