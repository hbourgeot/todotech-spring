package com.hbourgeot.todotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.entities.Orders;
import com.hbourgeot.todotech.services.ICustomerService;
import com.hbourgeot.todotech.services.IOrdersService;

@Controller
public class OrdersController {
  public IOrdersService ordersService;
  public ICustomerService customerService;

  public OrdersController(IOrdersService oService, ICustomerService cService) {
    this.ordersService = oService;
    this.customerService = cService;
  }

  @PostMapping(value = "/orders/add")
  public String saveOrder(Orders order) {
    Customers customer = customerService.findById(order.customer.getId());
    customer.setTotalCost(customer.getTotalCost() + order.getTotalCost());
    ordersService.save(order);
    return "redirect:/dash/orders";
  }

  @PutMapping(value = "/orders/modify")
  public String modifyOrder(Orders order) {
    ordersService.save(order);
    return "redirect:/dash/orders";
  }
}
