package com.hbourgeot.todotech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbourgeot.todotech.dao.IProductsRepo;
import com.hbourgeot.todotech.entities.Products;

@Service
public class ProductsService implements IProductsService {

  @Autowired
  public IProductsRepo repo;

  @Override
  public void deleteById(Long id) {
    repo.deleteById(id);
  }

  @Override
  public List<Products> findAll() {
    return (List<Products>) repo.findAll();
  }

  @Override
  public Products findById(Long id) {
    // TODO Auto-generated method stub
    return repo.findById(id).orElse(null);
  }

  public List<Products> findAvalaible() {
    // TODO Auto-generated method stub
    List<Products> allProducts = (List<Products>) repo.findAll(), products = new ArrayList<>();

    for (int i = 0; i < allProducts.size(); i++) {
      Products product = allProducts.get(i);
      if (product.getAmount() != 0) {
        products.add(i, product);
      }
    }
    return products;
  }

  @Override
  public Products save(Products product) {
    return repo.save(product);
  }
  
}
