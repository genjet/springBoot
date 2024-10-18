package com.uuu.demo5.runner;

import com.uuu.demo5.repository.BeverageCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(4)
public class BeverageMultiParameterRunner implements CommandLineRunner {
    @Autowired
    private BeverageCrudRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.findByTitleAndDetailOrderByPriceAsc("Cola", "medium")
                .forEach(b -> log.info("find medium cola:{}", b));
        repository.findByTitleIgnoreCaseAndDetailOrderByPriceAsc("COLA", "medium")
                .forEach(b -> log.info("find medium *cola*:{}", b));
        repository.findByTitleAndDetailOrderByPriceAscAllIgnoreCase("COLA", "MEDIUM")
                .forEach(b -> log.info("find *medium* *cola*:{}", b));
        repository.findByTitleOrDetailOrderByPriceAscAllIgnoreCase("COLA", "MEDIUM")
                .forEach(b -> log.info("find *medium* or *cola*:{}", b));
        log.info("************************");
        repository.findByTitleLike("Latte")
                .forEach(b -> log.info("find like Latte:{}", b));
        log.info("------------------------");
        repository.findByTitleLike("%Latte%")
                .forEach(b -> log.info("find like %Latte%:{}", b));
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        repository.findByTitleContainingIgnoreCase("LATTE")
                .forEach(b -> log.info("find contains LATTE:{}", b));
        repository.findByPriceBetweenOrderByPriceAsc(50, 120)
                .forEach(b -> log.info("find between 50-120:{}", b));
    }
}