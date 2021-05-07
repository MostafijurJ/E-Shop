package com.learn.eshop.controller;

import com.learn.eshop.domain.Product;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  @Operation(summary = "Get a book by its id")
  @GetMapping
  ResponseEntity<Page<Product>> getAllProducts(Pageable pageable);

  @Operation(summary = "Get all products by category")
  @GetMapping("/category")
  ResponseEntity<List<Product>> getAllProductsByCategory(@RequestParam(value = "categoryId") UUID categoryId);

  @Operation(summary = "Get products by Id")
  @GetMapping("{id}")
  ResponseEntity<Product> getProductsById(@PathVariable("id") UUID uuid);

  @Operation(summary = "search products by name")
  @GetMapping("/search")
  ResponseEntity<List<Product>> searchProductsByName(@RequestParam(value = "name") String name);
}
