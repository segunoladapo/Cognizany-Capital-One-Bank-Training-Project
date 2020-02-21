package com.example.banking.repository;

import com.example.banking.model.entity.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanDao extends CrudRepository<Loan, Long> {
    List<Loan> findByClientId(String clientId);
}
