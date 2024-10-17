package com.uuu.demo3.controllers.rest;

import com.uuu.demo3.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class WelcomeController {
    @Autowired
    private Message m;
    @RequestMapping("/welcome")
    Message home() {
        m.setCost(3.45f);
        m.setValid(true);
        m.setDate(new Date());
        m.setDetail("打一些中文試試");
        return m;
    }
}