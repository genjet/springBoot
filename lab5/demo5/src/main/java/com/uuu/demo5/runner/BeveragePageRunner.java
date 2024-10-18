package com.uuu.demo5.runner;

import com.uuu.demo5.entity.Beverage;
import com.uuu.demo5.repository.BeverageCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Slf4j
@Order(3)
public class BeveragePageRunner implements CommandLineRunner {
    @Autowired
    private BeverageCrudRepository repository;

    @Override
    public void run(String... args) throws Exception {
        getBeverageByPage();
        getBeverageByPageOrderByPrice();
    }

    private void getBeverageByPageOrderByPrice() {
        PageRequest r1 = PageRequest.of(0, 5);
        Page<Beverage> page1 = repository.findByOrderByPriceAsc(r1);
        log.info("****total pages:{}********", page1.getTotalPages());
        page1.getContent().stream().forEach(b -> log.info("[{}],${},{}", r1.getPageNumber(), b.getPrice(), b));
        Pageable r2 = page1.nextPageable();
        Page<Beverage> page2 = repository.findByOrderByPriceAsc(r2);
        page2.getContent().stream().forEach(b -> log.info("[{}],${},{}", r2.getPageNumber(), b.getPrice(), b));
    }

    private void getBeverageByPage() {
        // get a pageable
        PageRequest r1 = PageRequest.of(0, 3);
        log.info("r1 page request={}", r1);
        log.info("r1 page number={}, size={}", r1.getPageNumber(), r1.getPageSize());
        Page<Beverage> page1 = repository.findAll(r1);
        for (Beverage b : page1.getContent()) {
            log.info("[page1]b={}", b);
        }

        Pageable r2 = page1.nextPageable();
        log.info("e2={}, number={}, size={}",r2, r2.getPageNumber(), r2.getPageSize());
        Page<Beverage> page2 = repository.findAll(r2);
        for (Beverage b : page2.getContent()) {
            log.info("[page2]b={}", b);
        }
    }
}