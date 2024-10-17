package com.uuu.demo2.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PropertyCheckRunner implements CommandLineRunner {
    @Value("${spring.profiles.active}")
    private String profile;
    @Value("${greeting}")
    private String greeting;
    @Value("${setoo}")
    private String setoo;

    @Override
    public void run(String... args) throws Exception {
        log.info("call command line runner after process setup");
        log.info("[1] current profile is: {}", profile);
        log.info("[2] greeting message is: {}", greeting);
        log.info("[3] test message is: {}", setoo);
    }
}