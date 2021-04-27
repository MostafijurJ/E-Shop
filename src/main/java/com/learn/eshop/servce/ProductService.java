package com.learn.eshop.servce;

import com.learn.eshop.domain.Product;
import com.learn.eshop.repository.jpa.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();

    var entities = productRepository.findAll();
    for (var entity : entities) {
      Product product = new Product();
      BeanUtils.copyProperties(entity, product);
      products.add(product);
    }
    return products;
  }
}
