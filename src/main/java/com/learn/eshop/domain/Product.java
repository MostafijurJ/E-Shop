package com.learn.eshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private UUID id;

  private String name;

  private String sku;

  private String description;

  private String imageUrl;

  private BigDecimal unitPrice;

  private int unitInStock;

  private boolean active;

  private Date dateCreated;

  private Date lastUpdated;
}
