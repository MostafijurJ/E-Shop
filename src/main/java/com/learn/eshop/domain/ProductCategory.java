package com.learn.eshop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ProductCategory {

  @Type(type = "uuid-char")
  private UUID id;

  private String name;
}
