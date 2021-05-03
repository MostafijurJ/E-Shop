package com.learn.eshop.repository.jpa;

import com.learn.eshop.repository.schema.ProductCategoryEntity;
import com.learn.eshop.repository.schema.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@Repository
@CrossOrigin
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
  List<ProductEntity> findByCategoryEntity(ProductCategoryEntity entity);
}
