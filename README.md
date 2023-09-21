# Produtos-Backend-Apostila
Código referente da apostila do projeto de extensão

### Objetivo
O objetivo desse projeto é criar uma lista de produtos usando Spring Boot e o banco de dados postgreSQL. O usuário deverá:
* Consultar todos os produtos (READ)
* Consultar o produto pelo sua identificação (READ)
* Adicionar um novo produto (CREATE)
* Atualizar um determinado produto (UPDATE)
* Apagar um determinado produto (DELETE)

### Instalação
1. ```git clone https://github.com/deyvidsalvatore/Produtos-Backend-Apostila.git```
2. ```cd Produtos-Backend-Apostila```
3. Crie um banco de dados no postgres chamado ```produtosdb``` (Usuário e senha ambos postgres, caso haja alteração por favor alterar o ```application.properties```) 
3. ```mnvw.cmd spring-boot:run```

### Endpoints principais
* GET ```/api/v1/produtos``` (Todos os produtos)
* GET ```/api/v1/produtos/{id}``` (Produto pela identificação)
* POST ```/api/v1/produtos``` (Criar um novo produto)
* PUT ```/api/v1/produtos/{id}``` (Atualizar um produto)
* DELETE ```/api/v1/produtos/{id}``` (Apagar um produto) 
