# Banco Simplificado

API REST em Java inspirada no desafio de backend do PicPay. O projeto modela usuários com saldo e tipos diferentes, além de transferências com validação e persistência.

## Funcionalidades

- Criar, consultar e excluir usuários.
- Listar usuários e transferências.
- Criar transferências entre usuários.
- Validar valor positivo, saldo disponível, tipo do pagador e transferências para a própria conta.
- Consultar um serviço externo de autorização antes de efetivar uma transferência.
- Enviar uma notificação assíncrona ao pagador após a transferência.
- Expor documentação OpenAPI/Swagger e links HATEOAS em respostas de usuários.

## Tecnologias

- Java 21 e Spring Boot 3.4
- Spring Web, Validation, Security e Data JPA
- MySQL
- Springdoc OpenAPI, HATEOAS e ModelMapper
- Docker para o banco de dados

## Como executar localmente

Requisitos: JDK 21, Docker e PowerShell (ou Bash).

1. Inicie o MySQL em Docker:

```bash
docker run --name bancodb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=banco -d -p 3333:3306 mysql:8
```

2. Na raiz do repositório, inicie a API:

PowerShell:

```powershell
$env:DATASOURCE_URL = "jdbc:mysql://localhost:3333/banco"
$env:DATASOURCE_USERNAME = "root"
$env:DATASOURCE_PASSWORD = "root"
.mvnw.cmd spring-boot:run
```

Bash:

```bash
DATASOURCE_URL=jdbc:mysql://localhost:3333/banco \
DATASOURCE_USERNAME=root \
DATASOURCE_PASSWORD=root \
./mvnw spring-boot:run
```

A API usa a porta padrão 8080. O arquivo comandos-docker.txt contém um comando de referência para o banco; o comando acima explicita as duas variáveis de ambiente do MySQL.

## Endpoints principais

| Método | Rota | Descrição |
| --- | --- | --- |
| POST | /user | Cria um usuário. |
| GET | /user | Lista usuários. |
| GET | /user/{id} | Consulta usuário pelo UUID. |
| DELETE | /user/{id} | Exclui usuário, sujeito à validação de saldo. |
| POST | /transaction | Solicita uma transferência. |
| GET | /transaction | Lista transferências. |

A documentação interativa do Swagger fica em http://localhost:8080/swagger-ui/index.html; a especificação OpenAPI fica em /v3/api-docs.

## Configuração de integrações

A conexão com o banco pode ser configurada por DATASOURCE_URL, DATASOURCE_USERNAME e DATASOURCE_PASSWORD.

A autorização de transferências consulta o serviço externo https://util.devi.tools/api/v2/authorize. Para a notificação, o serviço espera outro serviço HTTP acessível em {MAIL_IP}:8081/mail; configure MAIL_IP conforme o ambiente. A integração de email não é autocontida neste repositório.

## Organização do código

```text
controllers/   Rotas HTTP para usuários e transações
services/      Regras de aplicação e casos de uso
repositories/  Acesso a dados com Spring Data JPA
models/        Entidades e tipos de usuário
dtov2/         Objetos de entrada e saída da API
validator/     Validações de usuários e transferências
exceptions/    Exceções e tratamento global de erros
config/        Configurações do Spring
docs/          Anotações OpenAPI dos endpoints
```

## Testes

Para executar os testes existentes:

PowerShell:

```powershell
.mvnw.cmd test
```

Bash:

```bash
./mvnw test
```

## Observações sobre o escopo atual

Este projeto demonstra uma API de estudo e integração com serviços externos. A configuração atual libera as requisições HTTP sem autenticação. A lógica de persistência e notificação representa o estado do código neste repositório e deve ser avaliada como parte de um projeto demonstrativo, não como uma plataforma bancária pronta para produção.
