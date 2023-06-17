package com.hbourgeot.todotech.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  private static String authorizationRequestBaseUri
      = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls
      = new HashMap<>();

  @Autowired
  private ClientRegistrationRepository clientRegistrationRepository;

  @GetMapping(value = "/")
  public String index() {
    return "index";
  }

  @GetMapping("/oauth_login")
  public String getLoginPage(Model model) {
    Iterable<ClientRegistration> clientRegistrations = null;
    ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
      .as(Iterable.class);
    if (type != ResolvableType.NONE && 
      ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
        clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
    }

    clientRegistrations.forEach(registration -> 
      oauth2AuthenticationUrls.put(registration.getClientName(), 
      authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
    model.addAttribute("urls", oauth2AuthenticationUrls);

    return "login";
  }
  /*
   * @GetMapping(value = "/login")
   * public String login(Model model) {
   * model.addAttribute("title", "Login - TodoTech");
   * return "login";
   * }
   */
  /*
   * @PostMapping(value = "/login")
   * public String postLogin(Model model, @Valid @ModelAttribute(name = "user")
   * User user) {
   * HttpHeaders headers = new HttpHeaders();
   * HttpEntity<User> entity = new HttpEntity<User>(user, headers);
   * Boolean result =
   * restTemplate.exchange("http://localhost:8080/api/users/login",
   * HttpMethod.POST, entity, Boolean.class)
   * .getBody();
   * 
   * if (result.booleanValue()) {
   * return "redirect:dash";
   * }
   * 
   * model.addAttribute("error", "Error submiting");
   * 
   * return "login";
   * }
   */

  @GetMapping(value = "/dash")
  @ResponseBody
  public String dash() {
    return "holaaa. Tas seguro";
  }
}