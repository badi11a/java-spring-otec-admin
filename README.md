# Sistema de Gestión de Cursos - OTEC Admin

Este proyecto es un mantenedor CRUD completo desarrollado en **Spring Boot**, diseñado para la administración de la malla de cursos y cohortes de una OTEC (Talento Digital). Sirve como una base educativa robusta que implementa estándares de la industria como arquitectura de capas, validaciones de backend, borrado lógico y el uso estricto del patrón **DTO**.

## 🚀 Características Principales

* **CRUD Completo:** Listar, crear, editar y eliminar cursos de la malla.
* **Borrado Lógico (Soft Delete):** Los cursos no se eliminan físicamente de la base de datos por temas de auditoría, sino que cambian su estado a inactivo (`activo = false`).
* **Blindaje de Datos:** Validaciones de backend (`@NotBlank`, `@Min`, `@NotNull`) para evitar el ingreso de datos corruptos, con feedback visual en los formularios.
* **Experiencia de Usuario (UX):** Uso de *Flash Attributes* de Spring para mostrar mensajes de éxito tras cada operación.

## 🏗️ Arquitectura del Proyecto

El proyecto sigue un riguroso patrón de **3 Capas** para asegurar la escalabilidad y facilitar el mantenimiento:

1. **Modelo (Entity):** Representación de la tabla `cursos` en MariaDB mediante JPA.
2. **Repositorio:** Interfaz que extiende de `JpaRepository` para operaciones de persistencia.
3. **Servicio:** Capa de lógica de negocio donde se realiza el mapeo bidireccional de Entidades a DTOs.
4. **Controlador:** Maneja las peticiones HTTP, gestiona errores de validación y devuelve las vistas.
5. **DTO (Data Transfer Object):** Objetos de transferencia para aislar la base de datos y exponer solo los datos necesarios a la vista web.

## 🛠️ Tecnologías Utilizadas

* **Java 17+**
* **Spring Boot 3.x** (Web, Data JPA, Validation)
* **Thymeleaf** (Motor de plantillas SSR)
* **MariaDB** (Base de datos relacional)
* **Maven** (Gestión de dependencias)

## 📋 Requisitos Previos y Configuración

1. Contar con una instancia de **MariaDB** corriendo localmente y crear una base de datos llamada `otec_admin_db`.
2. Por seguridad, las credenciales no están versionadas. Debes duplicar o renombrar el archivo `src/main/resources/application.properties.example` dejándolo como `application.properties`.
3. Ingresar tu usuario y contraseña de base de datos en el nuevo archivo `application.properties`.
4. Al levantar el proyecto, la propiedad `spring.jpa.hibernate.ddl-auto=update` generará la estructura de la tabla automáticamente.

## 🛣️ Próximos Pasos (Roadmap)

* **Seguridad:** Implementación de **Spring Security** para crear un panel de Login y proteger las rutas del administrador.
* **Paginación y Búsqueda:** Incorporar la interfaz `Pageable` para manejar grandes volúmenes de cursos y una barra de búsqueda por código o nombre.