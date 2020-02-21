package com.example.banking.model;

import java.util.List;

public class AccountSummary {
    private List<Object> depositAccounts;

    private List<Object> creditAccounts;

    private List<Object> autoLoanAccounts;

    public void setDepositAccounts(List<Object> depositAccounts) {
        this.depositAccounts = depositAccounts;
    }

    public List<Object> getDepositAccounts() {
        return this.depositAccounts;
    }

    public void setCreditAccounts(List<Object> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public List<Object> getCreditAccounts() {
        return this.creditAccounts;
    }

    public void setAutoLoanAccounts(List<Object> autoLoanAccounts) {
        this.autoLoanAccounts = autoLoanAccounts;
    }

    public List<Object> getAutoLoanAccounts() {
        return this.autoLoanAccounts;
    }
}
