package com.uuu.demo1.controllers;

import com.uuu.demo1.beans.Course;
import com.uuu.demo1.services.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class RootController {
    private static final String KEY1 = "message";
    private static final String KEY2 = "message2";
    private static final String INFO_KEY1 = "jcourse";
    private static final String INFO_KEY2 = "mainCourseName";

    @Value("${main.course.name}")
    private String courseName;
    @Value("${main.course.limit}")
    private Integer courseLimit;

    @GetMapping("/")
    public String home(Model m) {
        m.addAttribute(KEY1,"Hi, 在ucom上課中...");
        m.addAttribute(KEY2, "learning spring boot with vue");
        return "home";
    }

    @GetMapping("/info")
    public String info(Model m) {
        Course course = new Course();
        course.setId("SL-275");
        course.setName("Java物件導向程式設計");
        course.setDuration(30);
        course.setFee(25000);
        m.addAttribute(INFO_KEY1,course);
        m.addAttribute(INFO_KEY2,courseName);
        log.info("course limit={},{}", courseLimit, courseLimit * 2);
        return "info/contact";
    }

}