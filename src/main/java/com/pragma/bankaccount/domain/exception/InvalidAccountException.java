package com.pragma.bankaccount.domain.exception;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvalidAccountException extends RuntimeException {

    private final List<ValidationError> validationErrors;
    private final String field;
    private final Object rejectedValue;
    private final String errorCode;

    public static class ValidationError {
        private final String field;
        private final String message;
        private final Object rejectedValue;

        public ValidationError(String field, String message, Object rejectedValue) {
            this.field = field;
            this.message = message;
            this.rejectedValue = rejectedValue;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }

        @Override
        public String toString() {
            return String.format("Field: %s, Message: %s, Rejected Value: %s", 
                field, message, rejectedValue != null ? rejectedValue : "null");
        }
    }

    public InvalidAccountException(String message) {
        super(message);
        this.validationErrors = new ArrayList<>();
        this.field = null;
        this.rejectedValue = null;
        this.errorCode = "INVALID_ACCOUNT";
    }

    public InvalidAccountException(String message, String field, Object rejectedValue) {
        super(message);
        this.validationErrors = new ArrayList<>();
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.errorCode = "INVALID_ACCOUNT";
    }

    public InvalidAccountException(String message, String field, Object rejectedValue, String errorCode) {
        super(message);
        this.validationErrors = new ArrayList<>();
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.errorCode = errorCode;
    }

    public InvalidAccountException(String message, List<ValidationError> validationErrors) {
        super(message);
        this.validationErrors = validationErrors != null ? validationErrors : new ArrayList<>();
        this.field = null;
        this.rejectedValue = null;
        this.errorCode = "VALIDATION_ERRORS";
    }

    public InvalidAccountException(String message, Throwable cause) {
        super(message, cause);
        this.validationErrors = new ArrayList<>();
        this.field = null;
        this.rejectedValue = null;
        this.errorCode = "INVALID_ACCOUNT";
    }

    public void addValidationError(String field, String message, Object rejectedValue) {
        this.validationErrors.add(new ValidationError(field, message, rejectedValue));
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public String getField() {
        return field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public boolean hasValidationErrors() {
        return !validationErrors.isEmpty();
    }

    public String getDetailedMessage() {
        StringBuilder details = new StringBuilder();
        details.append("InvalidAccountException: ").append(getMessage());
        details.append(" | Error Code: ").append(errorCode);
        
        if (field != null) {
            details.append(" | Field: ").append(field);
        }
        if (rejectedValue != null) {
            details.append(" | Rejected Value: ").append(rejectedValue);
        }
        
        if (!validationErrors.isEmpty()) {
            details.append(" | Validation Errors: ").append(validationErrors.size());
            for (ValidationError error : validationErrors) {
                details.append(" | ").append(error.toString());
            }
        }
        
        return details.toString();
    }

    @Override
    public String toString() {
        return getDetailedMessage();
    }
}