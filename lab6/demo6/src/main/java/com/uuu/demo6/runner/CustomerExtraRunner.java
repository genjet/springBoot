package com.uuu.demo6.runner;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(2)
public class CustomerExtraRunner implements CommandLineRunner {
    @Autowired
    private EntityManager manager;

    @Override
    public void run(String... args) throws Exception {

    }


}
