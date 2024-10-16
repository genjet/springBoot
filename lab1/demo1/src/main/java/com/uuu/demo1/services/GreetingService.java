package com.uuu.demo1.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "Hello, this is the first spring boot service";
    }

}