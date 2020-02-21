package com.example.banking.service;


import com.example.banking.model.AccountSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AggregateAccountSummaryService {
    private RestTemplate restTemplate;
    private String creditCardEndpoint;
    private String autoloanAccountEndPoint;
    private String depositAccountEndpoint;

    public AggregateAccountSummaryService(RestTemplate restTemplate, @Value("${credit.card.service.url}") String creditCardEndpoint,
                                          @Value("${autoloan.account.service.url}") String autoloanAccountEndPoint,
                                          @Value("${deposit.account.service.url}") String depositAccountEndpoint) {
        this.restTemplate = restTemplate;
        this.creditCardEndpoint = creditCardEndpoint;
        this.autoloanAccountEndPoint = autoloanAccountEndPoint;
        this.depositAccountEndpoint = depositAccountEndpoint;
    }

    public AccountSummary retrieveAccountSummaryByClientId(String clientId) {
        //restTemplate.get
        return null;
    }
}
