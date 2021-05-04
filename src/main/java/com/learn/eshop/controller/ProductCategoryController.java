package com.learn.eshop.controller;

import com.learn.eshop.domain.ProductCategory;
import com.learn.eshop.servce.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class ProductCategoryController implements ProductCategoryApi {
  private final ProductCategoryService productCategoryService;

  public ProductCategoryController(ProductCategoryService productCategoryService) {
    this.productCategoryService = productCategoryService;
  }

  @Override
  public ResponseEntity<List<ProductCategory>> getAllProductsCategory() {
    return ResponseEntity.ok(productCategoryService.getAllProductCategory());
  }

  @Override
  public ResponseEntity<ProductCategory> getProductsCategory(UUID categoryId) {
    return ResponseEntity.ok(productCategoryService.getProductCategory(categoryId));
  }
}
