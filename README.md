# StreamVibe Backend Microservices 🚀🎬

Welcome to the backend architecture for the **StreamVibe** streaming platform! This robust, enterprise-grade architecture is built completely on **Java Spring Boot** and **Spring Cloud**, separating core domains into dedicated microservices.

## 🏗️ Architecture Layout

This project follows an API-Gateway centralized routing topology with Service Discovery.

- **`gateway-service` (Port 8080)**: The single entry point. Routes incoming client requests to exact microservices using Spring Cloud Gateway.
- **`discovery-service` (Port 8761)**: Netflix Eureka Server. Allows microservices to find each other dynamically without hardcoded URLs.
- **`config-service` (Port 8888)**: Centralized configuration server pointing to a local `config-repo`, feeding properties to all services.
- **`user-service` (Port 8082)**: Manages User data, Watchlists, and detailed Watch Histories. Uses OpenFeign to communicate directly with the Video Service.
- **`video-service` (Port 8081)**: Manages the video content catalog (Categories, Release Years, Full textual data).
- **`auth-service` (Port 8084)**: Stateless JWT provider that validates and signs tokens for securing internal interactions.
- **`monitor-service` (Port 8083)**: A beautiful **Spring Boot Admin** UI that visualizes logs, JVM memory garbage collection, and status checks of all active microservices.

## 🛠️ Tech Stack & Databases

- **Java 17** / **Spring Boot 3.2+**
- **Spring Cloud** (Netflix Eureka, Spring Cloud Gateway, OpenFeign, Spring Cloud Config)
- **PostgreSQL 15** (Dedicated, isolated instances for User Service and Video Service)
- **Docker & Docker Compose** for streamlined orchestration.
- **JUnit 5 / Mockito** for comprehensive unit testing covering controllers and services.

## 🚀 How to Run (Normally via Docker Compose)

> Note: The Docker Compose scripts are purposely ignored from this repository to ensure infrastructure decoupling as per deployment strategy.

To run locally, you will need to:

1. Start the microservices in the correct dependency order: `config-service` -> `discovery-service` -> `video-service` / `user-service` / `auth-service` -> `gateway-service` / `monitor-service`.
2. Connect them to PostgreSQL instances running on ports `5432` and `5433`.

## 🧪 Testing

Comprehensive unit tests are written for `user-service` and `video-service`.
To run tests, navigate into the respective folder and execute:

```bash
mvn clean test
```

The services maintain an excellent line coverage for Domain models, DTO Mappers, Core Business Logic inside Services, and MockMvc tests for Controllers.
