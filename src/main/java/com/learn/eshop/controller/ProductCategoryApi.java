package com.learn.eshop.controller;

import com.learn.eshop.domain.ProductCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Api(value = "products-category", tags = "products-category")
@RequestMapping(path = "/products-category")
public interface ProductCategoryApi {
  @ApiOperation(
      value = "Get all products Category",
      nickname = "Get all products Category",
      notes = "Get all products Category",
      tags = {
          "products-category",
      })
  @GetMapping
  ResponseEntity<List<ProductCategory>> getAllProductsCategory();

  @ApiOperation(
      value = "Get products Category",
      nickname = "Get products Category",
      notes = "Get products Category",
      tags = {
          "products-category",
      })
  @GetMapping("{id}")
  ResponseEntity<ProductCategory> getProductsCategory(@PathVariable("id") UUID categoryId);
}
