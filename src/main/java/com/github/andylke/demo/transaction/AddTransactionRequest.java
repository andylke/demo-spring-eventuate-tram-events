package com.github.andylke.demo.transaction;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AddTransactionRequest {

  private TransactionDetails details;

  public AddTransactionRequest() {}

  public AddTransactionRequest(TransactionDetails details) {
    this.details = details;
  }

  public TransactionDetails getDetails() {
    return details;
  }

  public void setDetails(TransactionDetails details) {
    this.details = details;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
  }
}
