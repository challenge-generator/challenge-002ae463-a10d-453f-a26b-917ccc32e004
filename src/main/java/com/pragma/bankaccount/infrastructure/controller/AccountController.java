package com.pragma.bankaccount.infrastructure.controller;

import com.pragma.bankaccount.domain.model.Account;
import com.pragma.bankaccount.domain.port.AccountService;
import com.pragma.bankaccount.infrastructure.controller.dto.AccountRequest;
import com.pragma.bankaccount.infrastructure.controller.dto.AccountResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/accounts")
@Tag(name = "Cuentas", description = "API para la gestión de cuentas bancarias")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva cuenta", description = "Crea una cuenta bancaria con los datos proporcionados")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest request) {
        Account account = accountService.createAccount(
                request.accountNumber(),
                request.customerId(),
                request.initialBalance(),
                request.accountType()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(AccountResponse.fromDomain(account));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cuenta por ID", description = "Recupera los detalles de una cuenta específica")
    public ResponseEntity<AccountResponse> getAccountById(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @GetMapping("/number/{accountNumber}")
    @Operation(summary = "Obtener cuenta por número", description = "Busca una cuenta por su número de cuenta")
    public ResponseEntity<AccountResponse> getAccountByNumber(
            @Parameter(description = "Número de cuenta") @PathVariable String accountNumber) {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @GetMapping
    @Operation(summary = "Listar todas las cuentas", description = "Retorna todas las cuentas registradas en el sistema")
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping("/{id}/deposit")
    @Operation(summary = "Depositar funds", description = "Realiza un depósito en la cuenta especificada")
    public ResponseEntity<AccountResponse> deposit(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id,
            @Parameter(description = "Monto a depositar") @RequestParam BigDecimal amount) {
        Account account = accountService.deposit(id, amount);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/withdraw")
    @Operation(summary = "Retirar funds", description = "Realiza un retiro de la cuenta especificada")
    public ResponseEntity<AccountResponse> withdraw(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id,
            @Parameter(description = "Monto a retirar") @RequestParam BigDecimal amount) {
        Account account = accountService.withdraw(id, amount);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/close")
    @Operation(summary = "Cerrar cuenta", description = "Cierra una cuenta bancaria")
    public ResponseEntity<AccountResponse> closeAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.closeAccount(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/block")
    @Operation(summary = "Bloquear cuenta", description = "Bloquea una cuenta bancaria")
    public ResponseEntity<AccountResponse> blockAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.blockAccount(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/unblock")
    @Operation(summary = "Desbloquear cuenta", description = "Desbloquea una cuenta bancaria")
    public ResponseEntity<AccountResponse> unblockAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.unblockAccount(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cuenta", description = "Elimina una cuenta del sistema")
    public ResponseEntity<Void> deleteAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        accountService.closeAccount(id);
        return ResponseEntity.noContent().build();
    }
}