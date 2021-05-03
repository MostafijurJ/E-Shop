package com.learn.eshop.servce;

import com.learn.eshop.domain.Product;
import com.learn.eshop.repository.jpa.ProductRepository;
import com.learn.eshop.repository.schema.ProductEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAllProducts() {
    var entities = productRepository.findAll();
    return entities.stream().map(this::entityToDomain).collect(Collectors.toList());
  }

  private Product entityToDomain(ProductEntity entity) {
    Product domain = new Product();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }

}
