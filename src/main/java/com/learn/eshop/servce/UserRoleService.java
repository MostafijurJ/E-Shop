package com.learn.eshop.servce;

import com.learn.eshop.domain.Role;
import com.learn.eshop.repository.jpa.UserRoleRepository;
import com.learn.eshop.repository.schema.RoleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

  private final UserRoleRepository userRoleRepository;

  public UserRoleService(UserRoleRepository userRoleRepository) {
    this.userRoleRepository = userRoleRepository;
  }

  public Role saveRole(Role role) {
    var entity = domainToEntity(role);
    userRoleRepository.save(entity);
    return entityToDomain(entity);
  }

  private RoleEntity domainToEntity(Role domain) {
    var entity = new RoleEntity();
    BeanUtils.copyProperties(domain, entity);
    return entity;
  }

  private Role entityToDomain(RoleEntity entity) {
    var domain = new Role();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }


}
