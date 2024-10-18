package com.uuu.demo5.runner;

import com.uuu.demo5.entity.Beverage;
import com.uuu.demo5.repository.BeverageCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Slf4j
@Order(1)
public class BeverageCRUDRunner implements CommandLineRunner {
    @Autowired
    private BeverageCrudRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("repository as:{}", repository);
        init();
        dumpRepository("init");
        modifyRepository();
        dumpRepository("update1");
        deleteFromRepository();
        dumpRepository("delete1");
    }

    private void deleteFromRepository() {
//        repository.deleteById(1L);
//        repository.deleteById(3L);
        repository.deleteAllById(Arrays.asList(1L,3L));
    }
    private void modifyRepository() {
        Optional<Beverage> optionalBeverage = repository.findById(3L);
        if (optionalBeverage.isPresent()) {
            Beverage b = optionalBeverage.get();
            b.setTitle("Venti Hot Coffee");
            repository.save(b);

        }
    }

    private void dumpRepository(String label) {
        for (Beverage b : repository.findAll()) {
            log.info("[{}]a beverage={}", label, b);
        }
    }

    private void init() {
        Beverage b1 = new Beverage();
        b1.setTitle("Tall Ice Coffee");
        b1.setDetail("ice american");
        b1.setSugar(0.0f);
        b1.setPrice(150);
        Beverage b2 = new Beverage();
        b2.setTitle("Hot Grande Latte");
        b2.setDetail("3 shot espressos+70% hotmilk+....");
        b2.setSugar(0.0f);
        b2.setPrice(200);
        Beverage b3 = new Beverage();
        b3.setTitle("Tall Hot Coffee");
        b3.setDetail("hot americano");
        b3.setSugar(0.0f);
        b3.setPrice(120);
        Beverage b4 = new Beverage();
        b4.setTitle("Ice Grande Latte");
        b4.setDetail("3 shot espresso+60% fresh milk+ ice");
        b4.setSugar(0.0f);
        b4.setPrice(210);
        Beverage b5 = new Beverage();
        b5.setTitle("Cola");
        b5.setPrice(30);
        b5.setDetail("small");
        Beverage b6 = new Beverage();
        b6.setTitle("Cola");
        b6.setPrice(40);
        b6.setDetail("medium");
        Beverage b7 = new Beverage();
        b7.setTitle("Cola");
        b7.setPrice(50);
        b7.setDetail("large");
        Beverage b8 = new Beverage();
        b8.setTitle("Ice Tea");
        b8.setPrice(35);
        b8.setDetail("small");
        Beverage b9 = new Beverage();
        b9.setTitle("Ice Tea");
        b9.setPrice(45);
        b9.setDetail("medium");
        Beverage b10 = new Beverage();
        b10.setTitle("Ice Tea");
        b10.setPrice(55);
        b10.setDetail("large");
        repository.save(b1);
        repository.save(b2);
        repository.save(b3);
        repository.save(b4);
        repository.save(b5);
        repository.save(b6);
        repository.save(b7);
        repository.save(b8);
        repository.save(b9);
        repository.save(b10);
    }
}