package com.learn.eshop.mapper;

import com.learn.eshop.repository.jpa.ProductRepository;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {
  private final ProductRepository productRepository;

  public ProductMapper(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

//  ObjectMapper<ProductEntity, Product> entityToDomain(){
//    return entity -> {
//      var domain = new Product();
//      BeanUtils.copyProperties(entity,domain);
//      return domain;
//    };
//  }
//

}
