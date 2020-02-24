package com.example.banking.controller;

import com.example.banking.model.AccountSummary;
import com.example.banking.service.AggregateAccountSummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-summary")
public class AggregateAccountSummaryController {
    private AggregateAccountSummaryService aggregateAccountSummaryService;

    public AggregateAccountSummaryController(AggregateAccountSummaryService aggregateAccountSummaryService) {
        this.aggregateAccountSummaryService = aggregateAccountSummaryService;
    }

    @GetMapping(path = "{clientId}")
    public AccountSummary getAccountSummary(String clientId) {
        return this.aggregateAccountSummaryService.retrieveAccountSummaryByClientId(clientId);
    }
}
