package com.learn.eshop.domain.authentication;

import com.learn.eshop.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

  private UUID id;
  private AppUserRole appUserRole;
}
