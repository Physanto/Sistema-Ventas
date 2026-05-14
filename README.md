# 💄 Sistema de Gestión y Control para Almacén de Belleza (Caso de Estudio Real)

> Un proyecto integrador de arquitectura de bases de datos diseñado para resolver retos operativos de una microempresa real, llevando un negocio tradicional al entorno digital.

## 📖 Descripción del Proyecto

Detrás de cada pequeño negocio hay una historia de esfuerzo y trabajo constante. Este proyecto nace de la necesidad de modernizar un almacén local de belleza y cuidado personal. Actualmente, el negocio lleva sus registros de ventas de manera manual en un cuaderno, lo que deja al descubierto la necesidad de herramientas informáticas para gestionar el inventario y mantener un seguimiento de los clientes. 

Este repositorio contiene el análisis, diagnóstico y el diseño técnico de la arquitectura de datos que servirá como núcleo (backend/database) para un futuro sistema de gestión integral.

---

## ⚠️ Definición del Problema

El establecimiento opera bajo una dinámica de alta exigencia, ya que funciona simultáneamente como punto de venta al por menor y corresponsal bancario, todo bajo la administración de una sola persona. Las principales dificultades operativas son:

*   **Gestión Manual:** Errores humanos al registrar las ventas diarias de manera tradicional.
*   **Inventario "a ciegas":** Dependencia exclusiva de la memoria de la propietaria para saber qué productos están disponibles, limitando las decisiones de compra.
*   **Falta de trazabilidad:** Ausencia de registros que permitan identificar a los compradores más frecuentes y sus preferencias.
*   **Sobrecarga Operativa:** Manejar dos líneas de servicio (retail y bancario) sin apoyo tecnológico.

---

## 💡 La Solución Propuesta

Para evitar la burocratización y mantener la eficiencia sin sobrecargar al usuario final, se diseñó una solución tecnológica centrada en una **base de datos relacional** robusta. Esta estructura está pensada para conectarse en el futuro a una interfaz gráfica, abarcando tres pilares:

1.  📦 **Módulo de Inventario:** Estructura para consultar en tiempo real productos, precios, cantidades y referencias.
2.  💰 **Historial de Ventas:** Organización de los movimientos diarios para automatizar el cálculo de ganancias y generar reportes.
3.  👥 **Gestión de Clientes:** Almacenamiento estratégico de datos para conocer el flujo del mercado y fidelizar compradores.

---

## ⚙️ Arquitectura y Detalles Técnicos

El núcleo de este proyecto es su diseño de datos, estructurado lógicamente para garantizar la integridad referencial, la normalización de la información (evitando redundancias) y un rendimiento óptimo en consultas complejas (JOINs).

### 🛠️ Stack Tecnológico
*   **Modelado de Datos:** Herramientas de diagramación Entidad-Relación.
*   **Motor de Base de Datos:** Relacional (Ej. MariaDB / MySQL / PostgreSQL).
*   **Lenguaje de Consulta:** SQL estructurado para la creación de esquemas (DDL) y manipulación de datos (DML).
*   **Lenguaje de Programación** Java para hacer toda la comunicación y que el cliente pueda usar dicha solucion de manera efectiva.

### 🗄️ Modelos de Base de Datos

*   **Modelo Entidad-Relación (MER):** El diseño conceptual que mapea cómo interactúan las entidades principales del negocio en la vida real.
    🔗 **[Ver Modelo Entidad-Relación en alta resolución](https://drive.google.com/file/d/135jb7oCBtHnsel1Vi2tm6hiJc_YEMCDj/view?usp=sharing)**

*   **Modelo Relacional:** La estructura lógica y técnica lista para ser desplegada en el motor de bases de datos, detallando llaves primarias (PK), llaves foráneas (FK) y tipos de datos.
    🔗 **[Ver Modelo Relacional en alta resolución](https://drive.google.com/file/d/1kfs0PLRZxRSs6qeNupG6Eo9KeaGxDZ_g/view?usp=sharing)**

### 🚀 Instalación y Despliegue (Próximamente)
1. Clonar este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repo.git

### Autores
- Manuel David Escobar Figueroa (https://github.com/Physanto)
- Juan David Meneses (https://github.com/hiTimmyy)
