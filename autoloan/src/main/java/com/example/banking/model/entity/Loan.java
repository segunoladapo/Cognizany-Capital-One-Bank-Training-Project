package com.example.banking.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String clientId;
    private String name;
    private Double balance;

    public Loan() {
    }

    private Loan(LoanBuilder loanBuilder) {
        this.balance = loanBuilder.balance;
        this.clientId = loanBuilder.clientId;
        this.name = loanBuilder.name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static class LoanBuilder {
        private double balance;
        private String name;
        private String clientId;

        public LoanBuilder() {
        }

        public LoanBuilder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public LoanBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public LoanBuilder setCliendId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Loan build() {
            return new Loan(this);
        }
    }

}
