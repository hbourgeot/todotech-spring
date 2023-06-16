package com.hbourgeot.todotech.services;

import com.hbourgeot.todotech.entities.User;

public interface IUserService {
  public void save(User customer);

  public User findById(String id);

  public void deleteById(String id);
}
