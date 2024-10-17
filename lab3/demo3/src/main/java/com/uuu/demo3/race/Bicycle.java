package com.uuu.demo3.race;

import org.springframework.stereotype.Component;


@Component("bicycle")
public class Bicycle implements Racing{
    @Override
    public String status() {
        return "2km/minute";
    }
}