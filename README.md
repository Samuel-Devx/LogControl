# LogControl - Sistema de Controle desenvolvido em Spring Boot
![Java](https://img.shields.io/badge/Java-17+-red?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build-orange?style=for-the-badge&logo=apache-maven)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)


Meu projeto usando a FrameWork do Java, Spring Boot, utilizando para fazer o Backend do meu sistema de controle de estoque, chamado log control, Já o front utilizo html e css junto com o TomCat.

Funcionalidades

-  Cadastro de Produtos
-  Consulta de Produtos 
-  Pesquisa de produtos
-  Integração com banco de dados MySQL
-  Uso de variáveis de ambiente (segurança das credenciais)

---

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
    - Thymeleaf 
- **MySQL**
- **Maven**
- **Lambok**
- **TomCat**
- **IntelliJ IDEA**

---



### Como rodar o projeto ?

```
mvn spring-boot:run
```
###  Tabela MySql
```
CREATE TABLE produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  preco int not null, 
  quantidade int not null, 
  sku VARCHAR(100) unique
);
```

### Contribuição 🤝

Fique à vontade para abrir issues ou sugerir melhorias.
Este projeto é totalmente aberto a aprendizado e evolução!
### Autor

 __Samuel Devx__ 👨‍💻

Projeto criado para estudos em Spring Boot + Java + MySQL. Me siga para mais projetos.