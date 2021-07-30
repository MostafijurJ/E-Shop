package com.learn.eshop.countryTest;

import com.learn.eshop.repository.jpa.CountryRepository;
import com.learn.eshop.repository.schema.CountryEntity;
import com.learn.eshop.servce.CountryService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class TestCountryService {

  @Autowired private CountryService countryService;

  @MockBean private CountryRepository countryEntity;

  @Test
  @Ignore
  public void getAllCountry() {

    CountryEntity entity = new CountryEntity();
  }

  @Test
  public void createCountry() {
    var country = new CountryEntity();
    country.setName("TEST");
    country.setShortCode("TT");

    Mockito.when(countryEntity.save(country)).thenReturn(country);

    assertThat(countryService.createCountry(country)).isEqualTo(country);
  }
}
