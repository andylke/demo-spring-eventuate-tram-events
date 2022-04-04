package com.github.andylke.demo.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

public class OrderEventConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventConsumer.class);

  public DomainEventHandlers domainEventHandlers() {
    return new DomainEventHandlersBuilder("spring-boot-eventuate-tram-events.order-event")
        .onEvent(OrderAddedEvent.class, this::handleOrderAdded)
        .build();
  }

  public void handleOrderAdded(DomainEventEnvelope<OrderAddedEvent> event) {
    LOGGER.info("OrderAddedEvent {} received", event.getEvent());
  }
}
