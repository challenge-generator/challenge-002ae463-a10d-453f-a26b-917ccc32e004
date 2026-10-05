package com.pragma.bankaccount.application.usecase;



import com.pragma.bankaccount.domain.model.AccountStatus;
import com.pragma.bankaccount.domain.model.AccountType;
import com.pragma.bankaccount.domain.model.Account;
import com.pragma.bankaccount.domain.port.AccountRepository;
import com.pragma.bankaccount.domain.exception.AccountNotFoundException;
import com.pragma.bankaccount.domain.exception.InvalidAccountException;
import com.pragma.bankaccount.domain.exception.AccountAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountUseCase {

    private static final Logger logger = LoggerFactory.getLogger(AccountUseCase.class);
    private static final BigDecimal MINIMUM_OPENING_BALANCE = new BigDecimal("50.00");
    private static final BigDecimal MAXIMUM_WITHDRAWAL_AMOUNT = new BigDecimal("10000.00");

    private final AccountRepository accountRepository;

    public AccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String accountNumber, String customerId, 
                                  BigDecimal initialBalance, Account.AccountType accountType) {
        logger.info("Creating account for customer: {} with initial balance: {}", customerId, initialBalance);

        if (accountRepository.existsByAccountNumber(accountNumber)) {
            logger.warn("Account number already exists: {}", accountNumber);
            throw new AccountAlreadyExistsException("Account number already exists: " + accountNumber);
        }

        if (initialBalance.compareTo(MINIMUM_OPENING_BALANCE) < 0) {
            logger.warn("Initial balance {} is below minimum {}", initialBalance, MINIMUM_OPENING_BALANCE);
            throw new InvalidAccountException("Initial balance must be at least " + MINIMUM_OPENING_BALANCE);
        }

        if (accountType == null) {
            throw new InvalidAccountException("Account type cannot be null");
        }

        Account account = Account.create(accountNumber, customerId, initialBalance, accountType);
        Account savedAccount = accountRepository.save(account);
        logger.info("Account created successfully with ID: {}", savedAccount.id());
        return savedAccount;
    }

    public Account getAccountById(UUID id) {
        logger.debug("Fetching account by ID: {}", id);
        return accountRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Account not found with ID: {}", id);
                    return new AccountNotFoundException("Account not found with ID: " + id);
                });
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        logger.debug("Fetching account by account number: {}", accountNumber);
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> {
                    logger.error("Account not found with account number: {}", accountNumber);
                    return new AccountNotFoundException("Account not found with account number: " + accountNumber);
                });
    }

    public Account deposit(UUID accountId, BigDecimal amount) {
        logger.info("Depositing {} to account: {}", amount, accountId);

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAccountException("Deposit amount must be positive");
        }

        Account account = getAccountById(accountId);

        if (account.status() == Account.AccountStatus.CLOSED) {
            throw new InvalidAccountException("Cannot deposit to a closed account");
        }

        if (account.status() == Account.AccountStatus.BLOCKED) {
            throw new InvalidAccountException("Cannot deposit to a blocked account");
        }

        Account updatedAccount = account.deposit(amount);
        Account savedAccount = accountRepository.save(updatedAccount);
        logger.info("Deposit successful. New balance: {}", savedAccount.balance());
        return savedAccount;
    }

    public Account withdraw(UUID accountId, BigDecimal amount) {
        logger.info("Withdrawing {} from account: {}", amount, accountId);

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAccountException("Withdrawal amount must be positive");
        }

        if (amount.compareTo(MAXIMUM_WITHDRAWAL_AMOUNT) > 0) {
            throw new InvalidAccountException("Withdrawal amount exceeds maximum limit of " + MAXIMUM_WITHDRAWAL_AMOUNT);
        }

        Account account = getAccountById(accountId);

        if (account.status() == Account.AccountStatus.CLOSED) {
            throw new InvalidAccountException("Cannot withdraw from a closed account");
        }

        if (account.status() == Account.AccountStatus.BLOCKED) {
            throw new InvalidAccountException("Cannot withdraw from a blocked account");
        }

        if (account.balance().compareTo(amount) < 0) {
            throw new InvalidAccountException("Insufficient funds for withdrawal");
        }

        Account updatedAccount = account.withdraw(amount);
        Account savedAccount = accountRepository.save(updatedAccount);
        logger.info("Withdrawal successful. New balance: {}", savedAccount.balance());
        return savedAccount;
    }

    public Account closeAccount(UUID accountId) {
        logger.info("Closing account: {}", accountId);
        Account account = getAccountById(accountId);

        if (account.balance().compareTo(BigDecimal.ZERO) > 0) {
            throw new InvalidAccountException("Cannot close account with remaining balance. Current balance: " + account.balance());
        }

        Account updatedAccount = account.close();
        Account savedAccount = accountRepository.save(updatedAccount);
        logger.info("Account closed successfully");
        return savedAccount;
    }

    public Account blockAccount(UUID accountId) {
        logger.info("Blocking account: {}", accountId);
        Account account = getAccountById(accountId);
        Account updatedAccount = account.block();
        Account savedAccount = accountRepository.save(updatedAccount);
        logger.info("Account blocked successfully");
        return savedAccount;
    }

    public Account unblockAccount(UUID accountId) {
        logger.info("Unblocking account: {}", accountId);
        Account account = getAccountById(accountId);
        Account updatedAccount = account.unblock();
        Account savedAccount = accountRepository.save(updatedAccount);
        logger.info("Account unblocked successfully");
        return savedAccount;
    }
}