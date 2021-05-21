package com.learn.eshop.servce;

import com.learn.eshop.domain.*;
import com.learn.eshop.repository.jpa.AddressRepository;
import com.learn.eshop.repository.jpa.CustomerRepository;
import com.learn.eshop.repository.jpa.OrderItemRepository;
import com.learn.eshop.repository.jpa.OrderRepository;
import com.learn.eshop.repository.schema.AddressEntity;
import com.learn.eshop.repository.schema.CustomerEntity;
import com.learn.eshop.repository.schema.OrderEntity;
import com.learn.eshop.repository.schema.OrderItemEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PurchaseService {
  private final CustomerRepository customerRepository;
  private final AddressRepository addressRepository;
  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;


  public PurchaseService(CustomerRepository customerRepository, AddressRepository addressRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
    this.customerRepository = customerRepository;
    this.addressRepository = addressRepository;
    this.orderRepository = orderRepository;
    this.orderItemRepository = orderItemRepository;
  }

  public PurchaseResponse addPurchase(Purchase purchase) {

    //TODO get info from purchase
    Order order = purchase.getOrder();
    Address address = purchase.getShippingAddress();

    order.setOrderTrackingNumber(trackingNumberGenerator());

    var orderEntity = orderDomainToEntity(order);
    //TODO status will update later
    orderEntity.setStatus("PENDING");
    orderEntity.setShippingAddress(addressDomainToEntity(address));

    Customer customer = purchase.getCustomer();
    var customerEntity = customerDomainToEntity(customer);
    customerEntity.add(orderEntity);
    customerRepository.save(customerEntity);

    //TODO handling null pointer exception for oder items
    Set<OrderItem> items = purchase.getOrderItems();
    try {
      if (!items.isEmpty())
        items.forEach(item -> orderEntity.add(orderItemDomainToEntity(item)));
      else {
        throw new RuntimeException("Order items can't be empty");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }


    return new PurchaseResponse(order.getOrderTrackingNumber());
  }


  private CustomerEntity customerDomainToEntity(Customer domain) {
    var entity = new CustomerEntity();
    BeanUtils.copyProperties(domain, entity);
    return entity;
  }

  private AddressEntity addressDomainToEntity(Address domain) {
    var entity = new AddressEntity();
    BeanUtils.copyProperties(domain, entity);
    return entity;
  }

  private OrderEntity orderDomainToEntity(Order domain) {
    var entity = new OrderEntity();
    BeanUtils.copyProperties(domain, entity);
    return entity;
  }

  private OrderItemEntity orderItemDomainToEntity(OrderItem domain) {
    var entity = new OrderItemEntity();
    BeanUtils.copyProperties(domain, entity);
    return entity;
  }

  private String trackingNumberGenerator() {
    return RandomStringUtils.randomAlphanumeric(8).toUpperCase();
  }

}
