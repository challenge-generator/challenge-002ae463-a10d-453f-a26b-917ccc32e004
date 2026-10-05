package com.pragma.bankaccount.infrastructure.adapter.repository;

import com.pragma.bankaccount.infrastructure.adapter.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {

    boolean existsByAccountNumber(String accountNumber);

    @Query("SELECT a FROM AccountEntity a WHERE a.customerId = :customerId AND a.status = 'ACTIVE'")
    List<AccountEntity> findActiveAccountsByCustomerId(@Param("customerId") String customerId);

    @Query("SELECT a FROM AccountEntity a WHERE a.accountType = :accountType AND a.status = 'ACTIVE'")
    List<AccountEntity> findActiveAccountsByType(@Param("accountType") String accountType);

    @Query("SELECT COUNT(a) FROM AccountEntity a WHERE a.customerId = :customerId")
    long countByCustomerId(@Param("customerId") String customerId);

    @Query("SELECT a FROM AccountEntity a WHERE a.balance >= :minBalance AND a.status = 'ACTIVE'")
    List<AccountEntity> findAccountsWithMinimumBalance(@Param("minBalance") java.math.BigDecimal minBalance);
}