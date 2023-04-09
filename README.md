
# CRUD de Usuário utilizando Spring, JPA e H2 👥

Essa é uma API utilizando Spring, JPA e H2. No geral o projeto se constitui em ser uma API para criação e manipulação de usuários em um banco de dados, para o projeto foi escolhido o H2 por ser algo mais 'local' e ao mesmo tempo mais fácil de ser manipulado, por se tratar de um banco em memória.

## Sobre o projeto 📚

O projeto foi gerado utilizando o site Spring Initializr para a adição mais rápida das dependências necessárias, sendo elas a do Banco H2, Spring Web e Model Mapper

A dependência Model Mapper foi escolhida para ajudar quando se trata de código boilerplate, evitando a repetição dos mesmos tipos de código e facilitando na manipulação de DTOs.

## Endpoints 🔌

Como todo CRUD, os endpoints da aplicação são: Create, Update, Delete, FindAll e FindById. Além disso, tendo certos tratamentos básicos de exceções como FindByEmail para evitar a criação de mais de um usuário como o mesmo email e um tratamento de ObjectNotFound para caso um objeto não exista na base de dados.

## Postman 👨‍🚀

Para a chamada dos endpoints e teste de funcionalidade da API, foi utilizado o Postman, plataforma especializada para teste e manutenção de APIs. 

## Próximos passos

Próximos passos no projeto:

* Criação de testes utilizando Junit e Mockito; ✔️
  - Implementação de testes unitários para classe de ServiceImpl;

* Futuras manutenções para melhoramento de desempenho e otimização do código. ❌


## OBRIGADO PELA ATENÇÃO

![](https://thumbs.gfycat.com/NextDampBittern-max-1mb.gif)

