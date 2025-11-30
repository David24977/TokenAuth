# TokenAuth – API de Login con Token UUID

## API REST sencilla para autenticar un usuario ya registrado y generar un token UUID con expiración automática.
### El backend contiene:

- Entidad Usuario (id, username, password, token, tokenExpiration)

- Endpoint /login: valida credenciales y genera un token nuevo

- Token UUID almacenado en base de datos

- Expiración configurable en horas desde application.properties.

- Endpoint protegido /usuarios accesible solo con token válido

## La API está pensada para practicar conceptos de autenticación sin usar Spring Security, ideal para ejercicios de nivel intermedio.

## Requisitos técnicos:
- Java 21
- Spring Boot
- MySQL
