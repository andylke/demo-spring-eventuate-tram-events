package com.github.andylke.demo.transaction;

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
}
