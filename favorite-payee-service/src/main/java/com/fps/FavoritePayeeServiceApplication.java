package com.fps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.fps.entities"})
@ComponentScan(basePackages = { "com.fps"})
@EnableAutoConfiguration
public class FavoritePayeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoritePayeeServiceApplication.class, args);
	}
	
}
