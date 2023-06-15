package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.services.ICustomerService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomersController {
  public ICustomerService customerService;

  public CustomersController(ICustomerService cService) {
    this.customerService = cService;
  }

  @GetMapping(value = "/all")
  public List<Customers> getCustomers() {
    return customerService.findAll();
  }
}
