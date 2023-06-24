package com.hbourgeot.todotech.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hbourgeot.todotech.entities.Products;
import com.hbourgeot.todotech.services.IProductsService;
import com.hbourgeot.todotech.utils.FileUploadUtil;

@Controller
public class ProductsController {
  public IProductsService productsService;
  
  public ProductsController(IProductsService productsService) {
    this.productsService = productsService;
  }

  @PostMapping(value = "/products/add")
  public String addProduct(Products product, @RequestParam("image") MultipartFile multipartFile) {

    // Check if the image is submitted
    if (!multipartFile.isEmpty()) {
      String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
      System.out.println("hola " + filename);
      product.setImageUrl(filename);

      Products savedProduct = productsService.save(product);

      String uploadDir = "src/main/resources/static/product-photos/" + savedProduct.getNombreKebabString();
      try {
        FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      productsService.save(product);
    }

    return "redirect:/dash/products";
  }



}