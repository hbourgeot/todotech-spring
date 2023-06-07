package com.hbourgeot.todotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbourgeot.todotech.dao.IOrdersRepo;
import com.hbourgeot.todotech.entities.Orders;

@Service
public class OrdersService implements IOrdersService {

  @Autowired
  public IOrdersRepo repo;

  @Override
  public void deleteById(Long id) {
    repo.deleteById(id);

  }

  @Override
  public List<Orders> findAll() {
    // TODO Auto-generated method stub
    return (List<Orders>) repo.findAll();
  }

  @Override
  public Orders findById(Long id) {
    // TODO Auto-generated method stub
    return repo.findById(id).orElse(null);
  }

  @Override
  public void save(Orders order) {
    repo.save(order);

  }

}
