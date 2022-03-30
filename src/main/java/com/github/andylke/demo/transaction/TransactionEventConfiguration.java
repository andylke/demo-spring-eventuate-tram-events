package com.github.andylke.demo.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration;

@Configuration
@Import({TramEventSubscriberConfiguration.class})
public class TransactionEventConfiguration {

  @Bean
  public TransactionEventConsumer orderEventConsumer() {
    return new TransactionEventConsumer();
  }

  @Bean
  public DomainEventDispatcher orderEventDispatcher(
      TransactionEventConsumer orderEventConsumer,
      DomainEventDispatcherFactory domainEventDispatcherFactory) {
    return domainEventDispatcherFactory.make(
        "orderServiceEvents", orderEventConsumer.domainEventHandlers());
  }
}
