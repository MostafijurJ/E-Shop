package com.learn.eshop.repository.jpa;

import com.learn.eshop.repository.schema.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
  UserEntity findByEmail(String email);
}
