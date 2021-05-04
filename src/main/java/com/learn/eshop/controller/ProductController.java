package com.learn.eshop.controller;

import com.learn.eshop.domain.Product;
import com.learn.eshop.servce.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class ProductController implements ProductApi{

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  @Override
  public ResponseEntity<List<Product>> getAllProductsByCategory(UUID categoryId) {
    return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
  }

  @Override
  public ResponseEntity<List<Product>> searchProductsByName(String name) {
    return ResponseEntity.ok(productService.searchProductsByName(name));
  }
}
