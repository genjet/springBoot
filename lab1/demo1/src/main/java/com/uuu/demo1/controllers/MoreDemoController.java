package com.uuu.demo1.controllers;

import com.uuu.demo1.forms.Form1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoreDemoController {
    @GetMapping("/operate")
    public String list(Form1 form) {
        return "operate";
    }
}