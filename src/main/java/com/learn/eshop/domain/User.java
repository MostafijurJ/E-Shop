package com.learn.eshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private UUID id;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  private String password;

  private boolean locked;

  private boolean enabled;

  private Date createdAt;

  private Set<Role> roles = new HashSet<>();

}
