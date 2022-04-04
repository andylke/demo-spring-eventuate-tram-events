package com.github.andylke.demo.order;

import java.util.Collections;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.eventuate.tram.events.publisher.DomainEventPublisher;

@Service
public class OrderService {

  @Autowired private OrderRepository repository;

  @Autowired private ModelMapper modelMapper;

  @Autowired private DomainEventPublisher domainEventPublisher;

  @Transactional
  public AddOrderResponse addOrder(AddOrderRequest request) {
    final Order entity = modelMapper.map(request, Order.class);

    final Order savedEntity = repository.save(entity);
    final AddOrderResponse response = modelMapper.map(savedEntity, AddOrderResponse.class);

    domainEventPublisher.publish(
        "spring-boot-eventuate-tram-events.order-event",
        savedEntity.getOrderId(),
        Collections.singletonList(new OrderAddedEvent(response)));

    return response;
  }
}
