package com.hbourgeot.todotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbourgeot.todotech.dao.ICustomersRepo;
import com.hbourgeot.todotech.entities.Customers;

@Service
public class CustomersService implements ICustomerService{

  @Autowired
  public ICustomersRepo repo;


  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    repo.deleteById(id);
  }

  @Override
  public List<Customers> findAll() {
    // TODO Auto-generated method stub
    return (List<Customers>) repo.findAll();
  }

  @Override
  public Customers findById(Long id) {
    // TODO Auto-generated method stub
    return repo.findById(id).orElse(null);
  }

  @Override
  public void save(Customers customer) {
    // TODO Auto-generated method stub
    repo.save(customer);
  }
  
}
