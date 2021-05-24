package com.learn.eshop.repository.jpa;

import com.learn.eshop.repository.schema.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@Repository
@CrossOrigin
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
  List<CustomerEntity> findByOrderByDateCreated();
}
