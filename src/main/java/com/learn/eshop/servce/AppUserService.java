package com.learn.eshop.servce;

import com.learn.eshop.appuser.AppUser;
import com.learn.eshop.domain.AppUserRole;
import com.learn.eshop.domain.authentication.Credentials;
import com.learn.eshop.domain.authentication.JwtTokenResponse;
import com.learn.eshop.domain.authentication.User;
import com.learn.eshop.repository.jpa.UserRepository;
import com.learn.eshop.repository.schema.RoleEntity;
import com.learn.eshop.repository.schema.UserEntity;
import com.learn.eshop.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AppUserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final JwtUtil jwtUtil;

  public AppUserService(UserRepository userRepository, JwtUtil jwtUtil) {
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
  }

  public User saveUser(User user) {
    var tempUser = userRepository.findByEmail(user.getEmail());
    if (tempUser != null) {
      throw new UsernameNotFoundException("This email contains with another account");
    }
    var entity = userDomainToEntity(user);
    entity.setRoles(Collections.singletonList(new RoleEntity(AppUserRole.USER)));
    return userEntityToDomain(userRepository.save(entity));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var user = userRepository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException("No user found with this email");
    }
    return new AppUser(userEntityToDomain(user));
  }


  public JwtTokenResponse loginWithCredentials(Credentials credentials) {
      var tokenRes = new JwtTokenResponse();
      var entity = userRepository.findByEmailAndPassword(credentials.getUsername(), credentials.getPassword());
    if (entity == null) {
        tokenRes.setMessage("Invalid username and password!");
      throw new UsernameNotFoundException("username and password doesn't match");
    }
    //TODO get user details and generate token using this
    var userDetails = loadUserByUsername(credentials.getUsername());
    var token = jwtUtil.generateToken(userDetails);
      tokenRes.setToken(token);
      tokenRes.setMessage("login is successful!.");
    return tokenRes;
  }


  private User userEntityToDomain(UserEntity entity) {
    var domain = new User();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }

  private UserEntity userDomainToEntity(User domain) {
    var entity = new UserEntity();
    BeanUtils.copyProperties(domain, entity);
    return entity;
  }


}
