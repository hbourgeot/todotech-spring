package com.hbourgeot.todotech.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.hbourgeot.todotech.entities.Products;
import com.hbourgeot.todotech.services.IProductsService;
import com.hbourgeot.todotech.utils.FileUploadUtil;


@Controller
@RequestMapping("/api/products")
public class ProductsController {

  public IProductsService productsService;
  
  public ProductsController(IProductsService productsService) {
    this.productsService = productsService;
  }

  @GetMapping(value="/public")
  public List<Products> showPublicProducts() {
    return (List<Products>) productsService.findAvalaible();
  }
  
  @GetMapping(value="/all")
  public List<Products> getAllProducts() {
      return (List<Products>) productsService.findAll();
  }
  
  @GetMapping(value = "/{id}")
  public Products getProductById(@PathVariable Long id) {
    return productsService.findById(id);
  }

  @PostMapping(value = "/add")
  public String addProduct(Products product, @RequestParam("image") MultipartFile multipartFile) {
    String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    productsService.save(product);
    product.setImageUrl(filename);

    Products savedProduct = productsService.save(product);

    String uploadDir = "src/main/resources/static/product-photos/" + savedProduct.getNombreKebabString();
    try {
      FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return "redirect:/dash/products";
  }

  @PutMapping(value = "/modify")
  public String modifyProduct(@RequestBody Products product) {
    productsService.save(product);
        return "redirect:/dash/products";
  }
}
