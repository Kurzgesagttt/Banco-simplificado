## Instruções e Requisitos

- A api roda com um banco de dados no docker, e pode ser executado com a linha de comando em comandos-docker.txt
- A api necessita de uma conta de email e senha para o serviço de envio de email pela biblioteca java mail sender
# 📦 API - Projeto com Envio de Emails

Este projeto é uma API desenvolvida com Java Spring, utilizando diversas tecnologias modernas para integração, persistência de dados e envio de emails. A aplicação utiliza Docker para facilitar o ambiente de execução e depende de uma conta de email válida para realizar o envio de mensagens via JavaMailSender.

## 🚀 Tecnologias Utilizadas

- **Java 21 (JDK 21)**  
  Linguagem principal do projeto.

- **Spring Boot**  
  Framework para facilitar o desenvolvimento de aplicações Java modernas.

- **Spring Data JPA**  
  Abstração para persistência de dados com MySQL, utilizando o padrão ORM.

- **MySQL**  
  Banco de dados relacional utilizado pela aplicação.

- **Docker**  
  Utilizado para containerizar a aplicação e o banco de dados. Veja o arquivo `comandos-docker.txt` para subir os containers.

- **JavaMailSender**  
  Biblioteca utilizada para envio de emails. ⚠️ É necessário configurar uma conta de email e senha para o envio funcionar.

- **Threads**  
  Utilizadas para executar tarefas assíncronas e melhorar a performance da aplicação.

- **RestTemplate**  
  Cliente HTTP do Spring para realizar chamadas REST a APIs externas.

- **MapStruct**  
  Framework para mapeamento automático entre DTOs e entidades.
