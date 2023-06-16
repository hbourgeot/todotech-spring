package com.hbourgeot.todotech.services;

import com.hbourgeot.todotech.entities.User;

public interface IUserService {
  public void save(User customer);

  public boolean findById(String id, String password);

  public void deleteById(String id);
}
