package com.learn.eshop.repository.schema;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = SchemaConstant.USER_TABLE_NAME)
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = "uuid-char")
  private UUID id;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  private String password;

  @Column(columnDefinition = "bit default 1")
  private boolean locked;

  @Column(columnDefinition = "bit default 1")
  private boolean enabled;

  @CreationTimestamp
  private Date createdAt;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "user_role")
  private Set<Role> roles = new HashSet<>();

}
