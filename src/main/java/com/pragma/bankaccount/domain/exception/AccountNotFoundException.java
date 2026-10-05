package com.pragma.bankaccount.domain.exception;


import com.pragma.bankaccount.domain.model.Account;
public class AccountNotFoundException extends RuntimeException {

    private final String accountId;
    private final String accountNumber;
    private final String searchCriteria;

    public AccountNotFoundException(String message) {
        super(message);
        this.accountId = null;
        this.accountNumber = null;
        this.searchCriteria = null;
    }

    public AccountNotFoundException(String message, String accountId) {
        super(message);
        this.accountId = accountId;
        this.accountNumber = null;
        this.searchCriteria = "ID";
    }

    public AccountNotFoundException(String message, String accountNumber, boolean byAccountNumber) {
        super(message);
        this.accountId = null;
        this.accountNumber = accountNumber;
        this.searchCriteria = byAccountNumber ? "ACCOUNT_NUMBER" : "UNKNOWN";
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.accountId = null;
        this.accountNumber = null;
        this.searchCriteria = null;
    }

    public AccountNotFoundException(String message, String accountId, Throwable cause) {
        super(message, cause);
        this.accountId = accountId;
        this.accountNumber = null;
        this.searchCriteria = "ID";
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public String getDetailedMessage() {
        StringBuilder details = new StringBuilder();
        details.append("AccountNotFoundException: ").append(getMessage());
        
        if (accountId != null) {
            details.append(" | Account ID: ").append(accountId);
        }
        if (accountNumber != null) {
            details.append(" | Account Number: ").append(accountNumber);
        }
        if (searchCriteria != null) {
            details.append(" | Search Criteria: ").append(searchCriteria);
        }
        
        return details.toString();
    }

    @Override
    public String toString() {
        return getDetailedMessage();
    }
}