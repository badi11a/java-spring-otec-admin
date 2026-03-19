# Sistema de Gestión de Cursos - OTEC Admin

Este proyecto es un mantenedor CRUD funcional desarrollado en **Spring Boot**, diseñado para la administración de la malla de cursos y **secciones** de un Organismo Técnico de Capacitación (OTEC), como los dictados para Talento Digital. Sirve como una base educativa que implementa estándares de la industria como arquitectura de capas y el uso estricto del patrón **DTO**.

## 🚀 Características Principales

* **CRUD Básico Completo:** Capacidad para listar, crear, editar y eliminar (físicamente) cursos y secciones de la base de datos.
* **Separación de Responsabilidades:** Código estructurado para diferenciar claramente la lógica de acceso a datos, las reglas de negocio y la presentación web.

## 🏗️ Arquitectura del Proyecto

El proyecto sigue un riguroso patrón de **3 Capas** para asegurar la escalabilidad y facilitar la enseñanza:

1. **Modelo (Entity):** Representación de la tabla `cursos` en MariaDB mediante JPA.
2. **Repositorio:** Interfaz que extiende de `JpaRepository` para operaciones de persistencia automatizadas.
3. **Servicio:** Capa de lógica de negocio donde se realiza el mapeo bidireccional de Entidades a DTOs.
4. **Controlador:** Maneja las peticiones HTTP y devuelve las vistas web renderizadas.
5. **DTO (Data Transfer Object):** Objetos de transferencia para aislar la base de datos y exponer solo los datos necesarios a la vista.

## 🛠️ Tecnologías Utilizadas

* **Java 17+**
* **Spring Boot 3.x** (Web, Data JPA)
* **Thymeleaf** (Motor de plantillas)
* **MariaDB** (Base de datos relacional)
* **Maven** (Gestión de dependencias)

## 🗄️ Script de Base de Datos

Para iniciar el proyecto desde cero, ejecuta el siguiente script en tu gestor de base de datos (ej. HeidiSQL o DBeaver). Este script crea la base de datos y la estructura de la tabla, sin incluir datos de prueba:

```sql
-- 1. Creamos la base de datos si no existe
CREATE DATABASE IF NOT EXISTS otec_admin_db;

-- 2. Le decimos a MariaDB que use esta base de datos
USE otec_admin_db;

-- 3. Destruimos la tabla antigua si existe para evitar conflictos
DROP TABLE IF EXISTS cursos;

-- 4. Creamos la tabla desde cero con la estructura definitiva
CREATE TABLE cursos (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    canal VARCHAR(50) COMMENT 'Identificador de la sección o cohorte (ej. EA-AD-1)',
    codigo VARCHAR(50) COMMENT 'Código SENCE o interno del curso',
    nombre VARCHAR(255) COMMENT 'Nombre oficial del curso',
    instructor VARCHAR(100) COMMENT 'Nombre del relator asignado',
    duracion_horas INT COMMENT 'Total de horas cronológicas',
    categoria VARCHAR(100) COMMENT 'Área de estudio (ej. Programación, Datos e IA)',
    activo BOOLEAN COMMENT 'Estado para el borrado lógico (1=Activo, 0=Inactivo)'
);