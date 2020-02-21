package com.example.banking.repository;

import com.example.banking.model.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
    List<CreditCard> findByClientId(String clientId);
}
