package com.bm.rest_web_services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestWebServicesApplication {

	private static final Logger log = LoggerFactory.getLogger(RestWebServicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesApplication.class, args);
		System.out.println("Application started");
	}

}
