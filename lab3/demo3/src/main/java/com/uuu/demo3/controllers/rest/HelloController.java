package com.uuu.demo3.controllers.rest;

import com.uuu.demo3.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Message message;
    @RequestMapping("/hello")
    Message home() {
        message.setId(999);
        message.setName("Hello!");
        message.setDetail("打一些english文試試");
        return message;
    }
}