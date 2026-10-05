package com.pragma.bankaccount.domain.port;

import com.pragma.bankaccount.domain.model.Account;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para operaciones de persistencia de cuentas.
 * Define los contratos que la capa de infraestructura debe implementar.
 */
public interface AccountRepository {

    /**
     * Guarda una cuenta en el repositorio.
     * @param account La cuenta a guardar
     * @return La cuenta guardada con su ID generado
     */
    Account save(Account account);

    /**
     * Busca una cuenta por su ID.
     * @param id Identificador de la cuenta
     * @return Optional con la cuenta si existe, vacío si no
     */
    Optional<Account> findById(UUID id);

    /**
     * Busca una cuenta por su número de cuenta.
     * @param accountNumber Número de cuenta
     * @return Optional con la cuenta si existe, vacío si no
     */
    Optional<Account> findByAccountNumber(String accountNumber);

    /**
     * Verifica si existe una cuenta con el número dado.
     * @param accountNumber Número de cuenta a verificar
     * @return true si existe, false si no
     */
    boolean existsByAccountNumber(String accountNumber);

    /**
     * Elimina una cuenta por su ID.
     * @param id Identificador de la cuenta a eliminar
     */
    void deleteById(UUID id);
}