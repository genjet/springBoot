package com.uuu.demo3.runner;

import com.uuu.demo3.race.Racing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(3)
public class ExplainDIRunner3 implements CommandLineRunner {
    private final ApplicationContext context;

    public ExplainDIRunner3(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        Racing r1 = context.getBean("bicycle", Racing.class);
        log.info("r1 status={}", r1.status());
        Racing r2 = context.getBean("bike", Racing.class);
        log.info("r2 status={}", r2.status());
    }
}

