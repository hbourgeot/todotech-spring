package com.hbourgeot.todotech.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbourgeot.todotech.entities.User;
import com.hbourgeot.todotech.services.IUserService;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {
  public IUserService userService;

  public UserController(IUserService uService) {
    this.userService = uService;
  }

  @PostMapping(value = "/login")
  public boolean getCustomerById(HttpEntity<User> user) {
    System.out.println(user.getBody().getUsername() + " " + user.getBody().getPassword());
    return userService.findById(user.getBody().getUsername(), user.getBody().getPassword());
  }

  @PostMapping(value = "/add")
  public void saveUser(User user) {
    userService.save(user);
  }

  @PutMapping(value = "/modify")
  public void modifyUser(User user) {
    userService.save(user);
  }
}
