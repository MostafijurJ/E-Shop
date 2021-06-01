package com.learn.eshop.repository.schema;

import com.learn.eshop.appuser.AppUserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
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
  private String password;
  @Enumerated(EnumType.STRING)
  private AppUserRole appUserRole = AppUserRole.USER;

  @Column(columnDefinition = "bit default 1")
  private Boolean locked;

  @Column(columnDefinition = "bit default 1")
  private Boolean enabled;

  @CreationTimestamp
  private Date createdAt;
}
