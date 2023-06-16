package com.hbourgeot.todotech.controllers;

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
  public boolean getCustomerById(String username, String password) {
    return userService.findById(username, password);
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
