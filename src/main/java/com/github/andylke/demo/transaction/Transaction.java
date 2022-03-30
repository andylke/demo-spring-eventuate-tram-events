package com.github.andylke.demo.transaction;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded private TransactionDetails details;

  public Transaction() {}

  public Transaction(TransactionDetails details) {
    this.details = details;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TransactionDetails getDetails() {
    return details;
  }

  public void setDetails(TransactionDetails details) {
    this.details = details;
  }
}
