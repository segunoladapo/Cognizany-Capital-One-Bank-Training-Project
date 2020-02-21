package com.example.banking.service;

import java.util.List;
import java.util.Optional;

public interface AbstractCreditCardService<T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    List<T> findCreditCardByClientId(String clientId);
}
