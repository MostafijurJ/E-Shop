package com.learn.eshop.controller;

import com.learn.eshop.domain.Purchase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PurchaseController implements PurchaseApi {

  @Override
  public ResponseEntity<Purchase> addPurchase(Purchase purchase) {
    return null;
  }
}
