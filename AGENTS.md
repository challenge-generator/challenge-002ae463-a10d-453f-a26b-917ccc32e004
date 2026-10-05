# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Integración de Asistente de IA en Desarrollo Backend**.

| | |
|---|---|
| Tema | Desarrollo |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 1 semana |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-actuator n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.projectlombok:lombok 1.18.30
- org.postgresql:postgresql 42.7.3
- io.swagger.core.v3:swagger-annotations 2.2.20
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.5.0
- org.mockito:mockito-core 5.12.0
- org.mockito:mockito-junit-jupiter 5.12.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Exploración y configuración del entorno**: Diagrama de flujo de las operaciones del servicio de gestión de cuentas y configuración del entorno de desarrollo.
- **Fase 2 — Implementación de operaciones básicas**: Código implementado para las operaciones básicas del servicio de gestión de cuentas.
- **Fase 3 — Optimización y pruebas**: Código optimizado y documentado, junto con las pruebas unitarias y de integración realizadas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/bankaccount/infrastructure/controller/AccountControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (31)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.id`
      Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.accountNumber`
      Se invoca `accountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.customerId`
      Se invoca `customerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.balance`
      Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.accountType`
      Se invoca `accountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.status`
      Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.createdAt`
      Se invoca `createdAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.updatedAt`
      Se invoca `updatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `Account.id`
      Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `Account.status`
      Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `Account.balance`
      Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.accountNumber`
      Se invoca `accountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.save`
      Se invoca `save` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.findById`
      Se invoca `findById` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.findByAccountNumber`
      Se invoca `findByAccountNumber` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.deleteById`
      Se invoca `deleteById` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.id`
      Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.customerId`
      Se invoca `customerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.balance`
      Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.accountType`
      Se invoca `accountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.status`
      Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.createdAt`
      Se invoca `createdAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.updatedAt`
      Se invoca `updatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/bankaccount/infrastructure/config/GlobalExceptionHandler.java` — `ErrorResponse.getDefaultMessage`
      Se invoca `getDefaultMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.accountNumber`
      Se invoca `accountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.customerId`
      Se invoca `customerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.status`
      Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.id`
      Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.balance`
      Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (21)

- `pom.xml`
- `src/main/java/com/pragma/bankaccount/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/bankaccount/domain/model/Account.java`
- `src/main/java/com/pragma/bankaccount/domain/port/AccountRepository.java`
- `src/main/java/com/pragma/bankaccount/domain/port/AccountService.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/repository/AccountJpaRepository.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountRequest.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java`
- `src/main/java/com/pragma/bankaccount/domain/exception/AccountNotFoundException.java`
- `src/main/java/com/pragma/bankaccount/domain/exception/InvalidAccountException.java`
- `src/main/java/com/pragma/bankaccount/domain/exception/AccountAlreadyExistsException.java`
- `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/entity/AccountEntity.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/AccountController.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/config/GlobalExceptionHandler.java`
- `src/main/java/com/pragma/bankaccount/infrastructure/config/OpenApiConfig.java`
- `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java`
- `src/test/java/com/pragma/bankaccount/infrastructure/controller/AccountControllerTest.java`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/bankaccount`
- `src/main/java/com/pragma/bankaccount/domain`
- `src/main/java/com/pragma/bankaccount/domain/model`
- `src/main/java/com/pragma/bankaccount/domain/port`
- `src/main/java/com/pragma/bankaccount/application`
- `src/main/java/com/pragma/bankaccount/application/usecase`
- `src/main/java/com/pragma/bankaccount/infrastructure`
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter`
- `src/main/java/com/pragma/bankaccount/infrastructure/config`
- `src/main/java/com/pragma/bankaccount/infrastructure/controller`
- `src/main/resources`
- `src/test/java/com/pragma/bankaccount`
- `src/test/java/com/pragma/bankaccount/application`
- `src/test/java/com/pragma/bankaccount/infrastructure`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior
- Brecha que el reto ataca: Ha trabajado con un asistente de IA (Github Copilot / Amazon CodeWhisperer /etc)
- Mision: Candidato con experiencia en desarrollo backend con Java, buscando fortalecer su trabajo con herramientas de IA generativa.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
