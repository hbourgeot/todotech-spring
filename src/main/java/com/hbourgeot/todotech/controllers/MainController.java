package com.hbourgeot.todotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.hbourgeot.todotech.entities.User;

import jakarta.validation.Valid;

@Controller
public class MainController {

  @Autowired
  private RestTemplate restTemplate;
  
  @GetMapping(value = "/")
  public String index() {
    return "index";
  }

  @GetMapping(value = "/login")
  public String login(Model model) {
    model.addAttribute("title", "Login - TodoTech");
    model.addAttribute("user", new User());
    return "login";
  }

  @PostMapping(value = "/login")
  public String postLogin(Model model, @Valid @ModelAttribute(name = "user") User user) {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<User> entity = new HttpEntity<User>(user, headers);
    Boolean result = restTemplate.exchange("http://localhost:8080/api/users/login", HttpMethod.POST, entity, Boolean.class)
        .getBody();
    
    if (result.booleanValue()) {
      return "redirect:dash";
    }

    model.addAttribute("error", "Error submiting");
    
    return "login";
  }

  @GetMapping(value = "/dash")
  public String dash() {
    return "dash";
  }
}