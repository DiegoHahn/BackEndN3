# API RESTful para Acesso à Educação: Repositórios Educacionais

Este projeto consiste no design e codificação de uma API RESTful para processamento de requisições HTTP, com foco no tema "Acesso à Educação: Repositórios Educacionais". A API permite a criação, consulta, atualização e exclusão de recursos educacionais e categorias, além de gerenciar usuários com diferentes permissões de acesso.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- PostgreSQL

## Funcionalidades

### Gerenciamento de Usuários
- Cadastro de usuários com diferentes papéis (ADMIN, USER).
- Autenticação e autorização.

### Gerenciamento de Recursos Educacionais
- Adicionar, atualizar, consultar e excluir recursos educacionais.
- Cada recurso pertence a uma categoria específica.

### Gerenciamento de Categorias
- Adicionar, atualizar, consultar e excluir categorias.
- Cada categoria pode ter múltiplos recursos associados.

## Executando a Aplicação

### Pré-requisitos

-PostgreSQL

### Passos para executar

1. Clone o repositório:
   git clone https://github.com/DiegoHahn/BackEndN3.git

2. Para rodar localmente é necessário criar uma instancia do banco PostgreSQL com o nome ProjetoN3
e no arquivo application.properties alterar as linhas:
```
spring.datasource.username={INSERIR USUARIO} 
spring.datasource.password={INSERIR SENHA DO USUARIO}
 ```

## Exemplo de requisições

### Cadastro de Usuário
PUT Endereço: http://localhost:8080/users
```
{
  "name": "User Teste",
  "email": "userteste@example.com",
  "password": "senha",
  "role": "USER"
}
```
### Cadastro de Categoria
PUT Endereço: http://localhost:8080/categories
```
{
  "name": "Frontend",
  "description": "Material sobre desenvolvimento frontend"
}
```

### Cadastro de Recurso Educacional
PUT Endereço: http://localhost:8080/resources
```
{
  "title": "Repositório React",
  "description": "Repositório oficial do React",
  "url": "https://github.com/facebook/react.git",
  "type": "Repositório",
  "category": {
    "id": 1
  }
}
```

### Consulta de Recursos Educacionais
GET Endereço: http://localhost:8080/resources

### Edição de Recurso Educacional
PUT Endereço: http://localhost:8080/resources/1
```
{
  "title": "Repositório oficial React",
  "description": "Repositório oficial do React mantido pelo Facebook",
  "url": "https://github.com/facebook/react.git",
  "type": "Repositório",
  "category": {
    "id": 1
  }
}
```
### Exclusão de Recurso Educacional
DELETE Endereço: http://localhost:8080/resources/1