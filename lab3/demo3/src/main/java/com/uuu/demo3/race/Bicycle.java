package com.uuu.demo3.race;

import org.springframework.stereotype.Component;

@Component
public class Bicycle implements Racing{
    @Override
    public String status() {
        return "2km/minute";
    }
}