package com.uuu.demo3.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(Model model, @RequestParam(value="name", required = false, defaultValue = "ucom 14f") String name) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
