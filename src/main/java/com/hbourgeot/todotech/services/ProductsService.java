package com.hbourgeot.todotech.services;

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

  @Override
  public void save(Products product) {
    repo.save(product);
    
  }
  
}
