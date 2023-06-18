package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @GetMapping(value = "/{id}")
  public Customers getCustomerById(@PathVariable Long id) {
    return customerService.findById(id);
  }

  @PostMapping(value = "/add")
  public String saveCustomer(Customers customer) {
    customerService.save(customer);
    return "redirect:/dash/customers";
  }

  @PutMapping(value = "/modify")
  public String modifyCustomer(Customers customer) {
    customerService.save(customer);
    return "redirect:/dash/customers";
  }
}
