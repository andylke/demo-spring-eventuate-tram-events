package com.github.andylke.demo.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;

@Configuration
public class OrderEventConfiguration {

  @Bean
  public OrderEventConsumer orderEventConsumer() {
    return new OrderEventConsumer();
  }

  @Bean
  public DomainEventDispatcher orderEventDispatcher(
      OrderEventConsumer orderEventConsumer,
      DomainEventDispatcherFactory domainEventDispatcherFactory) {
    return domainEventDispatcherFactory.make(
        OrderEventConsumer.class.getSimpleName(), orderEventConsumer.domainEventHandlers());
  }
}
