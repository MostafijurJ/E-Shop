package com.learn.eshop.controller;

import com.learn.eshop.domain.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "user", tags = "user")
@RequestMapping(path = "/user")
public interface UserApi {

  @Operation(summary = "user registration purchase")
  @PostMapping("/login")
  ResponseEntity<User> saveUser(@RequestBody User userRequest);
}
