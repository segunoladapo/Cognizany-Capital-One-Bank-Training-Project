package com.example.banking.controller;

import com.example.banking.model.entity.DepositAccount;
import com.example.banking.service.DepositAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deposit-account")
public class DepositAccountController {

    private DepositAccountService depositAccountService;

    public DepositAccountController(DepositAccountService depositAccountService) {
        this.depositAccountService = depositAccountService;
    }


    @PostMapping
    public DepositAccount saveDepositAccount(@RequestBody DepositAccount depositAccount) {
        depositAccountService.save(depositAccount);
        return depositAccount;
    }


    @GetMapping(path = "{clientId}")
    public List<DepositAccount> findDepositAccountByClientId(@PathVariable String clientId) {
        return depositAccountService.findLDepositAccountByClientId(clientId);
    }

    @PutMapping
    public void updateDepositAccount(@RequestBody DepositAccount depositAccount) {
        depositAccountService.update(depositAccount);
    }

    @GetMapping
    public List<DepositAccount> getAllDepositAccounts() {
        return depositAccountService.getAll();
    }

    @DeleteMapping(path = "{id}")
    public void deleteDepositAccount(@PathVariable Long id) {
        Optional<DepositAccount> loan = depositAccountService.get(id);
        if (loan.isPresent()) {
            depositAccountService.delete(loan.get());
        }
    }
}
