# Flexible Calculator API  
A flexible, extensible Spring Boot calculator API that supports basic and chained arithmetic operations. Built using the **Strategy Pattern**, it adheres to the **Open-Closed Principle (OCP)** and follows clean architecture practices.  
## Features  
- Perform basic arithmetic operations: `ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`  
- Chain multiple operations in a single request  
- Easily extendable using the `OperationStrategy` interface  
- Follows **SOLID** design principles  
- Global exception handling with SLF4J logging  
- Lightweight — no database required  
## Architecture Overview  
- `controller/` → Handles REST API endpoints  
- `service/` → Performs business logic and chaining  
- `strategy/` → Contains separate operation implementations (Strategy Pattern)  
- `model/` → DTOs for requests and responses  
- `exception/` → Centralized exception handling  
##  API Endpoints  
### 1. Basic Operation  
**Endpoint:**  
 
```GET http://localhost:8080/api/calculator/basic?op=ADD&a=10&b=5 ```   
 
### Response:

```15.0```

### 2. Chained Operations
**Endpoint:**

```POST http://localhost:8080/api/calculator/chain  ```

Content-Type: application/json

### Request:
```
{
  "initialValue": 5,
  "steps": [
    { "operation": "ADD", "value": 3 },
    { "operation": "MULTIPLY", "value": 2 }
  ]
}
```
### Response:

```{ "result": 16.0 }```



## Getting Started
### Prerequisites
Java 11+

Maven

IntelliJ IDEA or any Java IDE

## Run the Application

mvn spring-boot:run

App will be available at:
http://localhost:8080

## Exception Handling

Math error: Division by zero 
Unsupported operation: POWER
Any other error	Internal error occurred

## Technologies Used
Java 11

Spring Boot

Maven

SLF4J + Logback (logging)

JUnit 5 (unit testing)

## Design Principles
Strategy Pattern – each operation is encapsulated in its own class

Open-Closed Principle – add new operations without changing existing logic

Dependency Injection – operations wired via Spring Boot's IoC

Clean Architecture – separation of controller, service, strategy, and model layers



## Screenshots

![GET request.png](https://github.com/PandiriSid/LyricsGenerator/assets/34942083/2a935a3d-83e8-4bd9-847f-958d9ec05ea0)

![GET request.png](https://github.com/PandiriSid/LyricsGenerator/assets/34942083/2a935a3d-83e8-4bd9-847f-958d9ec05ea0)

