package com.pragma.bankaccount.application.usecase;

import com.pragma.bankaccount.domain.model.Account;
import com.pragma.bankaccount.domain.model.Account.AccountStatus;
import com.pragma.bankaccount.domain.model.Account.AccountType;
import com.pragma.bankaccount.domain.port.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountUseCaseTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountUseCase accountUseCase;

    private Account testAccount;

    @BeforeEach
    void setUp() {
        testAccount = Account.create(
            "ACC-001",
            "CUST-001",
            new BigDecimal("1000.00"),
            AccountType.SAVINGS
        );
    }

    @Test
    void createAccount_shouldCreateNewAccount() {
        // given
        when(accountRepository.existsByAccountNumber("ACC-001")).thenReturn(false);
        when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

        // when
        Account result = accountUseCase.createAccount(
            "ACC-001",
            "CUST-001",
            new BigDecimal("1000.00"),
            AccountType.SAVINGS
        );

        // then
        assertNotNull(result);
        assertEquals("ACC-001", result.accountNumber());
        assertEquals("CUST-001", result.customerId());
        assertEquals(AccountStatus.ACTIVE, result.status());
        verify(accountRepository).save(any(Account.class));
    }

    @Test
    void getAccountById_shouldReturnAccount() {
        // given
        UUID accountId = testAccount.id();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(testAccount));

        // when
        Account result = accountUseCase.getAccountById(accountId);

        // then
        assertNotNull(result);
        assertEquals(accountId, result.id());
        verify(accountRepository).findById(accountId);
    }

    @Test
    void getAccountById_shouldThrowWhenNotFound() {
        // given
        UUID nonExistentId = UUID.randomUUID();
        when(accountRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // when & then
        assertThrows(Exception.class, () -> accountUseCase.getAccountById(nonExistentId));
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        // given
        UUID accountId = testAccount.id();
        BigDecimal depositAmount = new BigDecimal("500.00");
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(testAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

        // when
        Account result = accountUseCase.deposit(accountId, depositAmount);

        // then
        assertNotNull(result);
        assertEquals(new BigDecimal("1500.00"), result.balance());
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        // given
        UUID accountId = testAccount.id();
        BigDecimal withdrawAmount = new BigDecimal("300.00");
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(testAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

        // when
        Account result = accountUseCase.withdraw(accountId, withdrawAmount);

        // then
        assertNotNull(result);
        assertEquals(new BigDecimal("700.00"), result.balance());
    }

    @Test
    void closeAccount_shouldSetStatusToClosed() {
        // given
        UUID accountId = testAccount.id();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(testAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

        // when
        Account result = accountUseCase.closeAccount(accountId);

        // then
        assertNotNull(result);
        assertEquals(AccountStatus.CLOSED, result.status());
    }

    @Test
    void blockAccount_shouldSetStatusToBlocked() {
        // given
        UUID accountId = testAccount.id();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(testAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

        // when
        Account result = accountUseCase.blockAccount(accountId);

        // then
        assertNotNull(result);
        assertEquals(AccountStatus.BLOCKED, result.status());
    }

    @Test
    void unblockAccount_shouldSetStatusToActive() {
        // given
        Account blockedAccount = testAccount.block();
        UUID accountId = blockedAccount.id();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(blockedAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

        // when
        Account result = accountUseCase.unblockAccount(accountId);

        // then
        assertNotNull(result);
        assertEquals(AccountStatus.ACTIVE, result.status());
    }
}