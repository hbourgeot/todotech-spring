package com.hbourgeot.todotech;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// config for allow upload files
public class MvcConfig implements WebMvcConfigurer {
    // resource handlers
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    exposeDirectory("product-photos/", registry);
  }

  // function for expose the upstream directory
  private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
    Path uploadDir = Paths.get(dirName);
    String uploadPath = uploadDir.toFile().getAbsolutePath();

    if (dirName.startsWith("../"))
      dirName = dirName.replace("../", "");

   // we add the resource handler
 registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
  }
}