package com.uuu.demo6.service;

import com.uuu.demo6.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer create(Customer customer);

    Customer update(Customer customer);

    void delete(Long id);
}