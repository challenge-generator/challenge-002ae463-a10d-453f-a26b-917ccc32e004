package com.pragma.bankaccount.infrastructure.controller.dto;


import com.pragma.bankaccount.domain.model.AccountType;
import com.pragma.bankaccount.domain.model.Account;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AccountRequest(

    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    String accountNumber,

    @NotBlank(message = "El ID del cliente es obligatorio")
    @Size(min = 5, max = 50, message = "El ID del cliente debe tener entre 5 y 50 caracteres")
    String customerId,

    @NotNull(message = "El saldo inicial es obligatorio")
    @DecimalMin(value = "0.0", message = "El saldo no puede ser negativo")
    BigDecimal initialBalance,

    @NotNull(message = "El tipo de cuenta es obligatorio")
    Account.AccountType accountType
) {
    public AccountRequest {
        if (initialBalance != null && initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
    }
}