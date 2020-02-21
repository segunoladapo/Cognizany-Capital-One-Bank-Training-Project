package com.example.banking.service;

import java.util.List;

public interface AbstractDepositAccountService<T> {

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    List<T> findLDepositAccountByClientId(String clientId);
}
