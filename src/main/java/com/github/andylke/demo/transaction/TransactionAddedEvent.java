package com.github.andylke.demo.transaction;

import org.apache.commons.lang.builder.ToStringBuilder;

import io.eventuate.tram.events.common.DomainEvent;

public class TransactionAddedEvent implements DomainEvent {

  private AddTransactionResponse response;

  public TransactionAddedEvent() {}

  public TransactionAddedEvent(AddTransactionResponse response) {
    this.response = response;
  }

  public AddTransactionResponse getResponse() {
    return response;
  }

  public void setResponse(AddTransactionResponse response) {
    this.response = response;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(response);
  }
}
