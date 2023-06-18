package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbourgeot.todotech.entities.Products;
import com.hbourgeot.todotech.services.IProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsRestController {

  public IProductsService productsService;
  
  public ProductsRestController(IProductsService productsService) {
    this.productsService = productsService;
  }

  @GetMapping(value="/public")
  public List<Products> showPublicProducts() {
    return (List<Products>) productsService.findAvalaible();
  }
  
  @GetMapping(value="/all")
  public List<Products> getAllProducts() {
      return (List<Products>) productsService.findAll();
  }
  
  @GetMapping(value = "/{id}")
  public Products getProductById(@PathVariable Long id) {
    return productsService.findById(id);
  }
}
