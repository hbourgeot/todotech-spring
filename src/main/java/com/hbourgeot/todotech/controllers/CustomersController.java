package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.services.ICustomerService;

@Controller
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
  public void saveCustomer(@RequestBody Customers customer) {
    customerService.save(customer);
  }

  @PutMapping(value = "/modify")
  public void modifyCustomer(@RequestBody Customers customer) {
    customerService.save(customer);
  }
}
