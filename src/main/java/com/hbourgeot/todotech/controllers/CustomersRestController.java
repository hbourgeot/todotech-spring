package com.hbourgeot.todotech.controllers;

import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.services.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomersRestController {
    public ICustomerService customerService;

    public CustomersRestController(ICustomerService cService) {
        this.customerService = cService;
    }

    @GetMapping(value = "/all")
    public List<Customers> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Customers getCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }
}
