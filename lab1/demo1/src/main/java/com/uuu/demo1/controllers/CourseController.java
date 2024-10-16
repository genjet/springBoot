package com.uuu.demo1.controllers;

import com.uuu.demo1.forms.CourseForm;
import com.uuu.demo1.forms.Form1;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@Slf4j
public class CourseController implements WebMvcConfigurer {

    @GetMapping("/course")
    public String showCourseForm(CourseForm f, Form1 f1, Model model) {
        CourseForm f2 = new CourseForm();
        f2.setCourseId("PYKT");
        f2.setCourseName("Python keras and tensorflow");
        f2.setDuration(400);
        model.addAttribute("course2",f2);
        model.addAttribute("form2",new Form1());
        return "courseForm";
    }

    @PostMapping("/course")
    public String handleFormSubmit(@Valid CourseForm f, BindingResult result) {
        log.info("get course object as:{}", f);
        if (result.hasErrors()) {
            return "courseForm";
        }
        return "redirect:/result";

    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
        WebMvcConfigurer.super.addViewControllers(registry);
    }
}