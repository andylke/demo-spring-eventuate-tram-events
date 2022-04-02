package com.github.andylke.demo.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;

@Configuration
public class TransactionEventConfiguration {

  @Bean
  public TransactionEventConsumer transactionEventConsumer() {
    return new TransactionEventConsumer();
  }

  @Bean
  public DomainEventDispatcher transactionEventDispatcher(
      TransactionEventConsumer transactionEventConsumer,
      DomainEventDispatcherFactory domainEventDispatcherFactory) {
    return domainEventDispatcherFactory.make(
        "transactionServiceEvent", transactionEventConsumer.domainEventHandlers());
  }
}
