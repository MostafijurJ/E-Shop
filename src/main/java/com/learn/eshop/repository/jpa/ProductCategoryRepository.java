package com.learn.eshop.repository.jpa;


import com.learn.eshop.repository.schema.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, UUID> {
}
