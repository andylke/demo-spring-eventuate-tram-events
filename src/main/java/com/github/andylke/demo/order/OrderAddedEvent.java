package com.github.andylke.demo.order;

import org.apache.commons.lang.builder.ToStringBuilder;

import io.eventuate.tram.events.common.DomainEvent;

public class OrderAddedEvent implements DomainEvent {

  private AddOrderResponse response;

  public OrderAddedEvent() {}

  public OrderAddedEvent(AddOrderResponse response) {
    this.response = response;
  }

  public AddOrderResponse getResponse() {
    return response;
  }

  public void setResponse(AddOrderResponse response) {
    this.response = response;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(response);
  }
}
