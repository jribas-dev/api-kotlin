<h1 style="text-align: center">API-KOTLIN (credit-system)</h1>

<p style="text-align: center">API REST para um Sistema de Análise de Solicitação de Crédito</p>

<div style="text-align: center">

![Java](https://img.shields.io/badge/Java-v17-blue.svg "Java")
![Kotlin](https://img.shields.io/badge/Kotlin-v1.7.22-purple.svg "Kotlin")
![SpringBoot](https://img.shields.io/badge/Spring%20Boot-v3.1.0-brightgreen.svg "Spring")
![Gradle](https://img.shields.io/badge/Gradle-v7.6.1-lightgreen.svg "Gradle")
![H2Database](https://img.shields.io/badge/H2-v2.1.214-darkblue.svg "H2 Database")
![Flyway](https://img.shields.io/badge/Flyway-v9.19.1-red.svg "Flyway")

</div>

## Descrição do Projeto

- <h3>Cliente (Customer):</h3>
  - <strong>Cadastrar:</strong>
    - <strong>Request: </strong><em>firstName, lastName, cpf, income, email, password, zipCode e street</em>
    - <strong>Response: </strong><em>String</em>
  - <strong>Editar cadastro:</strong>
    - <strong>Request: </strong><em>id, firstName, lastName, income, zipCode, street</em>
    - <strong>Response: </strong><em>firstName, lastName, income, cpf, email, income, zipCode, street</em>
  - <strong>Visualizar perfil:</strong>
    - <strong>Request: </strong> <em>id</em>
    - <strong>Response: </strong><em>firstName, lastName, income, cpf, email, income, zipCode, street</em>
  - <strong>Deletar cadastro:</strong>
    - <strong>Request: </strong><em>id</em>
    - <strong>Response: </strong><em>sem retorno</em>

- <h3>Solicitação de Empréstimo (Credit):</h3>
  - <strong>Cadastrar:</strong>
    - <strong>Request: </strong><em>creditValue, dayFirstOfInstallment, numberOfInstallments e customerId</em>
    - <strong>Response: </strong><em>String</em>
  - <strong>Listar todas as solicitações de emprestimo de um cliente:</strong>
    - <strong>Request: </strong><em>customerId</em>
    - <strong>Response: </strong><em>creditCode, creditValue, numberOfInstallment</em>
  - <strong>Visualizar um emprestimo:</strong>
    - <strong>Request: </strong><em>customerId e creditCode</em>
    - <strong>Response: </strong><em>creditCode, creditValue, numberOfInstallment, status, emailCustomer e incomeCustomer</em>

<figure>
<p style="text-align: center">
  <img src="https://i.imgur.com/7phya16.png" height="450" width="650" alt="API para Sistema de Avaliação de Créditos"/><br>
  Diagrama UML Simplificado de uma API para Sistema de Avaliação de Crédito
</p>
</figure>
<figure>
<p style="text-align: center">
  <img src="https://i.imgur.com/1Ea5PH3.png" height="350" width="600" alt="Arquitetura em 3 camadas Projeto Spring Boot"/><br>
  Arquitetura em 3 camadas Projeto Spring Boot
</p>
</figure>

<h3>Instrução de Uso</h3>
<p>No Terminal/Console:</p>
<ol>
	<li>Faça um clone do projeto na sua máquina: <code>git clone https://github.com/jribas-dev/api-kotlin.git</code></li>
	<li>Entre na pasta raiz do projeto: <code>cd </code></li> 
	<li>Execute o comando: <code>./gradlew bootrun</code></li>
</ol>

<h6>** Visando facilitar a demostração da aplicação, recomendo instalar apenas o IntelliJ IDEA e executar o projeto através da IDE **</h6>

<a href="https://drive.google.com/file/d/1wxwioDHS1sKFPq4G7b24tVZb-XMnoj-l/view?usp=share_link">🚀 Collection Sacola API - Postman</a>

---

### Contribuindo

<img style="border-radius: 50%; margin-left: 35px;" src="https://avatars.githubusercontent.com/u/105611273?v=4" width="100px;" alt=""/></img>

[![Linkedin Badge](https://img.shields.io/badge/-Joao%20Ribas-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/jribas-dev/)](https://www.linkedin.com/in/jribas-dev/)
[![Instagram Badge](https://img.shields.io/badge/-Instagram-c14438?style=flat-square&logo=Instagram&logoColor=white&link=https://www.instagram.com/joao.ribas.real/)](https://www.instagram.com/joao.ribas.real/)

⭐ Star o projeto

🐛 Encontrar e relatar issues

---

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)
