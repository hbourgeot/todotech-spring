package com.hbourgeot.todotech.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hbourgeot.todotech.dao.IUserRepo;
import com.hbourgeot.todotech.entities.User;

@Service
public class UserService implements IUserService {

  @Autowired
  public IUserRepo repo;

  private final PasswordEncoder passwordEncoder;

  public UserService(IUserRepo rep0) {
    this.repo = rep0;
    this.passwordEncoder = new BCryptPasswordEncoder(10);
  }

  @Override
  public void deleteById(String id) {
    // TODO Auto-generated method stub
    repo.deleteById(id);
  }

  @Override
  public boolean findById(String id, String password) {
    User user = repo.findById(id).orElse(null);
    if (user != null) {
      System.out.println("The encoded password: " + user.getPassword());
      System.out.println("The password: " + password);
      if (this.passwordEncoder.matches(password, user.getPassword())) {
        return true;
      }
    } else {
      return false;
    }

    return false;
  }

  @Override
  public void save(User user) {
    String encoderPassword = this.passwordEncoder.encode(user.getPassword());
    System.out.println("The password: " + user.getPassword());
    user.setPassword(encoderPassword);
    repo.save(user);
  }

}
