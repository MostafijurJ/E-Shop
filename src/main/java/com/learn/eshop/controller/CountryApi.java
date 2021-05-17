package com.learn.eshop.controller;

import com.learn.eshop.domain.Country;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "country", tags = "country")
@RequestMapping(path = "/country")
public interface CountryApi {

  @Operation(summary = "Get all Country")
  @GetMapping
  ResponseEntity<List<Country>> getAllProducts();
}
