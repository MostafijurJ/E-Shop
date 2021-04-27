package com.learn.eshop.repository.schema;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Type(type = "uuid-char")
  private UUID id;

  private String name;

  private String sku;

  private String description;

  private String imageUrl;

  private BigDecimal unitPrice;

  private int unitInStock;

  private boolean active;

  @CreationTimestamp
  private Date dateCreated;

  @UpdateTimestamp
  private Date lastUpdated;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private ProductCategoryEntity categoryEntity;

}
