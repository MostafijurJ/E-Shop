package com.learn.eshop.controller.users;

import com.learn.eshop.domain.authentication.Credentials;
import com.learn.eshop.domain.authentication.JwtTokenResponse;
import com.learn.eshop.domain.authentication.User;
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
  @PostMapping("/register")
  ResponseEntity<User> saveUser(@RequestBody User userRequest);

  @Operation(summary = "user registration purchase")
  @PostMapping("/login")
  ResponseEntity<JwtTokenResponse> loginUser(@RequestBody Credentials loginCredentials);


}
