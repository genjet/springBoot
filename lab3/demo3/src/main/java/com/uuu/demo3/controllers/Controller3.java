package com.uuu.demo3.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller3 {

    @GetMapping("/session1")
    public String session1(HttpSession session) {
        session.setAttribute("key1", "session 1 to set");
        return "session_list";
    }
}