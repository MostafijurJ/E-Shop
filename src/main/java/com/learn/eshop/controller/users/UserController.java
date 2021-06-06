package com.learn.eshop.controller.users;

import com.learn.eshop.domain.authentication.Credentials;
import com.learn.eshop.domain.authentication.JwtTokenResponse;
import com.learn.eshop.domain.authentication.User;
import com.learn.eshop.servce.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController implements UserApi {
  private final AppUserService appUserService;

  public UserController(AppUserService appUserService) {
    this.appUserService = appUserService;
  }

  @Override
  public ResponseEntity<User> saveUser(User userRequest) {
    return ResponseEntity.ok(appUserService.saveUser(userRequest));
  }

  @Override
  public ResponseEntity<JwtTokenResponse> loginUser(Credentials loginCredentials) {
    return ResponseEntity.ok(appUserService.loginWithCredentials(loginCredentials));
  }
}
