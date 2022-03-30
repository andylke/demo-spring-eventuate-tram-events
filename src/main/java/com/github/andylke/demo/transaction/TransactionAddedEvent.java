package com.github.andylke.demo.transaction;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.eventuate.tram.events.common.DomainEvent;

public class TransactionAddedEvent implements DomainEvent {

  private TransactionDetails transactionDetails;

  public TransactionAddedEvent() {}

  public TransactionAddedEvent(TransactionDetails transactionDetails) {
    this.transactionDetails = transactionDetails;
  }

  public TransactionDetails getTransactionDetails() {
    return transactionDetails;
  }

  public void setTransactionDetails(TransactionDetails transactionDetails) {
    this.transactionDetails = transactionDetails;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
  }
}
