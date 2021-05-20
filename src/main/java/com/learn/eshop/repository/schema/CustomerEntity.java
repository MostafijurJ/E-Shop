package com.learn.eshop.repository.schema;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
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
@Accessors(chain = true)
@Entity
@Table(name = SchemaConstant.CUSTOMER_TABLE_NAME)
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Type(type = "uuid-char")
  private UUID id;

  private String firstName;

  private String lastName;

  private String email;

  @CreationTimestamp
  private Date dateCreated;

  @UpdateTimestamp
  private Date lastUpdate;

  @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
  private Set<OrderEntity> orderEntities = new HashSet<>();

}
