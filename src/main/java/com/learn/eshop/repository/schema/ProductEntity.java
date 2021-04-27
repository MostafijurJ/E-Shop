package com.learn.eshop.repository.schema;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = SchemaConstant.PRODUCT_TABLE_NAME)
public class ProductEntity {

  @Id
  @GeneratedValue
  @Type(type = "uuid-char")
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
