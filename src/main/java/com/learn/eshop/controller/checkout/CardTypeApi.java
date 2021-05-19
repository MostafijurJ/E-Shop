package com.learn.eshop.controller.checkout;

import com.learn.eshop.domain.CardType;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "card-type", tags = "card-type")
@RequestMapping(path = "/card-type")
public interface CardTypeApi {

  @Operation(summary = "Get all card type")
  @GetMapping
  ResponseEntity<List<CardType>> getAllCardType();
}
