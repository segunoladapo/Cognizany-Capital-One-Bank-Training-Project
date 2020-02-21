package com.example.banking.repository;

import com.example.banking.model.entity.DepositAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositAccountDao extends CrudRepository<DepositAccount, Long> {
    List<DepositAccount> findByClientId(String clientId);
}
