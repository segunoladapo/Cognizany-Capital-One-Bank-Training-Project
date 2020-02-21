package com.example.banking.service;

import com.example.banking.model.entity.Loan;
import com.example.banking.repository.LoanDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LoanService implements AbstractLoanService<Loan> {

    private LoanDao loanDao;

    public LoanService(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    public Optional<Loan> get(long id) {
        return loanDao.findById(id);
    }

    public List<Loan> getAll() {
        return (List<Loan>) loanDao.findAll();
    }

    public void save(Loan loan) {
        loanDao.save(loan);
    }

    public void update(Loan loan) {
        loanDao.save(loan);
    }

    public void delete(Loan loan) {
        loanDao.delete(loan);
    }

    public List<Loan> findLoanByClientId(String clientId) {
        return loanDao.findByClientId(clientId);
    }
}
