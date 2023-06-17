package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbourgeot.todotech.entities.Orders;
import com.hbourgeot.todotech.services.IOrdersService;

@RestController
@RequestMapping(value = "/api/orders")
public class OrdersController {
  public IOrdersService ordersService;

  public OrdersController(IOrdersService oService) {
    this.ordersService = oService;
  }

  @GetMapping(value = "/all")
  public List<Orders> getOrders() {
    return ordersService.findAll();
  }

  @GetMapping(value = "/{id}")
  public Orders getCustomerById(@PathVariable Long id) {
    return ordersService.findById(id);
  }

  @PostMapping(value = "/add")
  public void saveCustomer(@RequestBody Orders order) {
    ordersService.save(order);
  }

  @PutMapping(value = "/modify")
  public void modifyCustomer(@RequestBody Orders order) {
    ordersService.save(order);
  }
}
