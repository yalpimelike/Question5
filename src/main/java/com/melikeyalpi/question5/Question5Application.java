package com.melikeyalpi.question5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class Question5Application {

	public static void main(String[] args) {
		SpringApplication.run(Question5Application.class, args);
	}

}
