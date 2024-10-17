package com.uuu.demo3.calc;

import org.springframework.stereotype.Service;


public class AddCalculator implements Calculator {
    @Override
    public int calc(int x, int y) {
        return x + y;
    }
}
