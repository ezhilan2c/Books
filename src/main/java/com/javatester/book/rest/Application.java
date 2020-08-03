package com.javatester.book.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.javatester.book")
public class Application {
	
	/** Run the Spring Boot app. */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}