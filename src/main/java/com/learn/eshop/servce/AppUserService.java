package com.learn.eshop.servce;

import com.learn.eshop.appuser.AppUser;
import com.learn.eshop.domain.User;
import com.learn.eshop.repository.jpa.UserRepository;
import com.learn.eshop.repository.schema.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

  private final UserRepository userRepository;

  public AppUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User saveUser(User user) {
    var tempUser = userRepository.findByEmail(user.getEmail());
    if (tempUser != null) {
      throw new UsernameNotFoundException("This email contains with another account");
    }

    var entity = userDomainToEntity(user);
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
