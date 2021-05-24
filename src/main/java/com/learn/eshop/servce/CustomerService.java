package com.learn.eshop.servce;

import com.learn.eshop.domain.Customer;
import com.learn.eshop.repository.jpa.CustomerRepository;
import com.learn.eshop.repository.schema.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> getAllCustomer() {
    var entities = customerRepository.findByOrderByDateCreated();
    return entities.stream().map(this::entityToDomain).collect(Collectors.toList());
  }

  private Customer entityToDomain(CustomerEntity entity) {
    var domain = new Customer();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }

}
