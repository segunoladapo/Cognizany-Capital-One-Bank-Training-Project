package com.example.banking.service;


import com.example.banking.model.AccountSummary;
import com.example.banking.model.AutoLoanAccounts;
import com.example.banking.model.CreditAccounts;
import com.example.banking.model.DepositAccounts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

        try {
            ResponseEntity<List<AutoLoanAccounts>> autoLoanAccountsResponse =
                    restTemplate.exchange(String.format(autoloanAccountEndPoint, clientId),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<AutoLoanAccounts>>() {
                            });
        }catch (Exception ex){

        }
        ResponseEntity<List<CreditAccounts>> creditCardAccountsResponse =
                restTemplate.exchange(String.format(creditCardEndpoint, clientId),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CreditAccounts>>() {
                        });
        ResponseEntity<List<DepositAccounts>> depositAccountsResponse =
                restTemplate.exchange(String.format(depositAccountEndpoint, clientId),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<DepositAccounts>>() {
                        });

        return null;
    }
}
