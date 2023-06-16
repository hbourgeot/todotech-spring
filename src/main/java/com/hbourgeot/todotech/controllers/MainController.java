package com.hbourgeot.todotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
  
  @GetMapping(value = "/")
  public String index() {
    return "index";
  }

  @GetMapping(value = "/login")
  public String login() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String postLogin(String username, String password) {
    return "redirect:index";
  }

  @GetMapping(value = "/dash")
  public String dash() {
    return "dash";
  }
}