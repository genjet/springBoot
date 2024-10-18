package com.uuu.demo6.controller;


import com.uuu.demo6.entity.Customer;
import com.uuu.demo6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService service;

    @GetMapping("/all")
    List<Customer> getCustomers() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomer(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Long id) {
        return service.findOne(id);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    Customer putCustomer(@PathVariable Long id, @RequestBody Customer customer) {
//        customer.setId(id);
//        return service.update(customer);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void deleteCustomer(@PathVariable Long id) {
//        service.delete(id);
//    }
}
