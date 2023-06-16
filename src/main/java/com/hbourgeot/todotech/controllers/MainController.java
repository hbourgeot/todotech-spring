package com.hbourgeot.todotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.hbourgeot.todotech.TodotechApplication;
import com.hbourgeot.todotech.entities.User;

@Controller
public class MainController {

  @Autowired
  private RestTemplate restTemplate;
  
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
    HttpHeaders headers = new HttpHeaders();
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    HttpEntity<User> entity = new HttpEntity<User>(user, headers);
    Boolean result = restTemplate.exchange("http://localhost:8080/api/login", HttpMethod.POST, entity, Boolean.class)
        .getBody();
    
    if (result.booleanValue()) {
      return "redirect:dash";
    }
    
    return "redirect:index";
  }

  @GetMapping(value = "/dash")
  public String dash() {
    return "dash";
  }
}