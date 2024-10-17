package com.uuu.demo3.runner;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
@Slf4j
public class ExplainLog implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(ExplainLog.class.getName());
    //private static final Logger LOG = LoggerFactory.getLogger(ExplainLog.class.getSimpleName());

    @Override
    public void run(String... args) throws Exception {
        System.out.println("this is a log");
        LOG.info("this is a LOG info log");
        log.trace("this is a trace log");
        log.debug("this is a debug log");
        log.info("this is a info log");
        log.warn("this is a warn log");
        log.error("this is a error log");
    }
}