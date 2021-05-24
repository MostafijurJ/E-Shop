package com.learn.eshop.controller;

import com.learn.eshop.domain.Customer;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "customers", tags = "customers")
@RequestMapping(path = "/customers")
public interface CustomerApi {
  @Operation(summary = "Get a all customers")
  @GetMapping
  ResponseEntity<List<Customer>> getAllCustomers();
}
