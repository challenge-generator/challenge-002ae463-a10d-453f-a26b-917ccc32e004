package com.pragma.bankaccount.domain.port;


import com.pragma.bankaccount.domain.model.AccountType;
import com.pragma.bankaccount.domain.model.Account;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Puerto de entrada para operaciones de negocio de cuentas.
 * Define los contratos que la capa de aplicación debe implementar.
 */
public interface AccountService {

    /**
     * Crea una nueva cuenta bancaria.
     * @param accountNumber Número único de la cuenta
     * @param customerId Identificador del cliente propietario
     * @param initialBalance Saldo inicial (debe ser >= 0)
     * @param accountType Tipo de cuenta
     * @return La cuenta creada
     * @throws com.pragma.bankaccount.domain.exception.AccountAlreadyExistsException si ya existe una cuenta con el mismo número
     * @throws IllegalArgumentException si los parámetros son inválidos
     */
    Account createAccount(String accountNumber, String customerId, BigDecimal initialBalance, Account.AccountType accountType);

    /**
     * Busca una cuenta por su ID.
     * @param id Identificador de la cuenta
     * @return La cuenta encontrada
     * @throws com.pragma.bankaccount.domain.exception.AccountNotFoundException si no existe una cuenta con el ID dado
     */
    Account getAccountById(UUID id);

    /**
     * Busca una cuenta por su número de cuenta.
     * @param accountNumber Número de cuenta
     * @return La cuenta encontrada
     * @throws com.pragma.bankaccount.domain.exception.AccountNotFoundException si no existe una cuenta con el número dado
     */
    Account getAccountByAccountNumber(String accountNumber);

    /**
     * Realiza un depósito en una cuenta.
     * @param accountId Identificador de la cuenta
     * @param amount Monto a depositar (debe ser positivo)
     * @return La cuenta con el saldo actualizado
     * @throws com.pragma.bankaccount.domain.exception.AccountNotFoundException si no existe la cuenta
     * @throws IllegalArgumentException si el monto es inválido
     */
    Account deposit(UUID accountId, BigDecimal amount);

    /**
     * Realiza un retiro de una cuenta.
     * @param accountId Identificador de la cuenta
     * @param amount Monto a retirar (debe ser positivo y <= saldo disponible)
     * @return La cuenta con el saldo actualizado
     * @throws com.pragma.bankaccount.domain.exception.AccountNotFoundException si no existe la cuenta
     * @throws IllegalArgumentException si el monto es inválido
     */
    Account withdraw(UUID accountId, BigDecimal amount);

    /**
     * Cierra una cuenta.
     * @param accountId Identificador de la cuenta
     * @return La cuenta cerrada
     * @throws com.pragma.bankaccount.domain.exception.AccountNotFoundException si no existe la cuenta
     * @throws IllegalStateException si la cuenta no puede cerrarse (ej. saldo diferente a cero)
     */
    Account closeAccount(UUID accountId);

    /**
     * Bloquea una cuenta.
     * @param accountId Identificador de la cuenta
     * @return La cuenta bloqueada
     * @throws com.pragma.bankaccount.domain.exception.AccountNotFoundException si no existe la cuenta
     */
    Account blockAccount(UUID accountId);

    /**
     * Reactiva una cuenta bloqueada.
     * @param accountId Identificador de la cuenta
     * @return La cuenta reactivada
     * @throws com.pragma.bankaccount.domain.exception.AccountNotFoundException si no existe la cuenta
     * @throws IllegalStateException si la cuenta no está bloqueada
     */
    Account unblockAccount(UUID accountId);
}