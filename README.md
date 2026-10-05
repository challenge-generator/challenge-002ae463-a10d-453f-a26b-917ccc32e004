# Integración de Asistente de IA en Desarrollo Backend

El objetivo es fortalecer la habilidad de un desarrollador backend con experiencia en Java para trabajar con herramientas de IA generativa, como Github Copilot o Amazon CodeWhisperer, para mejorar la eficiencia y calidad del código. El desarrollador trabajará en un proyecto de banca donde debe integrar un asistente de IA en el proceso de desarrollo de un servicio de gestión de cuentas. El servicio debe manejar operaciones de consulta, creación, actualización y eliminación de cuentas, asegurando la consistencia de los datos y la idempotencia de las operaciones. El sistema debe procesar un mínimo de 10 000 operaciones por segundo con un tiempo de respuesta promedio inferior a 50ms.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollo |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 1 semana |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Exploración y configuración del entorno

**Objetivo:** Configurar el entorno de desarrollo para utilizar un asistente de IA y comprender las operaciones básicas del servicio de gestión de cuentas.

**Tiempo estimado:** 1 día

**Instrucciones:**

- Configura el entorno de desarrollo para utilizar Github Copilot o Amazon CodeWhisperer.
- Identifica las operaciones básicas del servicio de gestión de cuentas: consulta, creación, actualización y eliminación.
- Crea un diagrama de flujo que represente el proceso de cada operación.

**Entregable:** Diagrama de flujo de las operaciones del servicio de gestión de cuentas y configuración del entorno de desarrollo.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las ventajas y limitaciones de utilizar un asistente de IA en el proceso de desarrollo.
- Reflexiona sobre cómo el asistente puede mejorar la eficiencia y calidad del código.

</details>

### Fase 2: Implementación de operaciones básicas

**Objetivo:** Implementar las operaciones básicas del servicio de gestión de cuentas utilizando el asistente de IA.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Implementa la operación de consulta de cuentas utilizando el asistente de IA.
- Implementa la operación de creación de cuentas utilizando el asistente de IA.
- Implementa la operación de actualización de cuentas utilizando el asistente de IA.
- Implementa la operación de eliminación de cuentas utilizando el asistente de IA.

**Entregable:** Código implementado para las operaciones básicas del servicio de gestión de cuentas.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza el asistente de IA para generar código y mejorar la eficiencia del proceso de desarrollo.
- Reflexiona sobre las mejores prácticas para integrar el asistente de IA en el proceso de desarrollo.

</details>

### Fase 3: Optimización y pruebas

**Objetivo:** Optimizar el código implementado y realizar pruebas para asegurar la calidad y eficiencia del servicio.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Optimiza el código implementado utilizando el asistente de IA.
- Realiza pruebas unitarias y de integración para asegurar la calidad y eficiencia del servicio.
- Documenta el proceso de optimización y las pruebas realizadas.

**Entregable:** Código optimizado y documentado, junto con las pruebas unitarias y de integración realizadas.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza el asistente de IA para identificar áreas de mejora en el código y optimizar su rendimiento.
- Reflexiona sobre las mejores prácticas para realizar pruebas unitarias y de integración en un servicio backend.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un asistente de IA y cómo puede ser utilizado en el proceso de desarrollo?
- **paraQueSirve**: ¿Para qué sirve integrar un asistente de IA en el proceso de desarrollo de un servicio backend?
- **comoSeUsa**: ¿Cómo se utiliza un asistente de IA para generar código y mejorar la eficiencia del proceso de desarrollo?
- **erroresComunes**: ¿Cuáles son los errores comunes al integrar un asistente de IA en el proceso de desarrollo?
- **queDecisionesImplica**: ¿Qué decisiones implica la integración de un asistente de IA en el proceso de desarrollo de un servicio backend?

## Criterios de Evaluacion

- Configuración correcta del entorno de desarrollo para utilizar un asistente de IA.
- Implementación de las operaciones básicas del servicio de gestión de cuentas utilizando el asistente de IA.
- Optimización del código implementado y realización de pruebas unitarias y de integración para asegurar la calidad y eficiencia del servicio.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
