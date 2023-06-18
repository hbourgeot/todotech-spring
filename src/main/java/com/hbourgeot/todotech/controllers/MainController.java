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
import org.springframework.web.bind.annotation.PathVariable;

import com.hbourgeot.todotech.entities.Customers;
import com.hbourgeot.todotech.entities.Orders;
import com.hbourgeot.todotech.entities.Products;
import com.hbourgeot.todotech.services.ICustomerService;
import com.hbourgeot.todotech.services.IOrdersService;
import com.hbourgeot.todotech.services.IProductsService;

@Controller
public class MainController {

  private static String authorizationRequestBaseUri = "oauth2/authorization";
  Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

  @Autowired
  private ClientRegistrationRepository clientRegistrationRepository;

  public IProductsService productsService;
  public ICustomerService customerService;
  public IOrdersService ordersService;

  public MainController(IProductsService pService, ICustomerService cService, IOrdersService oService) {
    this.productsService = pService;
    this.customerService = cService;
    this.ordersService = oService;
  }

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

    clientRegistrations.forEach(registration -> oauth2AuthenticationUrls.put(registration.getClientName(),
        authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
    model.addAttribute("urls", oauth2AuthenticationUrls);

    return "login";
  }

  @GetMapping(value = "/dash")
  public String dash() {
    return "dash";
  }

  @GetMapping(value = "/dash/products")
  public String products(Model model) {
    model.addAttribute("productos", productsService.findAll());
    model.addAttribute("title", "Todotech Store - Products");
    return "all-products";
  }

  @GetMapping(value = "/dash/customers")
  public String customers(Model model) {
    model.addAttribute("customers", customerService.findAll());
    model.addAttribute("title", "TodoTech Store - Customers");
    return "all-customers";
  }

  @GetMapping(value = "/dash/orders")
  public String orders(Model model) {
    model.addAttribute("title", "TodoTech Store - Customers");
    model.addAttribute("orders", ordersService.findAll());
    return "all-orders";
  }

  @GetMapping(value = "/dash/products/add")
  public String addProducts(Model model) {
    model.addAttribute("product", new Products());
    model.addAttribute("title", "TodoTech Store - Add Product");
    return "add-product";
  }

  @GetMapping(value = "/dash/customers/add")
  public String addcustomers(Model model) {
    model.addAttribute("user", new Customers());
    model.addAttribute("title", "TodoTech Store - Add Customer");
    return "add-customer";
  }

  @GetMapping(value = "/dash/orders/add")
  public String addorders(Model model) {
    model.addAttribute("title", "TodoTech Store - Add Customer");
    model.addAttribute("order", new Orders());
    model.addAttribute("customers", customerService.findAll());
    model.addAttribute("productos", productsService.findAll());
    return "add-order";
  }

  @GetMapping(value = "/dash/products/{id}")
  public String getProductsById(@PathVariable Long id) {
    return "get-product";
  }

  @GetMapping(value = "/dash/customers/{id}")
  public String getcustomersById(@PathVariable Long id) {
    return "get-customer";
  }

  @GetMapping(value = "/dash/orders/{id}")
  public String getordersById(@PathVariable Long id) {
    return "get-order";
  }
}