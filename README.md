# api_attornatus
<h1>Projeto/Desafio Attornatus</h1>

> Status : Desenvolvimento ⚠️

### Neste projeto contém duas entidades, essas entidades cada uma tem o seu Controller, tive como desafio:

+	Criar uma pessoa
+	Editar uma pessoa
+	Consultar uma pessoa
+	Listar pessoas
+	Criar endereço para pessoa
+	Listar endereços da pessoa

## Criar uma Pessoa:

Com o spring boot desenvolvi uma classe com os seguintes atributos, também utilizei o insomnia para fazer todas as requisições:

+ nome
+ dataDeNascimento
+ Endereco endereco(atributo de entidade representa um tipo incorporável)
+ ativo
+ Enderecos enderecos(outra entidade)


## Editar uma pessoa:

Usei o insomnia para fazer uma requisição, que pode editar todos os campos da pessoa, para fazer isso deverá colocar o id(primary key) da pessoa
no json da requisição e o programa irá verificar se aquele id está cadastrado no bando de dados. Se estiver cadastrado o update será feito. 


## Consultar uma pessoa:

Para consultar uma pessoa terá que usar o insomnia para simular uma requisição que deve colocar o id no corpo da requicição, exemplo:
http://localhost:8080/pessoas/id


## Listar pessoas :

De acordo com o campo ativo se caso a pessoa não tenha sido deletada, vai aparecer todas as informações das pessoas cadastradas.

## Criar endereço para pessoa:

Como Enderecos também é uma entidade ela também tem seus atributos:

+ logradouro
+ cep
+ numero
+ cidade
+ pessoa
+ ativo

Em (pessoa) ele deverá informar o id da pessoa, para que com esse endereço quando for criado seja da pessoa que contém aquele id, caso não tenha o id(pessoa)
no banco de dados o programa não vai cadastrar o endereço e gerar um erro.

## Listar endereços da pessoa:

Listar todos os Endereços cadastrados no banco de dados.

## Observação: Usei a conta do meu irmão no insomnia para fazer todas as requisições.

## Tecnologias Usadas:

<table>
  <td>Spring Data JPA</td>
  <td>Validation</td>
  <td>Spring Web</td>
  <td>Flyway Migration</td>
  <td>Spring Boot DevTools</td>
  <td>MySQL Driver</td>
  <td>Lombok</td>
  <td>Insomnia</td>
</table>
