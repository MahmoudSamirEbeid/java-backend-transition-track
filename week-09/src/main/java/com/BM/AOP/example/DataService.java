package com.BM.AOP.example;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    public int[] getData() {
        return new int[]{1,2,3,4,5};
    }
}
