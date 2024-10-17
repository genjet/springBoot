package com.uuu.demo3.runner;

import com.uuu.demo3.calc.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class ExplainDIRunner implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        log.info("will expalin dependency injection(DI) here");
        log.info("spring context={}", context);
        Calculator c1 = context.getBean("add", Calculator.class);
        log.info("[c1]calculate 1 and 2 is:{}", c1.calc(1, 2));
        Calculator c2 = context.getBean("sub", Calculator.class);
        log.info("[c2]calculate 1 and 2 is:{}", c2.calc(1, 2));

    }
}
