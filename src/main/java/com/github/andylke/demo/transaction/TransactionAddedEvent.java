package com.github.andylke.demo.transaction;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.eventuate.tram.events.common.DomainEvent;

public class TransactionAddedEvent implements DomainEvent {

  private TransactionDetails orderDetails;

  public TransactionAddedEvent() {}

  public TransactionAddedEvent(TransactionDetails orderDetails) {
    this.orderDetails = orderDetails;
  }

  public TransactionDetails getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(TransactionDetails orderDetails) {
    this.orderDetails = orderDetails;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
  }
}
