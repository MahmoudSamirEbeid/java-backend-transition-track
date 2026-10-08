package com.BM.AOP.example;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {
    private final DataService dataService;

    public BusinessService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateMax() {
        int[] data = dataService.getData();
        return Arrays.stream(data).max().orElse(0);
    }
}
