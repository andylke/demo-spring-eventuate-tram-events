package com.github.andylke.demo.transaction;

import java.util.Collections;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.eventuate.tram.events.publisher.DomainEventPublisher;

@Service
public class TransactionService {

  @Autowired private TransactionRepository repository;

  @Autowired private ModelMapper modelMapper;

  @Autowired private DomainEventPublisher domainEventPublisher;

  @Transactional
  public AddTransactionResponse addTransaction(AddTransactionRequest request) {
    final Transaction entity = modelMapper.map(request, Transaction.class);

    final Transaction savedEntity = repository.save(entity);
    final AddTransactionResponse response =
        modelMapper.map(savedEntity, AddTransactionResponse.class);

    domainEventPublisher.publish(
        "spring-boot-eventuate-tram-events.transaction-event",
        savedEntity.getTransactionId(),
        Collections.singletonList(new TransactionAddedEvent(response)));

    return response;
  }
}
