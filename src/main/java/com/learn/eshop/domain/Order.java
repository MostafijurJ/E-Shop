package com.learn.eshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private UUID id;
  private double totalPrice;
  private double totalQuantity;
  private String status;
  private Date dateCreated;
  private Date lastUpdate;
}
