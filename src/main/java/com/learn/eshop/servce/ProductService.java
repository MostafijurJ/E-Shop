package com.learn.eshop.servce;

import com.learn.eshop.domain.Product;
import com.learn.eshop.repository.jpa.ProductCategoryRepository;
import com.learn.eshop.repository.jpa.ProductRepository;
import com.learn.eshop.repository.schema.ProductEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;

  public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
    this.productRepository = productRepository;
    this.productCategoryRepository = productCategoryRepository;
  }

  public Page<Product> getAllProducts(Pageable pageable) {
    return productRepository.findAll(pageable).map(this::entityToDomain);
  }

  public Product getProductById(UUID uuid) {
    var entity = productRepository.findById(uuid).orElseThrow(() ->
        new ResourceNotFoundException("Product not found with id : " + uuid));
    return entityToDomain(entity);
  }

  public List<Product> getProductsByCategory(UUID categoryId) {
    var categoryEntity = productCategoryRepository.findById(categoryId).orElseThrow(() ->
        new ResourceNotFoundException("Product Category not found with id : " + categoryId));
    var entities = productRepository.findByCategoryEntity(categoryEntity);
    return entities.stream().map(this::entityToDomain).collect(Collectors.toList());
  }

  public List<Product> searchProductsByName(String name) {
    var entities = productRepository.findByNameContaining(name);
    return entities.stream().map(this::entityToDomain).collect(Collectors.toList());
  }

  private Product entityToDomain(ProductEntity entity) {
    Product domain = new Product();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }

}
