package com.hbourgeot.todotech.services;

import com.hbourgeot.todotech.entities.Products;

import java.util.List;

public interface IProductsService {
  public void save(Products product);

  public Products findById(Long id);

  public void deleteById(Long id);

  public List<Products> findAll();

  public List<Products> findAvalaible();
}
