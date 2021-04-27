package com.learn.eshop.repository.schema;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = SchemaConstant.PRODUCT_QUANTITY_TABLE_NAME)
public class ProductCategoryEntity {

  @Id
  @Type(type = "uuid-char")
  @GeneratedValue
  private UUID id;

  private String categoryName;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryEntity")
  private Set<ProductEntity> productEntities;

}
