package com.learn.eshop.controller;

import com.learn.eshop.domain.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "products", tags = "products")
@RequestMapping(path = "/products")
public interface ProductApi {

  @ApiOperation(
      value = "Get all products",
      nickname = "Get all products",
      notes = "Get all products",
      tags = {
          "products",
      })
  @GetMapping
  ResponseEntity<List<Product>> getAllProducts();
}
