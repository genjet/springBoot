package com.uuu.demo5.runner;

import com.uuu.demo5.entity.Beverage;
import com.uuu.demo5.repository.BeverageCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(2)
public class MoreBeverageCRUDRunner implements CommandLineRunner {
    private final BeverageCrudRepository repository;

    public MoreBeverageCRUDRunner(BeverageCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("get repository by constructor,{}", repository);
        listBeverageOrderByPrice();
        listBeverageOrderByPriceDesc();
        listOnlyCola();
        listOnlyColaOrderByPrice();
        callCount();
        listOnlyColaIgnoreCase();
    }

    private void listOnlyColaIgnoreCase() {
        repository.findMatchByTitleIgnoreCaseOrderByPriceAsc("cola").stream()
                .forEach(b -> log.info("find cola case ignored:{}", b));
    }

    private void callCount() {
        log.info("beverage with Cola count={}", repository.countByTitle("Cola"));
    }

    private void listOnlyColaOrderByPrice() {
        repository.findMatchByTitleOrderByPriceAsc("Cola")
                .forEach(b -> log.info("[{}]cola only using stream:{}", b.getPrice(), b));

    }

    private void listOnlyCola() {
        for (Beverage b : repository.findMatchByTitle("Cola")) {
            log.info("cola only:{}", b);
        }
    }

    private void listBeverageOrderByPriceDesc() {
        for (Beverage b : repository.findByOrderByPriceDesc()) {
            log.info("[{}] sort by price ascending:{}", b.getPrice(), b);
        }
    }

    private void listBeverageOrderByPrice() {
        for (Beverage b : repository.findByOrderByPriceAsc()) {
            log.info("[{}] sort by price ascending:{}", b.getPrice(), b);
        }
    }
}