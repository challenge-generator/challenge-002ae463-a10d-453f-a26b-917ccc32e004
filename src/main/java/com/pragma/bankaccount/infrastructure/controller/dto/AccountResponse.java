package com.pragma.bankaccount.infrastructure.controller.dto;



import com.pragma.bankaccount.domain.model.AccountStatus;
import com.pragma.bankaccount.domain.model.AccountType;
import com.pragma.bankaccount.domain.model.Account;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Schema(description = "Respuesta de cuenta bancaria")
public record AccountResponse(

    @Schema(description = "ID único de la cuenta", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id,

    @Schema(description = "Número de cuenta", example = "1234567890123456")
    String accountNumber,

    @Schema(description = "ID del cliente", example = "CUST-001")
    String customerId,

    @Schema(description = "Saldo actual de la cuenta", example = "1000.00")
    BigDecimal balance,

    @Schema(description = "Tipo de cuenta", example = "SAVINGS")
    Account.AccountType accountType,

    @Schema(description = "Estado de la cuenta", example = "ACTIVE")
    Account.AccountStatus status,

    @Schema(description = "Fecha de creación de la cuenta", example = "2024-01-15T10:30:00Z")
    Instant createdAt,

    @Schema(description = "Fecha de última modificación", example = "2024-01-15T10:30:00Z")
    Instant updatedAt
) {
    public static AccountResponse fromDomain(Account account) {
        return new AccountResponse(
            account.id(),
            account.accountNumber(),
            account.customerId(),
            account.balance(),
            account.accountType(),
            account.status(),
            account.createdAt(),
            account.updatedAt()
        );
    }
}