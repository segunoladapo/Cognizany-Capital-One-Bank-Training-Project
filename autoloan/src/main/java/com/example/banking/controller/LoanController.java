package com.example.banking.controller;


import com.example.banking.model.GenericRestResponse;
import com.example.banking.model.dto.LoanDto;
import com.example.banking.model.entity.Loan;
import com.example.banking.service.LoanService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @PostMapping
    @HystrixCommand(fallbackMethod = "raisedExceptionFallBackMethod")
    public Loan saveLoan(@RequestBody LoanDto loanDto) {
        Loan newLoan = new Loan.LoanBuilder()
                .setBalance(loanDto.getBalance())
                .setCliendId(loanDto.getClientId())
                .setName(loanDto.getName())
                .build();
        loanService.save(newLoan);
        return newLoan;
    }

    public GenericRestResponse raisedExceptionFallBackMethod() {
        return new GenericRestResponse("9999", "DB Exception", "A DB Exception occurred carrying out request");
    }

    @GetMapping(path = "{clientId}")
    public List<Loan> findLoanByClientId(@PathVariable String clientId) {
        return loanService.findLoanByClientId(clientId);
    }

    @PutMapping
    public void updateLoan(@RequestBody Loan loan) {
        loanService.update(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAll();
    }

    @DeleteMapping(path = "{id}")
    public void deleteLoan(@PathVariable Long id) {
        Optional<Loan> loan = loanService.get(id);
        if (loan.isPresent()) {
            loanService.delete(loan.get());
        }
    }
}
