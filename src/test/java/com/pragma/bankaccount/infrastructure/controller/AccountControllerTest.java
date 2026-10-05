package com.pragma.bankaccount.infrastructure.controller;

import com.pragma.bankaccount.application.usecase.AccountUseCase;
import com.pragma.bankaccount.domain.model.Account;
import com.pragma.bankaccount.domain.model.Account.AccountStatus;
import com.pragma.bankaccount.domain.model.Account.AccountType;
import com.pragma.bankaccount.infrastructure.controller.dto.AccountRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AccountUseCase accountUseCase;

    @Test
    void createAccount_shouldReturn201() {
        // given
        AccountRequest request = new AccountRequest();
        request.setAccountNumber("ACC-001");
        request.setCustomerId("CUST-001");
        request.setInitialBalance(new BigDecimal("1000.00"));
        request.setAccountType(AccountType.SAVINGS.name());

        Account createdAccount = Account.create(
            "ACC-001",
            "CUST-001",
            new BigDecimal("1000.00"),
            AccountType.SAVINGS
        );

        when(accountUseCase.createAccount(any(), any(), any(), any())).thenReturn(createdAccount);

        // when & then
        webTestClient.post()
            .uri("/api/v1/accounts")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isCreated()
            .expectBody()
            .jsonPath("$.accountNumber").isEqualTo("ACC-001")
            .jsonPath("$.customerId").isEqualTo("CUST-001");
    }

    @Test
    void getAccountById_shouldReturn200() {
        // given
        UUID accountId = UUID.randomUUID();
        Account account = Account.create(
            "ACC-001",
            "CUST-001",
            new BigDecimal("1000.00"),
            AccountType.SAVINGS
        );

        when(accountUseCase.getAccountById(accountId)).thenReturn(account);

        // when & then
        webTestClient.get()
            .uri("/api/v1/accounts/{id}", accountId)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.accountNumber").isEqualTo("ACC-001");
    }

    @Test
    void getAccountById_shouldReturn404WhenNotFound() {
        // given
        UUID nonExistentId = UUID.randomUUID();
        when(accountUseCase.getAccountById(nonExistentId)).thenThrow(new RuntimeException("Account not found"));

        // when & then
        webTestClient.get()
            .uri("/api/v1/accounts/{id}", nonExistentId)
            .exchange()
            .expectStatus().isNotFound();
    }

    @Test
    void deposit_shouldReturn200() {
        // given
        UUID accountId = UUID.randomUUID();
        Account account = Account.create(
            "ACC-001",
            "CUST-001",
            new BigDecimal("1500.00"),
            AccountType.SAVINGS
        );

        when(accountUseCase.deposit(eq(accountId), any(BigDecimal.class))).thenReturn(account);

        // when & then
        webTestClient.post()
            .uri("/api/v1/accounts/{id}/deposit", accountId)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue("{\"amount\": 500}")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.balance").isEqualTo(1500.00);
    }

    @Test
    void withdraw_shouldReturn200() {
        // given
        UUID accountId = UUID.randomUUID();
        Account account = Account.create(
            "ACC-001",
            "CUST-001",
            new BigDecimal("700.00"),
            AccountType.SAVINGS
        );

        when(accountUseCase.withdraw(eq(accountId), any(BigDecimal.class))).thenReturn(account);

        // when & then
        webTestClient.post()
            .uri("/api/v1/accounts/{id}/withdraw", accountId)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue("{\"amount\": 300}")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.balance").isEqualTo(700.00);
    }

    @Test
    void closeAccount_shouldReturn200() {
        // given
        UUID accountId = UUID.randomUUID();
        Account closedAccount = Account.create(
            "ACC-001",
            "CUST-001",
            new BigDecimal("0.00"),
            AccountType.SAVINGS
        ).close();

        when(accountUseCase.closeAccount(accountId)).thenReturn(closedAccount);

        // when & then
        webTestClient.post()
            .uri("/api/v1/accounts/{id}/close", accountId)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.status").isEqualTo("CLOSED");
    }

    @Test
    void blockAccount_shouldReturn200() {
        // given
        UUID accountId = UUID.randomUUID();
        Account blockedAccount = Account.create(
            "ACC-001",
            "CUST-001",
            new BigDecimal("1000.00"),
            AccountType.SAVINGS
        ).block();

        when(accountUseCase.blockAccount(accountId)).thenReturn(blockedAccount);

        // when & then
        webTestClient.post()
            .uri("/api/v1/accounts/{id}/block", accountId)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.status").isEqualTo("BLOCKED");
    }
}