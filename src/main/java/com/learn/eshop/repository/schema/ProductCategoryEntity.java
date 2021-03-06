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
@Table(name = SchemaConstant.PRODUCT_CATEGORY_TABLE_NAME)
public class ProductCategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = "uuid-char")
  private UUID id;

  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryEntity")
  private Set<ProductEntity> productEntities;

}
