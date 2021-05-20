package com.learn.eshop.repository.jpa;

import com.learn.eshop.repository.schema.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@Repository
@CrossOrigin
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
}
