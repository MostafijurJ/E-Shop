package com.learn.eshop.controller;

import com.learn.eshop.domain.Purchase;
import com.learn.eshop.domain.PurchaseResponse;
import com.learn.eshop.servce.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PurchaseController implements PurchaseApi {

  private final PurchaseService purchaseService;

  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @Override
  public ResponseEntity<PurchaseResponse> addPurchase(Purchase purchase) {
    return ResponseEntity.ok(purchaseService.addPurchase(purchase));
  }
}
