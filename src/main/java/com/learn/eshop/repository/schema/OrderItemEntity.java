package com.learn.eshop.repository.schema;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = SchemaConstant.ORDER_ITEM_TABLE_NAME)
public class OrderItemEntity {

  @Id
  @Type(type = "uuid-char")
  private UUID id;

  private String imgUri;

  @Type(type = "uuid-char")
  private UUID productId;

  private double unitPrice;

  private int quantity;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderEntity orderEntity;

}
