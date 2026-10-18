package com.BM.AOP;

import com.BM.AOP.example.BusinessService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    private final BusinessService businessService;

    public AopApplication(BusinessService businessService) {
        this.businessService = businessService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    public void run(String... args) {
        businessService.calculateMax();
    }


}
