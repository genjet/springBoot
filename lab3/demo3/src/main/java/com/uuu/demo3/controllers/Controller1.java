package com.uuu.demo3.controllers;

import com.uuu.demo3.counter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {
    @Autowired
    private Counter1 counter1;
    @Autowired
    private Counter2 counter2;
    @Autowired
    private Counter3 counter3;
    @Autowired
    private Counter4 counter4;
    @Autowired
    private Counter5 counter5;

    @GetMapping("/list1")
    public String list1(Model m) {
        counter1.setValue(counter1.getValue() + 1);
        counter2.setValue(counter2.getValue() + 1);
        counter3.setValue(counter3.getValue() + 1);
        counter4.setValue(counter4.getValue() + 1);
        counter5.setValue(counter5.getValue() + 1);
        m.addAttribute("c1", counter1.getValue());
        m.addAttribute("c2", counter2.getValue());
        m.addAttribute("c3", counter3.getValue());
        m.addAttribute("c4", counter4.getValue());
        m.addAttribute("c5", counter5.getValue());

        return "list";
    }
}