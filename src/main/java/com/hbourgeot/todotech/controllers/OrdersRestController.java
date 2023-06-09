package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbourgeot.todotech.entities.Orders;
import com.hbourgeot.todotech.services.IOrdersService;

@RestController
@RequestMapping(value = "/api/orders")
public class OrdersRestController {
  public IOrdersService ordersService;

  public OrdersRestController(IOrdersService oService) {
    this.ordersService = oService;
  }

  @GetMapping(value = "/all")
  @ResponseBody
  public List<Orders> getOrders() {
    return ordersService.findAll();
  }

  @GetMapping(value = "/{id}")
  public Orders getOrderById(@PathVariable Long id) {
    return ordersService.findById(id);
  }
}
