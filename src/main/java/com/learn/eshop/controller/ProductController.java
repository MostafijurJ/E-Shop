package com.learn.eshop.controller;

import com.learn.eshop.domain.Product;
import com.learn.eshop.servce.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi{

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }
}
