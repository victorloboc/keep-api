package com.googlekeepapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class GooglekeepApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GooglekeepApiApplication.class, args);
	}

}
