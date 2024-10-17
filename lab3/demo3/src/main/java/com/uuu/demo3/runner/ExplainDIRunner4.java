package com.uuu.demo3.runner;

import com.uuu.demo3.calc.Calculator;
import com.uuu.demo3.race.Racing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(4)
public class ExplainDIRunner4 implements CommandLineRunner {
    @Autowired
    @Qualifier("bicycle")
    private Racing racing1;
    @Autowired
    @Qualifier("bike")
    private Racing racing2;
    @Override
    public void run(String... args) throws Exception {
        log.info("racing1 status={}", racing1.status());
        log.info("racing2 status={}", racing2.status());
    }
}