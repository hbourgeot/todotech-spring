package com.hbourgeot.todotech.controllers;

import com.hbourgeot.todotech.entities.Products;
import com.hbourgeot.todotech.services.IProductsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.entities.Orders;
import com.hbourgeot.todotech.services.ICustomerService;
import com.hbourgeot.todotech.services.IOrdersService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrdersController {
  public IOrdersService ordersService;
  public ICustomerService customerService;
  public IProductsService productService;

  public OrdersController(IOrdersService oService, ICustomerService cService, IProductsService pService) {
    this.ordersService = oService;
    this.customerService = cService;
    this.productService = pService;
  }

  @PostMapping(value = "/orders/add")
  public String saveOrder(Orders order, HttpServletRequest request) {
    Customers customer = customerService.findById(order.customer.getId());
    if(customer.getTotalCost() == null) {
      customer.setTotalCost(0.00);
    }

    customer.setTotalCost(customer.getTotalCost() + order.getTotalCost());

    String[] productQuantitiesString = request.getParameterValues("productQuantity");

    // Convert the productQuantity values to a List of Integer
    List<Integer> productQuantityList = Arrays.stream(productQuantitiesString)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    // Set the productQuantity list to the order object
    order.setProductQuantity(productQuantityList);

    List<Integer> productQuantities = order.getProductQuantity();
    for (int i = 0; i < order.getProducts().size(); i++) {
      Products product = order.getProducts().get(i);
      int quantity = productQuantities.get(i);

      // Update the amount of the product
      int currentAmount = product.getAmount();
      int newAmount = currentAmount - quantity;
      product.setAmount(newAmount);

      // Save the updated product
      productService.save(product);
    }

    ordersService.save(order);
    return "redirect:/dash/orders";
  }

  @PutMapping(value = "/orders/modify")
  public String modifyOrder(Orders order) {
    ordersService.save(order);
    return "redirect:/dash/orders";
  }
}
