# PDF Async Service

This project is a Spring Boot application for asynchronous PDF processing and order management, using RabbitMQ for messaging, JWT for authentication, and Ollama for AI processing.

## Installing Ollama and the gemma3:1b model
Ollama is required for AI features. Install it before running the application:

- Download and install Ollama for Windows: [https://ollama.com/download](https://ollama.com/download)
- After installing, download the required gemma3:1b model:
  ```
  ollama pull gemma3:1b
  ```
- To run the model:
  ```
  ollama run gemma3:1b
  ```
- To check if the model is available:
  ```
  ollama list
  ```
- Ollama and the gemma3:1b model must be running before starting the PDF service.

## Generated PDF
The service generates PDF reports with a modern design:
- **Blue header** with the title "Relatório Inteligente" and subtitle.
- **Expanded gray card** filling the usable page area, with a blue accent bar on the left.
- **Basic Markdown support**: headings (##), bold (**text**), lists (- or *), paragraphs, and automatic spacing.
- The "Resposta da Inteligência Artificial" title has been removed from the PDF body.
- The report content can be customized via API, accepting simple formatted text.

### Visual Example
```
┌─────────────────────────────────────────────┐
│ Relatório Inteligente                      │
│ Generated automatically by the system      │
├─────────────────────────────────────────────┤
│ ▌                                         │
│ ▌  [Formatted content: headings,           │
│ ▌   lists, bold, etc.]                     │
│ ▌                                         │
└─────────────────────────────────────────────┘
```

### Customization
Send the report text via API, using simple Markdown to highlight headings, lists, and bold. The service automatically handles page breaks and layout.

## Features
- Asynchronous order processing via RabbitMQ
- PDF generation and manipulation with modern layout
- Authentication and authorization via JWT
- Integration with Ollama for AI
- RESTful endpoints

## Technologies
- Java 17+
- Spring Boot
- RabbitMQ
- JWT (JSON Web Token)
- Ollama
- Maven

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- Docker (for RabbitMQ)
- Ollama installed and running with the gemma3:1b model

### Setup
1. Clone the repository:
   ```
   git clone https://github.com/jose-matheusc/pdf
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

### PDF Generation
- `POST /public/pdf/generate` - Send content to generate a custom PDF

### Authentication
- JWT endpoints for token generation and validation (see JwtController) - not required for basic usage

## Configuration
Settings are in `src/main/resources/application.yml` and `application-local.yml`.

## Tests
Run tests with:
```
mvn test
```

## Contact
Questions or support: josematheus.profissional@gmail.com
