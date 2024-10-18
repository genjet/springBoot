package com.uuu.demo6.runner;

import com.uuu.demo6.entity.Customer;
import com.uuu.demo6.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class CustomerRunner implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer();
        c1.setFirstName("Andy");
        c1.setLastName("Wang");
        //c1.setId(0);
        repository.save(c1);
        //repository.findAll().forEach(c -> log.info("get customer:{}", c));
        initDefaultData();
        callJPQLQuery();
    }

    private void initDefaultData() {
        repository.save(new Customer(0L, "Peter", "Ho"));
        repository.save(new Customer(0L, "James", "Liu"));
        repository.save(new Customer(0L, "Peter", "Chen"));
        repository.save(new Customer(0L, "Peter", "Lee"));
        repository.save(new Customer(0L, "Jimmy", "Lee"));
        repository.save(new Customer(0L, "Abby", "Lin"));
        repository.save(new Customer(0L, "Abby", "Fang"));
    }

    private void callJPQLQuery() {
        repository.findAllOrderByName().forEach(c ->
                log.info("order by name, customer={}", c));
    }
}
