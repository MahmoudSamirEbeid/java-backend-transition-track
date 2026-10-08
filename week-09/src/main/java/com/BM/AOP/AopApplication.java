package com.BM.AOP;

import com.BM.AOP.example.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final BusinessService businessService;

    public AopApplication(BusinessService businessService) {
        this.businessService = businessService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

	public void run(String... args) {
        logger.info("BusinessService.getBusinessData() = {}", businessService.getBusinessData());
    }


}
