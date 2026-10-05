# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/bankaccount/infrastructure/controller/AccountControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.id`: Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.accountNumber`: Se invoca `accountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.customerId`: Se invoca `customerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.balance`: Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.accountType`: Se invoca `accountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.status`: Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.createdAt`: Se invoca `createdAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java` — `Account.updatedAt`: Se invoca `updatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `Account.id`: Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `Account.status`: Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java` — `Account.balance`: Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.accountNumber`: Se invoca `accountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.save`: Se invoca `save` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.findById`: Se invoca `findById` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.findByAccountNumber`: Se invoca `findByAccountNumber` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `AccountJpaRepository.deleteById`: Se invoca `deleteById` sobre `AccountJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.id`: Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.customerId`: Se invoca `customerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.balance`: Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.accountType`: Se invoca `accountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.status`: Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.createdAt`: Se invoca `createdAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java` — `Account.updatedAt`: Se invoca `updatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/bankaccount/infrastructure/config/GlobalExceptionHandler.java` — `ErrorResponse.getDefaultMessage`: Se invoca `getDefaultMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.accountNumber`: Se invoca `accountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.customerId`: Se invoca `customerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.status`: Se invoca `status` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.id`: Se invoca `id` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java` — `Account.balance`: Se invoca `balance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior

### Brecha de conocimiento
Ha trabajado con un asistente de IA (Github Copilot / Amazon CodeWhisperer /etc)

### Misión / candidato
Candidato con experiencia en desarrollo backend con Java, buscando fortalecer su trabajo con herramientas de IA generativa.

### Reto
- Tema: Desarrollo
- Seniority: senior-l2
- Tipo: practical
- Título: Integración de Asistente de IA en Desarrollo Backend
- Tiempo estimado: 1 semana

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Exploración y configuración del entorno — objetivo: Configurar el entorno de desarrollo para utilizar un asistente de IA y comprender las operaciones básicas del servicio de gestión de cuentas. — entregable (NO resolver): Diagrama de flujo de las operaciones del servicio de gestión de cuentas y configuración del entorno de desarrollo.
- Fase 2: Implementación de operaciones básicas — objetivo: Implementar las operaciones básicas del servicio de gestión de cuentas utilizando el asistente de IA. — entregable (NO resolver): Código implementado para las operaciones básicas del servicio de gestión de cuentas.
- Fase 3: Optimización y pruebas — objetivo: Optimizar el código implementado y realizar pruebas para asegurar la calidad y eficiencia del servicio. — entregable (NO resolver): Código optimizado y documentado, junto con las pruebas unitarias y de integración realizadas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>bankaccount</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>bankaccount</name>
    <description>Servicio de gestión de cuentas bancarias</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>

        <!-- PostgreSQL -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Swagger/OpenAPI -->
        <dependency>
            <groupId>io.swagger.core.v3</groupId>
            <artifactId>swagger-annotations</artifactId>
            <version>2.2.20</version>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.5.0</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/bankaccount/Application.java ===
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

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080
  servlet:
    context-path: /api/v1

spring:
  application:
    name: bankaccount-service
  datasource:
    url: jdbc:postgresql://localhost:5432/bankaccount
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      idle-timeout: 30000
      max-lifetime: 120000
      connection-timeout: 30000
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        jdbc:
          batch_size: 50
        order_inserts: true
        order_updates: true

management:
  endpoints:
    web:
      exposure:
        include: health,metrics,prometheus,httptrace
  endpoint:
    health:
      show-details: always
  metrics:
    tags:
      application: ${spring.application.name}

logging:
  level:
    root: INFO
    com.pragma.bankaccount: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.web: INFO
    org.springframework.transaction: DEBUG

// === ARCHIVO: src/main/java/com/pragma/bankaccount/domain/model/Account.java ===
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

// === ARCHIVO: src/main/java/com/pragma/bankaccount/domain/port/AccountRepository.java ===
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

// === ARCHIVO: src/main/java/com/pragma/bankaccount/domain/port/AccountService.java ===
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

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/adapter/repository/AccountJpaRepository.java ===
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

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountRequest.java ===
package com.pragma.bankaccount.infrastructure.controller.dto;


import com.pragma.bankaccount.domain.model.AccountType;
import com.pragma.bankaccount.domain.model.Account;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AccountRequest(

    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    String accountNumber,

    @NotBlank(message = "El ID del cliente es obligatorio")
    @Size(min = 5, max = 50, message = "El ID del cliente debe tener entre 5 y 50 caracteres")
    String customerId,

    @NotNull(message = "El saldo inicial es obligatorio")
    @DecimalMin(value = "0.0", message = "El saldo no puede ser negativo")
    BigDecimal initialBalance,

    @NotNull(message = "El tipo de cuenta es obligatorio")
    Account.AccountType accountType
) {
    public AccountRequest {
        if (initialBalance != null && initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/controller/dto/AccountResponse.java ===
package com.pragma.bankaccount.infrastructure.controller.dto;



import com.pragma.bankaccount.domain.model.AccountStatus;
import com.pragma.bankaccount.domain.model.AccountType;
import com.pragma.bankaccount.domain.model.Account;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Schema(description = "Respuesta de cuenta bancaria")
public record AccountResponse(

    @Schema(description = "ID único de la cuenta", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id,

    @Schema(description = "Número de cuenta", example = "1234567890123456")
    String accountNumber,

    @Schema(description = "ID del cliente", example = "CUST-001")
    String customerId,

    @Schema(description = "Saldo actual de la cuenta", example = "1000.00")
    BigDecimal balance,

    @Schema(description = "Tipo de cuenta", example = "SAVINGS")
    Account.AccountType accountType,

    @Schema(description = "Estado de la cuenta", example = "ACTIVE")
    Account.AccountStatus status,

    @Schema(description = "Fecha de creación de la cuenta", example = "2024-01-15T10:30:00Z")
    Instant createdAt,

    @Schema(description = "Fecha de última modificación", example = "2024-01-15T10:30:00Z")
    Instant updatedAt
) {
    public static AccountResponse fromDomain(Account account) {
        return new AccountResponse(
            account.id(),
            account.accountNumber(),
            account.customerId(),
            account.balance(),
            account.accountType(),
            account.status(),
            account.createdAt(),
            account.updatedAt()
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/domain/exception/AccountNotFoundException.java ===
package com.pragma.bankaccount.domain.exception;


import com.pragma.bankaccount.domain.model.Account;
public class AccountNotFoundException extends RuntimeException {

    private final String accountId;
    private final String accountNumber;
    private final String searchCriteria;

    public AccountNotFoundException(String message) {
        super(message);
        this.accountId = null;
        this.accountNumber = null;
        this.searchCriteria = null;
    }

    public AccountNotFoundException(String message, String accountId) {
        super(message);
        this.accountId = accountId;
        this.accountNumber = null;
        this.searchCriteria = "ID";
    }

    public AccountNotFoundException(String message, String accountNumber, boolean byAccountNumber) {
        super(message);
        this.accountId = null;
        this.accountNumber = accountNumber;
        this.searchCriteria = byAccountNumber ? "ACCOUNT_NUMBER" : "UNKNOWN";
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.accountId = null;
        this.accountNumber = null;
        this.searchCriteria = null;
    }

    public AccountNotFoundException(String message, String accountId, Throwable cause) {
        super(message, cause);
        this.accountId = accountId;
        this.accountNumber = null;
        this.searchCriteria = "ID";
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public String getDetailedMessage() {
        StringBuilder details = new StringBuilder();
        details.append("AccountNotFoundException: ").append(getMessage());
        
        if (accountId != null) {
            details.append(" | Account ID: ").append(accountId);
        }
        if (accountNumber != null) {
            details.append(" | Account Number: ").append(accountNumber);
        }
        if (searchCriteria != null) {
            details.append(" | Search Criteria: ").append(searchCriteria);
        }
        
        return details.toString();
    }

    @Override
    public String toString() {
        return getDetailedMessage();
    }
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/domain/exception/InvalidAccountException.java ===
package com.pragma.bankaccount.domain.exception;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvalidAccountException extends RuntimeException {

    private final List<ValidationError> validationErrors;
    private final String field;
    private final Object rejectedValue;
    private final String errorCode;

    public static class ValidationError {
        private final String field;
        private final String message;
        private final Object rejectedValue;

        public ValidationError(String field, String message, Object rejectedValue) {
            this.field = field;
            this.message = message;
            this.rejectedValue = rejectedValue;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }

        @Override
        public String toString() {
            return String.format("Field: %s, Message: %s, Rejected Value: %s", 
                field, message, rejectedValue != null ? rejectedValue : "null");
        }
    }

    public InvalidAccountException(String message) {
        super(message);
        this.validationErrors = new ArrayList<>();
        this.field = null;
        this.rejectedValue = null;
        this.errorCode = "INVALID_ACCOUNT";
    }

    public InvalidAccountException(String message, String field, Object rejectedValue) {
        super(message);
        this.validationErrors = new ArrayList<>();
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.errorCode = "INVALID_ACCOUNT";
    }

    public InvalidAccountException(String message, String field, Object rejectedValue, String errorCode) {
        super(message);
        this.validationErrors = new ArrayList<>();
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.errorCode = errorCode;
    }

    public InvalidAccountException(String message, List<ValidationError> validationErrors) {
        super(message);
        this.validationErrors = validationErrors != null ? validationErrors : new ArrayList<>();
        this.field = null;
        this.rejectedValue = null;
        this.errorCode = "VALIDATION_ERRORS";
    }

    public InvalidAccountException(String message, Throwable cause) {
        super(message, cause);
        this.validationErrors = new ArrayList<>();
        this.field = null;
        this.rejectedValue = null;
        this.errorCode = "INVALID_ACCOUNT";
    }

    public void addValidationError(String field, String message, Object rejectedValue) {
        this.validationErrors.add(new ValidationError(field, message, rejectedValue));
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public String getField() {
        return field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public boolean hasValidationErrors() {
        return !validationErrors.isEmpty();
    }

    public String getDetailedMessage() {
        StringBuilder details = new StringBuilder();
        details.append("InvalidAccountException: ").append(getMessage());
        details.append(" | Error Code: ").append(errorCode);
        
        if (field != null) {
            details.append(" | Field: ").append(field);
        }
        if (rejectedValue != null) {
            details.append(" | Rejected Value: ").append(rejectedValue);
        }
        
        if (!validationErrors.isEmpty()) {
            details.append(" | Validation Errors: ").append(validationErrors.size());
            for (ValidationError error : validationErrors) {
                details.append(" | ").append(error.toString());
            }
        }
        
        return details.toString();
    }

    @Override
    public String toString() {
        return getDetailedMessage();
    }
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/domain/exception/AccountAlreadyExistsException.java ===
package com.pragma.bankaccount.domain.exception;


import com.pragma.bankaccount.domain.model.Account;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountAlreadyExistsException extends RuntimeException {

    private final String accountNumber;
    private final String customerId;
    private final UUID existingAccountId;
    private final LocalDateTime existingAccountCreationDate;
    private final List<DuplicateField> duplicateFields;

    public static class DuplicateField {
        private final String fieldName;
        private final Object value;

        public DuplicateField(String fieldName, Object value) {
            this.fieldName = fieldName;
            this.value = value;
        }

        public String getFieldName() {
            return fieldName;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.format("%s: %s", fieldName, value);
        }
    }

    public AccountAlreadyExistsException(String message) {
        super(message);
        this.accountNumber = null;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
    }

    public AccountAlreadyExistsException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
    }

    public AccountAlreadyExistsException(String message, String accountNumber, String customerId) {
        super(message);
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
        this.duplicateFields.add(new DuplicateField("customerId", customerId));
    }

    public AccountAlreadyExistsException(String message, String accountNumber, String customerId, 
                                          UUID existingAccountId, LocalDateTime creationDate) {
        super(message);
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.existingAccountId = existingAccountId;
        this.existingAccountCreationDate = creationDate;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
        if (customerId != null) {
            this.duplicateFields.add(new DuplicateField("customerId", customerId));
        }
    }

    public AccountAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
        this.accountNumber = null;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
    }

    public AccountAlreadyExistsException(String message, String accountNumber, Throwable cause) {
        super(message, cause);
        this.accountNumber = accountNumber;
        this.customerId = null;
        this.existingAccountId = null;
        this.existingAccountCreationDate = null;
        this.duplicateFields = new ArrayList<>();
        this.duplicateFields.add(new DuplicateField("accountNumber", accountNumber));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public UUID getExistingAccountId() {
        return existingAccountId;
    }

    public LocalDateTime getExistingAccountCreationDate() {
        return existingAccountCreationDate;
    }

    public List<DuplicateField> getDuplicateFields() {
        return duplicateFields;
    }

    public boolean hasExistingAccount() {
        return existingAccountId != null;
    }

    public String getDetailedMessage() {
        StringBuilder details = new StringBuilder();
        details.append("AccountAlreadyExistsException: ").append(getMessage());
        
        if (accountNumber != null) {
            details.append(" | Account Number: ").append(accountNumber);
        }
        if (customerId != null) {
            details.append(" | Customer ID: ").append(customerId);
        }
        if (existingAccountId != null) {
            details.append(" | Existing Account ID: ").append(existingAccountId);
        }
        if (existingAccountCreationDate != null) {
            details.append(" | Created At: ").append(existingAccountCreationDate);
        }
        
        if (!duplicateFields.isEmpty()) {
            details.append(" | Duplicate Fields: ");
            for (DuplicateField field : duplicateFields) {
                details.append(field.toString()).append(", ");
            }
            details.delete(details.length() - 2, details.length());
        }
        
        return details.toString();
    }

    @Override
    public String toString() {
        return getDetailedMessage();
    }
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/application/usecase/AccountUseCase.java ===
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

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/adapter/AccountJpaAdapter.java ===
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

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/adapter/entity/AccountEntity.java ===
package com.pragma.bankaccount.infrastructure.adapter.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts", indexes = {
        @Index(name = "idx_account_number", columnList = "account_number", unique = true),
        @Index(name = "idx_customer_id", columnList = "customer_id"),
        @Index(name = "idx_status", columnList = "status")
})
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Column(name = "customer_id", nullable = false, length = 50)
    private String customerId;

    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false, length = 20)
    private AccountTypeEnum accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private AccountStatusEnum status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public AccountEntity() {
    }

    public AccountEntity(String accountNumber, String customerId, BigDecimal balance,
                         AccountTypeEnum accountType, AccountStatusEnum status,
                         LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public AccountStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AccountStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public enum AccountTypeEnum {
        SAVINGS,
        CHECKING,
        CREDIT
    }

    public enum AccountStatusEnum {
        ACTIVE,
        BLOCKED,
        CLOSED
    }
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/controller/AccountController.java ===
package com.pragma.bankaccount.infrastructure.controller;

import com.pragma.bankaccount.domain.model.Account;
import com.pragma.bankaccount.domain.port.AccountService;
import com.pragma.bankaccount.infrastructure.controller.dto.AccountRequest;
import com.pragma.bankaccount.infrastructure.controller.dto.AccountResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/accounts")
@Tag(name = "Cuentas", description = "API para la gestión de cuentas bancarias")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva cuenta", description = "Crea una cuenta bancaria con los datos proporcionados")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest request) {
        Account account = accountService.createAccount(
                request.accountNumber(),
                request.customerId(),
                request.initialBalance(),
                request.accountType()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(AccountResponse.fromDomain(account));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cuenta por ID", description = "Recupera los detalles de una cuenta específica")
    public ResponseEntity<AccountResponse> getAccountById(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @GetMapping("/number/{accountNumber}")
    @Operation(summary = "Obtener cuenta por número", description = "Busca una cuenta por su número de cuenta")
    public ResponseEntity<AccountResponse> getAccountByNumber(
            @Parameter(description = "Número de cuenta") @PathVariable String accountNumber) {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @GetMapping
    @Operation(summary = "Listar todas las cuentas", description = "Retorna todas las cuentas registradas en el sistema")
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping("/{id}/deposit")
    @Operation(summary = "Depositar funds", description = "Realiza un depósito en la cuenta especificada")
    public ResponseEntity<AccountResponse> deposit(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id,
            @Parameter(description = "Monto a depositar") @RequestParam BigDecimal amount) {
        Account account = accountService.deposit(id, amount);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/withdraw")
    @Operation(summary = "Retirar funds", description = "Realiza un retiro de la cuenta especificada")
    public ResponseEntity<AccountResponse> withdraw(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id,
            @Parameter(description = "Monto a retirar") @RequestParam BigDecimal amount) {
        Account account = accountService.withdraw(id, amount);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/close")
    @Operation(summary = "Cerrar cuenta", description = "Cierra una cuenta bancaria")
    public ResponseEntity<AccountResponse> closeAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.closeAccount(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/block")
    @Operation(summary = "Bloquear cuenta", description = "Bloquea una cuenta bancaria")
    public ResponseEntity<AccountResponse> blockAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.blockAccount(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @PostMapping("/{id}/unblock")
    @Operation(summary = "Desbloquear cuenta", description = "Desbloquea una cuenta bancaria")
    public ResponseEntity<AccountResponse> unblockAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        Account account = accountService.unblockAccount(id);
        return ResponseEntity.ok(AccountResponse.fromDomain(account));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cuenta", description = "Elimina una cuenta del sistema")
    public ResponseEntity<Void> deleteAccount(
            @Parameter(description = "UUID de la cuenta") @PathVariable UUID id) {
        accountService.closeAccount(id);
        return ResponseEntity.noContent().build();
    }
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/config/GlobalExceptionHandler.java ===
package com.pragma.bankaccount.infrastructure.config;

import com.pragma.bankaccount.domain.exception.AccountAlreadyExistsException;
import com.pragma.bankaccount.domain.exception.AccountNotFoundException;
import com.pragma.bankaccount.domain.exception.InvalidAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFound(AccountNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "CUENTA_NO_ENCONTRADA",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAccountAlreadyExists(AccountAlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "CUENTA_YA_EXISTE",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(InvalidAccountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAccount(InvalidAccountException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "CUENTA_INVALIDA",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ValidationErrorResponse response = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "ERROR_DE_VALIDACION",
                "Los datos proporcionados no son validos",
                errors,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "ARGUMENTO_INVALIDO",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "ERROR_INTERNO",
                "Ocurrio un error inesperado en el sistema",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    public record ErrorResponse(
            int status,
            String code,
            String message,
            LocalDateTime timestamp
    ) {}

    public record ValidationErrorResponse(
            int status,
            String code,
            String message,
            Map<String, String> fieldErrors,
            LocalDateTime timestamp
    ) {}
}

// === ARCHIVO: src/main/java/com/pragma/bankaccount/infrastructure/config/OpenApiConfig.java ===
package com.pragma.bankaccount.infrastructure.config;


import com.pragma.bankaccount.domain.model.Account;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bankAccountOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bank Account Management API")
                        .description("API REST para la gestión de cuentas bancarias. " +
                                "Permite operaciones de consulta, creación, actualización y eliminación de cuentas.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@pragma.com")
                                .url("https://www.pragma.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Token JWT para autenticación")));
    }
}

// === ARCHIVO: src/test/java/com/pragma/bankaccount/application/usecase/AccountUseCaseTest.java ===
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

// === ARCHIVO: src/test/java/com/pragma/bankaccount/infrastructure/controller/AccountControllerTest.java ===
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

// === ARCHIVO: README.md ===
# Bank Account Service

Servicio de gestión de cuentas bancarias desarrollado con Spring Boot 3.5 y Java 21.

## Requisitos

- Java 21
- Maven 3.8+
- PostgreSQL 15+

## Configuración

### Base de datos

El servicio utiliza PostgreSQL. Configura las siguientes variables de entorno o modifica `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bankaccount
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

### Variables de entorno

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| `SERVER_PORT` | Puerto del servidor | `8080` |
| `DB_HOST` | Host de PostgreSQL | `localhost` |
| `DB_PORT` | Puerto de PostgreSQL | `5432` |
| `DB_NAME` | Nombre de la base de datos | `bankaccount` |
| `DB_USER` | Usuario de PostgreSQL | `postgres` |
| `DB_PASSWORD` | Contraseña de PostgreSQL | `postgres` |

## Construcción

```bash
mvn clean compile
```

## Ejecución

```bash
mvn spring-boot:run
```

## API

### Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| POST | `/api/v1/accounts` | Crear cuenta |
| GET | `/api/v1/accounts/{id}` | Obtener cuenta por ID |
| GET | `/api/v1/accounts/number/{accountNumber}` | Obtener cuenta por número |
| POST | `/api/v1/accounts/{id}/deposit` | Depositar fondos |
| POST | `/api/v1/accounts/{id}/withdraw` | Retirar fondos |
| POST | `/api/v1/accounts/{id}/close` | Cerrar cuenta |
| POST | `/api/v1/accounts/{id}/block` | Bloquear cuenta |
| POST | `/api/v1/accounts/{id}/unblock` | Desbloquear cuenta |

### Documentación Swagger

Accede a la documentación interactive en: `http://localhost:8080/swagger-ui.html`

### Health Check

Verifica el estado del servicio en: `http://localhost:8080/actuator/health`

## Arquitectura

El proyecto sigue una arquitectura hexagonal (ports & adapters):

- **domain**: Entidades, puertos e interfaces (`Account`, `AccountRepository`, `AccountService`)
- **application**: Casos de uso (`AccountUseCase`)
- **infrastructure**: Adaptadores, controladores y configuración

## Pruebas

```bash
mvn test
```

Ejecutar solo pruebas unitarias:
```bash
mvn test -Dtest=AccountUseCaseTest
```

Ejecutar solo pruebas de integración:
```bash
mvn test -Dtest=AccountControllerTest
```

## Rendimiento

El servicio está diseñado para procesar un mínimo de 10,000 operaciones por segundo con un tiempo de respuesta promedio inferior a 50ms.
```
