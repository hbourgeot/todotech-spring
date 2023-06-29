package com.hbourgeot.todotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.services.ICustomerService;

// with requestmapping, we put this controller at localhost:8080/customers
@Controller
@RequestMapping(value = "/customers")
public class CustomersController {
  //service
  public ICustomerService customerService;

  //constructor
  public CustomersController(ICustomerService cService) {
    this.customerService = cService;
  }

  // methods

  // add customer
  @PostMapping(value = "/add")
  public String saveCustomer(Customers customer) {
    customerService.save(customer);
    return "redirect:/dash/customers";
  }

  //modify customer
  @PutMapping(value = "/modify")
  public String modifyCustomer(Customers customer) {
    customerService.save(customer);
    return "redirect:/dash/customers";
  }
}
