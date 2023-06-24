package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.services.ICustomerService;

@Controller
@RequestMapping(value = "/customers")
public class CustomersController {
  public ICustomerService customerService;

  public CustomersController(ICustomerService cService) {
    this.customerService = cService;
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
