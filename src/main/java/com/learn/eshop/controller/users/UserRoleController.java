package com.learn.eshop.controller.users;

import com.learn.eshop.domain.authentication.Role;
import com.learn.eshop.servce.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserRoleController implements UserRoleApi {

  private final UserRoleService userRoleService;

  public UserRoleController(UserRoleService userRoleService) {
    this.userRoleService = userRoleService;
  }

  @Override
  public ResponseEntity<Role> saveUserRole(Role role) {
    return ResponseEntity.ok(userRoleService.saveRole(role));
  }
}
