package com.learn.eshop.servce;

import com.learn.eshop.domain.Country;
import com.learn.eshop.repository.jpa.CountryRepository;
import com.learn.eshop.repository.schema.CountryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
  private final CountryRepository countryRepository;

  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public List<Country> getAllCountries() {
    var entities = countryRepository.findAll();
    return entities.stream().map(this::entityToDomain).collect(Collectors.toList());
  }

  private Country entityToDomain(CountryEntity entity) {
    var domain = new Country();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }
}
