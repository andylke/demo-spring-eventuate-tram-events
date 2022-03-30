package com.github.andylke.demo.transaction;

import java.util.Collections;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.eventuate.tram.events.publisher.DomainEventPublisher;

@Service
public class TransactionService {

  @Autowired private TransactionRepository repository;

  @Autowired private DomainEventPublisher domainEventPublisher;

  @Transactional
  public AddTransactionResponse addTransaction(AddTransactionRequest request) {
    final Transaction entity = new Transaction(request.getDetails());

    final Transaction savedEntity = repository.save(entity);

    domainEventPublisher.publish(
        "spring-boot-eventuate-tram-events.transaction",
        savedEntity.getId(),
        Collections.singletonList(new TransactionAddedEvent(savedEntity.getDetails())));

    return new AddTransactionResponse(savedEntity);
  }
}
