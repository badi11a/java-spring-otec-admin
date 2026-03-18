# Java Spring Boot: Vinilo Demo (MVC + DTO)

Este proyecto es una base educativa para el aprendizaje de **Spring Boot**, enfocada en la implementación de una arquitectura de capas, el uso de **Thymeleaf** y el patrón **DTO**.

## 🚀 Arquitectura del Proyecto

El proyecto sigue un patrón de **3 Capas** para asegurar la escalabilidad y facilitar el mantenimiento futuro:

1. **Modelo (Entity):** Representación de la tabla `vinilos` en MariaDB mediante JPA.
2. **Repositorio:** Interfaz que extiende de `JpaRepository` para operaciones CRUD automáticas.
3. **Servicio:** Capa de lógica de negocio donde se realiza el mapeo de Entidades a DTOs.
4. **Controlador:** Maneja las peticiones HTTP y devuelve las vistas de Thymeleaf.
5. **DTO (Data Transfer Object):** Objetos de transferencia para exponer datos seguros a la vista.

## 🛠️ Tecnologías Utilizadas

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **Thymeleaf** (Motor de plantillas)
* **MariaDB** (Base de datos)
* **Maven** (Gestión de dependencias)

## 📋 Requisitos Previos

1. Contar con una instancia de **MariaDB** corriendo localmente.
2. Configurar las credenciales en `src/main/resources/application.properties`.
3. La propiedad `spring.jpa.hibernate.ddl-auto=update` está activa para generar la tabla automáticamente al inicio.

## 🛣️ Próximos Pasos

* Implementación de **Spring Security** para control de acceso basado en roles.
* Creación de formularios de registro con encriptación de contraseñas (**BCrypt**).
* Gestión de sesiones y perfiles de usuario.
