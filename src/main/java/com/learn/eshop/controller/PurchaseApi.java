package com.learn.eshop.controller;

import com.learn.eshop.domain.Purchase;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "purchase", tags = "purchase")
@RequestMapping(path = "/purchase")
public interface PurchaseApi {

  @Operation(summary = "post purchase")
  @PostMapping
  ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase);
}
