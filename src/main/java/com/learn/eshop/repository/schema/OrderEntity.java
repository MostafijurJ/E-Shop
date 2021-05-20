package com.learn.eshop.repository.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = SchemaConstant.ORDER_TABLE_NAME)
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Type(type = "uuid-char")
  private UUID id;

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
  @JoinColumn(name = "customer_id")
  private CustomerEntity customerEntity;

  @OneToOne(cascade = CascadeType.ALL)
  private AddressEntity shippingAddress;

  @OneToOne(cascade = CascadeType.ALL)
  private AddressEntity billingAddress;


 /* public void add(OrderItemEntity entity){
    if(entity != null){
      if (orderItems==null){
        orderItems = new HashSet<>();
      }
      orderItems.add(entity);
      entity.setOrderEntity(this);
    }
  }*/

}
