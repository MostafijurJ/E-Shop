package com.learn.eshop.repository.schema;

import com.learn.eshop.appuser.AppUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = SchemaConstant.ROLE_TABLE_NAME)
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = "uuid-char")
  private UUID id;

  @Enumerated(EnumType.STRING)
  @Column(name = "Role_Name")
  private AppUserRole appUserRole = AppUserRole.USER;

}
