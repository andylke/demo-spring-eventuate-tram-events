package com.github.andylke.demo.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

public class TransactionEventConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(TransactionEventConsumer.class);

  public DomainEventHandlers domainEventHandlers() {
    return new DomainEventHandlersBuilder("spring-boot-eventuate-tram-events.transaction")
        .onEvent(TransactionAddedEvent.class, this::handleTransactionAdded)
        .build();
  }

  public void handleTransactionAdded(DomainEventEnvelope<TransactionAddedEvent> event) {
    LOGGER.info("TransactionAddedEvent {} received", event.getEvent());
  }
}
