package com.learn.eshop.controller.users;

import com.learn.eshop.domain.authentication.Role;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "user-role", tags = "user-role")
@RequestMapping(path = "/user_role")
public interface UserRoleApi {

  @Operation(summary = " add user role")
  @PostMapping
  ResponseEntity<Role> saveUserRole(@RequestBody Role role);

}
