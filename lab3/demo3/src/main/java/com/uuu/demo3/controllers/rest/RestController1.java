package com.uuu.demo3.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController1 {
    @RequestMapping(path="/",method = RequestMethod.GET)
    String getHome() {
        return "[GET]Hello world home";
    }
    @RequestMapping(path="/", method = RequestMethod.POST)
    String postHome() {
        return "[POST]Hello world home";
    }
}