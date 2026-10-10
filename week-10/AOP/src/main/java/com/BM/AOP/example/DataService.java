package com.BM.AOP.example;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class DataService {
    public int[] getData() {
        return new int[]{1,2,3,4,5};
    }
}
