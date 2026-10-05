package com.pragma.bankaccount.infrastructure.adapter;





import com.pragma.bankaccount.domain.model.AccountStatus;
import com.pragma.bankaccount.domain.model.AccountType;
import com.pragma.bankaccount.infrastructure.adapter.entity.AccountStatusEnum;
import com.pragma.bankaccount.infrastructure.adapter.entity.AccountTypeEnum;
import com.pragma.bankaccount.domain.model.Account;
import com.pragma.bankaccount.domain.port.AccountRepository;
import com.pragma.bankaccount.infrastructure.adapter.entity.AccountEntity;
import com.pragma.bankaccount.infrastructure.adapter.repository.AccountJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

public class AccountJpaAdapter implements AccountRepository {

    private static final Logger logger = LoggerFactory.getLogger(AccountJpaAdapter.class);

    private final AccountJpaRepository accountJpaRepository;

    public AccountJpaAdapter(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Account save(Account account) {
        logger.debug("Persisting account: {}", account.accountNumber());
        AccountEntity entity = toEntity(account);
        AccountEntity savedEntity = accountJpaRepository.save(entity);
        logger.debug("Account persisted with ID: {}", savedEntity.getId());
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        logger.debug("Finding account by ID: {}", id);
        return accountJpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        logger.debug("Finding account by account number: {}", accountNumber);
        return accountJpaRepository.findByAccountNumber(accountNumber)
                .map(this::toDomain);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        logger.debug("Checking if account exists: {}", accountNumber);
        return accountJpaRepository.existsByAccountNumber(accountNumber);
    }

    @Override
    public void deleteById(UUID id) {
        logger.debug("Deleting account by ID: {}", id);
        accountJpaRepository.deleteById(id);
    }

    private AccountEntity toEntity(Account account) {
        AccountEntity entity = new AccountEntity();
        if (account.id() != null) {
            entity.setId(account.id());
        }
        entity.setAccountNumber(account.accountNumber());
        entity.setCustomerId(account.customerId());
        entity.setBalance(account.balance());
        entity.setAccountType(AccountEntity.AccountTypeEnum.valueOf(account.accountType().name()));
        entity.setStatus(AccountEntity.AccountStatusEnum.valueOf(account.status().name()));
        entity.setCreatedAt(account.createdAt());
        entity.setUpdatedAt(account.updatedAt());
        return entity;
    }

    private Account toDomain(AccountEntity entity) {
        return new Account(
                entity.getId(),
                entity.getAccountNumber(),
                entity.getCustomerId(),
                entity.getBalance(),
                Account.AccountType.valueOf(entity.getAccountType().name()),
                Account.AccountStatus.valueOf(entity.getStatus().name()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}