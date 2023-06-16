package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebJpa1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebJpa1Application.class, args);
		System.out.print("HelloWorld");
	}

}
