package com.learn.eshop.servce;

import com.learn.eshop.domain.ProductCategory;
import com.learn.eshop.repository.jpa.ProductCategoryRepository;
import com.learn.eshop.repository.schema.ProductCategoryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
  private final ProductCategoryRepository productCategoryRepository;

  public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
    this.productCategoryRepository = productCategoryRepository;
  }

  public List<ProductCategory> getAllProductCategory() {
    var entities = productCategoryRepository.findAll();
    return entities.stream().map(this::entityToDomain).collect(Collectors.toList());
  }

  public ProductCategory getProductCategory(UUID categoryId) {
    return this.entityToDomain(productCategoryRepository.findById(categoryId).orElseThrow(() ->
        new ResourceNotFoundException("Category Not found with id: " + categoryId)));
  }


  private ProductCategory entityToDomain(ProductCategoryEntity entity) {
    var domain = new ProductCategory();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }


}
