package com.example.banking.service;

import com.example.banking.model.entity.Loan;

import java.util.List;
import java.util.Optional;

public interface AbstractLoanService<T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    Loan findLoanByClientId(String clientId);

}
