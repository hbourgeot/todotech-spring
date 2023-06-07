package com.hbourgeot.todotech.services;

import java.util.List;

import com.hbourgeot.todotech.entities.Customers;

public interface ICustomerService {
  public void save(Customers customer);

  public Customers findById(Long id);

  public void deleteById(Long id);

  public List<Customers> findAll();
}
