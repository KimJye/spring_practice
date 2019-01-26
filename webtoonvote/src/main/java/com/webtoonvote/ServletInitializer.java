package com.webtoonvote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.webtoonvote.properties.StorageProperties;
import com.webtoonvote.service.StorageService;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebtoonvoteApplication.class);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args)->{
			//storageService.deleteAll();
			storageService.init();
		};
	}
}
