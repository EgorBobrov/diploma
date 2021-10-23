package com.egobob.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DiplomaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DiplomaApplication.class, args);
	}

}
