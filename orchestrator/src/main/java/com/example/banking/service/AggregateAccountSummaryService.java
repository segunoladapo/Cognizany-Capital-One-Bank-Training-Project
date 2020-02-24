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

import java.util.ArrayList;
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
        List<Object> autoLoanAccountResult = findAutoloanAccountByClientId(clientId);
        List<Object> depositLoanAccountResult = findDepositAccountByClientId(clientId);
        List<Object> creditCardAccountResult = findCreditCardByClientId(clientId);
        AccountSummary accountSummary = new AccountSummary();
        accountSummary.setAutoLoanAccounts(autoLoanAccountResult);
        accountSummary.setCreditAccounts(creditCardAccountResult);
        accountSummary.setDepositAccounts(depositLoanAccountResult);
        return accountSummary;
    }


    private List<Object> findDepositAccountByClientId(String clientId) {
        List<Object> result;
        try {
            ResponseEntity<List<DepositAccounts>> depositAccountsResponse =
                    restTemplate.exchange(String.format(depositAccountEndpoint, clientId),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<DepositAccounts>>() {
                            });
            return (List) depositAccountsResponse.getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new ArrayList<>();
            result.add("No accounts available to show currently");
            return result;
        }
    }


    private List<Object> findAutoloanAccountByClientId(String clientId) {
        List<Object> result;
        try {
            ResponseEntity<List<AutoLoanAccounts>> autoLoanAccountsResponse =
                    restTemplate.exchange(String.format(autoloanAccountEndPoint, clientId),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<AutoLoanAccounts>>() {
                            });
            return (List) autoLoanAccountsResponse.getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new ArrayList<>();
            result.add("No accounts available to show currently");
            return result;
        }
    }

    private List<Object> findCreditCardByClientId(String clientId) {
        List<Object> result;
        try {
            ResponseEntity<List<CreditAccounts>> creditCardAccountsResponse =
                    restTemplate.exchange(String.format(creditCardEndpoint, clientId),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<CreditAccounts>>() {
                            });
            return (List) creditCardAccountsResponse.getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new ArrayList<>();
            result.add("No accounts available to show currently");
            return result;
        }
    }
}
