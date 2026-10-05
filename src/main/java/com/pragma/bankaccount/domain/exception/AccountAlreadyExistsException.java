package com.pragma.bankaccount.domain.exception;


import com.pragma.bankaccount.domain.model.Account;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountAlreadyExistsException extends RuntimeException {

    private final String accountNumber;
    private final String customerId;
    private final UUID existingAccountId;
    private final LocalDateTime existingAccountCreationDate;
    private final List<DuplicateField> duplicateFields;

    public static class DuplicateField {
        private final String fieldName;
        private final Object value;

        public DuplicateField(String fieldName, Object value) {
            this.fieldName = fieldName;
            this.value = value;
        }

        public String getFieldName() {
            return fieldName;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.format("%s: %s", fieldName, value);
        }
    }

    public AccountAlreadyExistsException(String message) {
        super(message);
        this.accountNumber = null;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
    }

    public AccountAlreadyExistsException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
    }

    public AccountAlreadyExistsException(String message, String accountNumber, String customerId) {
        super(message);
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
        this.duplicateFields.add(new DuplicateField("customerId", customerId));
    }

    public AccountAlreadyExistsException(String message, String accountNumber, String customerId, 
                                          UUID existingAccountId, LocalDateTime creationDate) {
        super(message);
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.existingAccountId = existingAccountId;
        this.existingAccountCreationDate = creationDate;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
        if (customerId != null) {
            this.duplicateFields.add(new DuplicateField("customerId", customerId));
        }
    }

    public AccountAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
        this.accountNumber = null;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
    }

    public AccountAlreadyExistsException(String message, String accountNumber, Throwable cause) {
        super(message, cause);
        this.accountNumber = accountNumber;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public UUID getExistingAccountId() {
        return existingAccountId;
    }

    public LocalDateTime getExistingAccountCreationDate() {
        return existingAccountCreationDate;
    }

    public List<DuplicateField> getDuplicateFields() {
        return duplicateFields;
    }

    public boolean hasExistingAccount() {
        return existingAccountId != null;
    }

    public String getDetailedMessage() {
        StringBuilder details = new StringBuilder();
        details.append("AccountAlreadyExistsException: ").append(getMessage());
        
        if (accountNumber != null) {
            details.append(" | Account Number: ").append(accountNumber);
        }
        if (customerId != null) {
            details.append(" | Customer ID: ").append(customerId);
        }
        if (existingAccountId != null) {
            details.append(" | Existing Account ID: ").append(existingAccountId);
        }
        if (existingAccountCreationDate != null) {
            details.append(" | Created At: ").append(existingAccountCreationDate);
        }
        
        if (!duplicateFields.isEmpty()) {
            details.append(" | Duplicate Fields: ");
            for (DuplicateField field : duplicateFields) {
                details.append(field.toString()).append(", ");
            }
            details.delete(details.length() - 2, details.length());
        }
        
        return details.toString();
    }

    @Override
    public String toString() {
        return getDetailedMessage();
    }
}