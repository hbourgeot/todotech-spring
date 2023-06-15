package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hbourgeot.todotech.entities.Products;
import com.hbourgeot.todotech.services.IProductsService;


@RestController
@RequestMapping("/api/products")
public class ProductsController {

  public IProductsService productsService;
  
  public ProductsController(IProductsService productsService) {
    this.productsService = productsService;
  }

  @GetMapping(value="/public")
  public List<Products> showPublicProducts() {
    return (List<Products>) productsService.findAvalaible();
  }
  
  @GetMapping(value="/all")
  public List<Products> getAllProducts(@RequestParam String param) {
      return (List<Products>) productsService.findAll();
  }
  
  @GetMapping(value="<id>")
  public Products getProductById(@PathVariable Long id) {
    return productsService.findById(id);
  }

  @PostMapping(value = "/add")
  public void addProduct(Products product) {
    productsService.save(product);
  }

  @PutMapping(value = "/modify")
  public void modifyProduct(Products product) {
    productsService.save(product);
  }
}
