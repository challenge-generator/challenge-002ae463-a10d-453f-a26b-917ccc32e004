package com.pragma.bankaccount;





import com.pragma.bankaccount.domain.exception.AccountAlreadyExistsException;
import com.pragma.bankaccount.infrastructure.controller.dto.AccountRequest;
import com.pragma.bankaccount.infrastructure.adapter.AccountJpaAdapter;
import com.pragma.bankaccount.application.usecase.AccountUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeTracer;

import java.time.Clock;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public InMemoryHttpExchangeTracer httpExchangeTracer() {
        return new InMemoryHttpExchangeTracer();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner();
    }

    public static class ApplicationRunner {
        private final AccountUseCase accountUseCase;
        private final AccountJpaAdapter accountJpaAdapter;

        public ApplicationRunner(AccountUseCase accountUseCase, AccountJpaAdapter accountJpaAdapter) {
            this.accountUseCase = accountUseCase;
            this.accountJpaAdapter = accountJpaAdapter;
            validateDependencies();
            initializeSampleData();
        }

        private void validateDependencies() {
            if (accountUseCase == null) {
                throw new IllegalStateException("AccountUseCase no puede ser nulo");
            }
            if (accountJpaAdapter == null) {
                throw new IllegalStateException("AccountJpaAdapter no puede ser nulo");
            }
        }

        private void initializeSampleData() {
            try {
                accountUseCase.createAccount(new AccountRequest("123456789", "John Doe", "SAVINGS", 1000.0));
                accountUseCase.createAccount(new AccountRequest("987654321", "Jane Smith", "CHECKING", 500.0));
            } catch (AccountAlreadyExistsException e) {
                // Ignorar si ya existen
            } catch (Exception e) {
                throw new IllegalStateException("Error al inicializar datos de prueba", e);
            }
        }
    }
}