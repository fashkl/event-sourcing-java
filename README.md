# Event Sourcing Application

This project is an implementation of an event-sourcing system using Java, Spring Boot, and Gradle. It includes a simple event store and use cases for managing bank accounts.

## Project Structure

- **Languages and Frameworks**: Java, Spring Boot, Kotlin, Gradle
- **Main Components**:
    - `EventStoreRepository`: A repository for storing and retrieving events.
    - `ApplicationConfig`: Spring configuration class for setting up beans.
    - `BankAccountUseCase`: Use case for handling bank account operations.
    - `EventSourcingApplicationTests`: Basic test to ensure the Spring context loads.
    - `BankAccountUseCaseTest`: Unit tests for the `BankAccountUseCase`.

## Getting Started

### Prerequisites

- Java 17 or higher
- Gradle
- An IDE such as IntelliJ IDEA

### Building the Project

To build the project, run the following command:

```sh
./gradlew build
```

### API Documentation
API documentation is available at `/api-documentation` when the application is running


### Testing
To run tests, use the following command:
```sh
./gradlew test
```

### Code Formatting
The project uses the Spotless plugin for code formatting. To apply formatting, run:
```sh
./gradlew spotlessApply
```

