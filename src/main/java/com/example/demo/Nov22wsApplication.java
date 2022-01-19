package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tutorial.webservice.rest")
public class Nov22wsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Nov22wsApplication.class, args);
	}

}
