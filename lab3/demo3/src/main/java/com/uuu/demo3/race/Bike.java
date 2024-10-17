package com.uuu.demo3.race;

import org.springframework.stereotype.Component;


@Component("bike")
public class Bike implements Racing {
    @Override
    public String status() {
        return "80km/minute";
    }
}