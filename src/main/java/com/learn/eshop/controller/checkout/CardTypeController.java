package com.learn.eshop.controller.checkout;

import com.learn.eshop.domain.CardType;
import com.learn.eshop.servce.checkout.CardTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CardTypeController implements CardTypeApi {
  private final CardTypeService cardTypeService;

  public CardTypeController(CardTypeService cardTypeService) {
    this.cardTypeService = cardTypeService;
  }

  @Override
  public ResponseEntity<List<CardType>> getAllCardType() {
    return ResponseEntity.ok(cardTypeService.getAllCardType());
  }
}
