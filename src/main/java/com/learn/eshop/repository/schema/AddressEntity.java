package com.learn.eshop.repository.schema;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = SchemaConstant.ADDRESS_TABLE_NAME)
public class AddressEntity {
  @Id
  @Type(type = "uuid-char")
  private UUID id;

  private String address;

  private String city;

  private String zipCode;

  private String country;

  @OneToOne
  @PrimaryKeyJoinColumn
  private OrderEntity orderEntity;

}
