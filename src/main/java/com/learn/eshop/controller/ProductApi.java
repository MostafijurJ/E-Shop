package com.learn.eshop.controller;

import com.learn.eshop.domain.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

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

  @ApiOperation(
      value = "Get all products by category",
      nickname = "Get all products by category",
      notes = "Get all products by category",
      tags = {
          "products",
      })
  @GetMapping("/category")
  ResponseEntity<List<Product>> getAllProductsByCategory(@RequestParam(value = "categoryId") UUID categoryId);

  @ApiOperation(
      value = "Get products by Id",
      nickname = "Get products by Id",
      notes = "Get products by Id",
      tags = {
          "products",
      })
  @GetMapping("{id}")
  ResponseEntity<Product> getProductsById(@PathVariable("id") UUID uuid);

  @ApiOperation(
      value = "search products by name",
      nickname = "search products by name",
      notes = "search products by name",
      tags = {
          "products",
      })
  @GetMapping("/search")
  ResponseEntity<List<Product>> searchProductsByName(@RequestParam(value = "name") String name);
}
