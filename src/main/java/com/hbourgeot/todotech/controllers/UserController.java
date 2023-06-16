package com.hbourgeot.todotech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping(value = "/{id}")
  public User getCustomerById(@PathVariable String id) {
    return userService.findById(id);
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
