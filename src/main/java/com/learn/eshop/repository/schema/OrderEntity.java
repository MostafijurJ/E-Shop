package com.learn.eshop.repository.schema;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = SchemaConstant.ORDER_TABLE_NAME)
public class OrderEntity {

  @Id
  @Type(type = "uuid-char")
  private UUID id;

  @Column(nullable = false)
  private String orderTrackingNumber;

  private double totalPrice;

  private double totalQuantity;

  private String status;

  @CreationTimestamp
  private Date dateCreated;

  @UpdateTimestamp
  private Date lastUpdate;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderEntity")
  private Set<OrderItemEntity> orderItems = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "customer_id", referencedColumnName = "id")
  private CustomerEntity customerEntity;

  @OneToOne
  @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
  private AddressEntity shippingAddress;

  @OneToOne
  @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
  private AddressEntity billingAddress;

  public void add(OrderItemEntity entity) {
    if (entity != null) {
      if (orderItems == null) {
        orderItems = new HashSet<>();
      }
      orderItems.add(entity);
      entity.setOrderEntity(this);
    }
  }

}
