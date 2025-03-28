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

Math error: Division by zero,  
Unsupported operation: POWER, 
Any other error	Internal error occurred

## Technologies Used
Java 11

Spring Boot

Maven

SLF4J + Logback (logging)

JUnit 5 (unit testing)

## Design Principles and Strategies Used
Strategy Pattern – each operation is encapsulated in its own class

Open-Closed Principle – add new operations without changing existing logic

Error Handling - Multiple exceptions along with the Global Exceptions are handled

Enum for Operations - ADD, SUBTRACT, MULTIPLY, DIVIDE operations are written as Enum as it makes easier to add more operations in future

Dependency Injection – operations wired via Spring Boot's IoC

Clean Architecture – separation of controller, service, strategy, and model layers

Testing - Unit testing is done to check if the modules are working as expected 


## Screenshots

![GET request](https://github.com/user-attachments/assets/fc7c38a1-b42e-41b1-9488-d2143bc7188e)

![POST request](https://github.com/user-attachments/assets/5efad49e-0bee-4d8b-bbd5-7d13f17211e1)

<img width="591" alt="Screenshot 2025-03-26 081404" src="https://github.com/user-attachments/assets/ed0223e6-b937-45a2-a1fb-4a1bb2119862" />




