package com.example.banking.service;

import com.example.banking.model.entity.DepositAccount;
import com.example.banking.repository.DepositAccountDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositAccountService implements AbstractDepositAccountService<DepositAccount> {

    private DepositAccountDao depositAccountDao;

    public DepositAccountService(DepositAccountDao depositAccountDao) {
        this.depositAccountDao = depositAccountDao;
    }

    public Optional<DepositAccount> get(long id) {
        return depositAccountDao.findById(id);
    }

    public List<DepositAccount> getAll() {
        return (List<DepositAccount>) depositAccountDao.findAll();
    }

    public void save(DepositAccount depositAccount) {
        depositAccountDao.save(depositAccount);
    }

    public void update(DepositAccount depositAccount) {
        depositAccountDao.save(depositAccount);
    }

    public void delete(DepositAccount depositAccount) {
        depositAccountDao.delete(depositAccount);
    }

    public List<DepositAccount> findLDepositAccountByClientId(String clientId) {
        return depositAccountDao.findByClientId(clientId);
    }
}