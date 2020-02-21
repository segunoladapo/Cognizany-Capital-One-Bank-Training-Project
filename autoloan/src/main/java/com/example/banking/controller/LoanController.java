package com.example.banking.controller;


import com.example.banking.model.entity.Loan;
import com.example.banking.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @PostMapping
    public Loan saveLoan(@RequestBody Loan loan) {
        loanService.save(loan);
        return loan;
    }

    @GetMapping(path = "{clientId}")
    public Loan findLoanByClientId(@PathVariable String clientId) {
        return loanService.findLoanByClientId(clientId);
    }

    @PutMapping
    public void updateLoan(@RequestBody Loan loan) {
        loanService.update(loan);
    }
}
