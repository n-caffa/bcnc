# Tariff Service API

## Descripción

Tariff Service API es una aplicación basada en Spring Boot que proporciona un servicio REST para consultar tarifas aplicables para productos específicos de una cadena en función de la fecha y hora de la consulta. La aplicación utiliza una base de datos en memoria (H2) para almacenar los datos de tarifas y utiliza Spring Data JPA para la persistencia.

## Características

- Consulta de tarifas aplicables según la fecha y hora.
- Orden de prioridad en caso de tarifas superpuestas.
- Base de datos H2 en memoria para facilitar pruebas y desarrollo.
- Tests unitarios completos utilizando JUnit y Mockito.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database**
- **JUnit 5**
- **Mockito**

## Estructura del Proyecto

El proyecto sigue la arquitectura hexagonal, dividiendo la lógica de negocio, los casos de uso y las adaptaciones externas (como los controladores y los repositorios de bases de datos).

```plaintext
com.prueba.bcnc
│
├── application
│   └── usecase
│       └── TariffUseCase.java
│
├── domain
│   ├── model
│   │   └── Tariff.java
│   ├── repository
│   │   └── TariffRepository.java
│
├── infrastructure
│   ├── controller
│   │   └── TariffController.java
│   ├── persistence
│   │   └── TariffEntity.java
│   ├── repository
│   │   └── JpaTariffRepository.java
│
└── shared
    ├── dto
    │   └── TariffDto.java
    ├── exception
    │   └── TariffNotFoundException.java
    