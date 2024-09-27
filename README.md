# CooperativaGestionCuenta
API REST para el manejo de cuentas en banco.

# Gestión de Clientes y Cuentas de Ahorros

Este proyecto es una aplicación desarrollada en Java utilizando Spring Boot, destinada a gestionar la información de los clientes y sus cuentas de ahorros en una cooperativa. 

## Descripción del Proyecto

La cooperativa requiere un servicio que permita gestionar la información de sus clientes, que incluye la creación de clientes y cuentas de ahorros, así como la realización de movimientos en las cuentas.

## Funcionalidades

El servicio implementa los siguientes endpoints:

1. **Crear Cliente**
   - **Descripción**: Permite crear un cliente en el sistema.
   - **Entrada**: NIT, nombre y fecha de ingreso.
   - **Salida**: Mensaje y código de resultado (éxito o error).

2. **Consultar Cliente**
   - **Descripción**: Consulta la información de un cliente.
   - **Entrada**: NIT del cliente.
   - **Salida**: Información completa del cliente (NIT, nombre, fecha de ingreso).

3. **Crear Cuenta de Ahorros**
   - **Descripción**: Crea una cuenta de ahorros asociada a un cliente.
   - **Entrada**: NIT del cliente, número de cuenta y saldo inicial.
   - **Validaciones**:
     - Verifica que el cliente exista.
     - Verifica que la cuenta de ahorros no exista previamente.
   - **Salida**: Mensaje y código de resultado (éxito o error).

4. **Generar Movimiento en la Cuenta de Ahorros**
   - **Descripción**: Realiza movimientos (créditos o débitos) en una cuenta de ahorros.
   - **Entrada**: NIT del cliente, número de cuenta, monto y tipo de movimiento (DB para débito, CR para crédito).
   - **Validaciones**:
     - Verifica que el cliente y la cuenta de ahorros existan.
     - Verifica que haya saldo suficiente para un débito.
   - **Salida**: Mensaje y código de resultado.

## Consideraciones Técnicas

- **Tecnologías**: Spring Boot para el desarrollo del servicio.
- **Base de Datos**: Se utilizó una base de datos postgresql dada.
- **Estructura**: El código está organizado en capas: controladores, servicios y repositorios.
- **Manejo de Excepciones**: Implementación de validaciones y manejo de excepciones.
- **Inyección de Dependencias**: Utilización de inyección de dependencias y gestión de transacciones donde sea necesario.
- **Control de Versiones**: Se manejó Git con diferentes commits a lo largo del desarrollo.
- **Pruebas**: Se implementaron pruebas unitarias utilizando H2 para facilitar la ejecución de pruebas.

## Requisitos
Para ejecutar el proyecto, asegúrate de tener instalado:
- Java 11 o superior
- Maven

