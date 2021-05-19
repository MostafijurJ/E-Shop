package com.learn.eshop.repository.schema;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = SchemaConstant.COUNTRY_TABLE_NAME)
public class CountryEntity {

  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Type(type = "uuid-char")
  private UUID id;

  @Column(nullable = false)
  private String name;

  private String shortCode;
}
