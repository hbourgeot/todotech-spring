package com.hbourgeot.todotech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbourgeot.todotech.dao.IUserRepo;
import com.hbourgeot.todotech.entities.User;

@Service
public class UserService implements IUserService{

  @Autowired
  public IUserRepo repo;

  @Override
  public void deleteById(String id) {
    // TODO Auto-generated method stub
    repo.deleteById(id);
  }

  @Override
  public User findById(String id) {
    return repo.findById(id).orElse(null);
  }

  @Override
  public void save(User user) {
    repo.save(user);
  }
  
}
