package com.uuu.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/info")
    public String info() {
        return "info/contact";
    }
}