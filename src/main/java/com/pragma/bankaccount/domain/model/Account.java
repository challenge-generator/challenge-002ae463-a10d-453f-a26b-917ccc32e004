package com.pragma.bankaccount.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entidad del dominio que representa una cuenta bancaria.
 * Contiene la lógica de negocio relacionada con el estado y operaciones de la cuenta.
 */
public record Account(
    UUID id,
    String accountNumber,
    String customerId,
    BigDecimal balance,
    AccountType accountType,
    AccountStatus status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {

    /**
     * Tipos de cuenta soportados.
     */
    public enum AccountType {
        SAVINGS, CHECKING, FIXED_TERM
    }

    /**
     * Estados posibles de una cuenta.
     */
    public enum AccountStatus {
        ACTIVE, BLOCKED, CLOSED
    }

    /**
     * Crea una nueva cuenta con los valores iniciales requeridos.
     * @param accountNumber Número único de la cuenta
     * @param customerId Identificador del cliente propietario
     * @param initialBalance Saldo inicial (debe ser >= 0)
     * @param accountType Tipo de cuenta
     * @return Nueva instancia de Account con estado ACTIVE y fechas de creación/actualización
     * @throws IllegalArgumentException si el saldo inicial es negativo
     */
    public static Account create(String accountNumber, String customerId, BigDecimal initialBalance, AccountType accountType) {
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        LocalDateTime now = LocalDateTime.now();
        return new Account(
            UUID.randomUUID(),
            accountNumber,
            customerId,
            initialBalance,
            accountType,
            AccountStatus.ACTIVE,
            now,
            now
        );
    }

    /**
     * Aplica un depósito a la cuenta.
     * @param amount Monto a depositar (debe ser positivo)
     * @return Nueva instancia de Account con el saldo actualizado
     * @throws IllegalArgumentException si el monto es negativo o cero
     */
    public Account deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        return new Account(
            this.id,
            this.accountNumber,
            this.customerId,
            this.balance.add(amount),
            this.accountType,
            this.status,
            this.createdAt,
            LocalDateTime.now()
        );
    }

    /**
     * Aplica un retiro a la cuenta.
     * @param amount Monto a retirar (debe ser positivo y <= saldo disponible)
     * @return Nueva instancia de Account con el saldo actualizado
     * @throws IllegalArgumentException si el monto es negativo, cero o supera el saldo disponible
     */
    public Account withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro");
        }
        return new Account(
            this.id,
            this.accountNumber,
            this.customerId,
            this.balance.subtract(amount),
            this.accountType,
            this.status,
            this.createdAt,
            LocalDateTime.now()
        );
    }

    /**
     * Cierra la cuenta si el saldo es cero.
     * @return Nueva instancia de Account con estado CLOSED
     * @throws IllegalStateException si el saldo no es cero
     */
    public Account close() {
        if (this.balance.compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("No se puede cerrar una cuenta con saldo diferente a cero");
        }
        return new Account(
            this.id,
            this.accountNumber,
            this.customerId,
            this.balance,
            this.accountType,
            AccountStatus.CLOSED,
            this.createdAt,
            LocalDateTime.now()
        );
    }

    /**
     * Bloquea la cuenta.
     * @return Nueva instancia de Account con estado BLOCKED
     */
    public Account block() {
        return new Account(
            this.id,
            this.accountNumber,
            this.customerId,
            this.balance,
            this.accountType,
            AccountStatus.BLOCKED,
            this.createdAt,
            LocalDateTime.now()
        );
    }

    /**
     * Reactiva una cuenta bloqueada.
     * @return Nueva instancia de Account con estado ACTIVE
     * @throws IllegalStateException si la cuenta no está bloqueada
     */
    public Account unblock() {
        if (this.status != AccountStatus.BLOCKED) {
            throw new IllegalStateException("Solo se puede reactivar una cuenta bloqueada");
        }
        return new Account(
            this.id,
            this.accountNumber,
            this.customerId,
            this.balance,
            this.accountType,
            AccountStatus.ACTIVE,
            this.createdAt,
            LocalDateTime.now()
        );
    }
}