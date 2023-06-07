package com.hbourgeot.todotech.services;

import java.util.List;

import com.hbourgeot.todotech.entities.Orders;

public interface IOrdersService {
  public void save(Orders order);

  public Orders findById(Long id);

  public void deleteById(Long id);

  public List<Orders> findAll();
}
