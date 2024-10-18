package com.uuu.demo6.repository;


import com.uuu.demo6.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerSimpleRepository extends CrudRepository<Customer, Long> {
}
