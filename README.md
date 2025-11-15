# PDF Async Service

Este projeto é uma aplicação Spring Boot para processamento assíncrono de PDFs e gestão de pedidos, usando RabbitMQ para mensageria, JWT para autenticação e Ollama para processamento de IA.

## Instalação do Ollama e do modelo gemma3:1b
Ollama é necessário para funcionalidades de IA. Instale antes de rodar a aplicação:

- Baixe e instale Ollama para Windows: [https://ollama.com/download](https://ollama.com/download)
- Após instalar, baixe o modelo obrigatório gemma3:1b:
  ```
  ollama pull gemma3:1b
  ```
- Para rodar o modelo:
  ```
  ollama run gemma3:1b
  ```
- Para verificar se o modelo está disponível:
  ```
  ollama list
  ```
- Ollama e o modelo gemma3:1b devem estar ativos antes de iniciar o serviço PDF.

## PDF Gerado
O serviço gera relatórios em PDF com design moderno:
- **Cabeçalho azul** com título "Relatório Inteligente" e subtítulo.
- **Card cinza expandido** ocupando toda a área útil da página, com barra lateral azul à esquerda.
- **Suporte a Markdown básico**: títulos (##), negrito (**texto**), listas (- ou *), parágrafos e espaçamento automático.
- O título "Resposta da Inteligência Artificial" foi removido do corpo do PDF.
- O conteúdo do relatório pode ser personalizado via API, aceitando texto com formatação simples.

### Exemplo visual
```
┌─────────────────────────────────────────────┐
│ Relatório Inteligente                      │
│ Gerado automaticamente pelo sistema        │
├─────────────────────────────────────────────┤
│ ▌                                         │
│ ▌  [Conteúdo formatado, com títulos,       │
│ ▌   listas, negrito, etc.]                 │
│ ▌                                         │
└─────────────────────────────────────────────┘
```

### Personalização
Envie o texto do relatório via API, usando Markdown simples para destacar títulos, listas e negrito. O serviço cuida da quebra de página e do layout automaticamente.

## Features
- Processamento assíncrono de pedidos via RabbitMQ
- Geração e manipulação de PDFs com layout moderno
- Autenticação e autorização via JWT
- Integração com Ollama para IA
- Endpoints RESTful

## Technologies
- Java 17+
- Spring Boot
- RabbitMQ
- JWT (JSON Web Token)
- Ollama
- Maven

## Getting Started

### Pré-requisitos
- Java 17 ou superior
- Maven
- Docker (para RabbitMQ)
- Ollama instalado e rodando com o modelo gemma3:1b

### Setup
1. Clone o repositório:
   ```
   git clone https://github.com/jose-matheusc/pdf
   ```
2. Inicie o RabbitMQ usando Docker Compose:
   ```
   docker-compose up -d
   ```
3. Compile o projeto:
   ```
   mvn clean install
   ```
4. Execute a aplicação:
   ```
   mvn spring-boot:run
   ```

## API Endpoints

### Pedido
- `POST /orders/public/send` - Envia um novo pedido para processamento

### Autenticação
- Endpoints JWT para geração e validação de token (veja JwtController)

## Configuração
As configurações estão em `src/main/resources/application.yml` e `application-local.yml`.

## Testes
Execute os testes com:
```
mvn test
```

## Licença
Este projeto está sob a licença MIT.

## Contato
Dúvidas ou suporte: <your-email>
