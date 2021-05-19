package com.learn.eshop.controller;

import com.learn.eshop.domain.Country;
import com.learn.eshop.servce.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CountryController implements CountryApi {
  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @Override
  public ResponseEntity<List<Country>> getAllProducts() {
    return ResponseEntity.ok(countryService.getAllCountries());
  }
}
