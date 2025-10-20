# PDF Async Service

This project is a Spring Boot application for asynchronous PDF processing and order management, using RabbitMQ for messaging and JWT for authentication.

## Features
- Asynchronous order processing via RabbitMQ
- PDF generation and handling
- JWT-based authentication and authorization
- RESTful API endpoints

## Technologies
- Java 17+
- Spring Boot
- RabbitMQ
- JWT (JSON Web Token)
- Maven

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- Docker (for RabbitMQ)

### Setup
1. Clone the repository:
   ```
   git clone <your-repo-url>
   ```
2. Start RabbitMQ using Docker Compose:
   ```
   docker-compose up -d
   ```
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

## API Endpoints

### Order
- `POST /orders/public/send` - Send a new order for processing

### Authentication
- JWT endpoints for token generation and validation (see JwtController)

## Configuration
Application settings can be found in `src/main/resources/application.yml` and `application-local.yml`.

## Testing
Run tests with:
```
mvn test
```

## License
This project is licensed under the MIT License.

## Contact
For questions or support, contact the maintainer at: <your-email>

