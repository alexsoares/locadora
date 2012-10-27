Title:Inserir um novo Cliente no Sistema
Narrative:
As um funcionario da locadora
I want cadastrar um novo cliente
So que o mesmo possa efetuar locações
     

Scenario: Cadastrar um cliente 

Given um novo cliente com nome: Bruno, cpf: 12345678912, nascido no dia 22/09/1987
When cadastramos o cliente no Sistema
Then o Sistema exibe as informações do cliente


Scenario: Consultar Cliente Cadastrado

Given um cliente já cadastrado 
When o consultamos pelo CPF
Then o Sistema exibe as informações do cliente


Scenario: Alter email cadastrado

Given um cliente já cadastrado 
When alteramos o email para email_alterado@email.com
Then o Sistema exibe o e-mail alterado


Scenario: Remover um cliente cadastrado

Given um cliente já cadastrado 
When o removemos
Then o Sistema exibe um diálogo informando que o cliente não está mais cadastrado

Scenario: Inserir um novo cliente na base

Given um novo cliente com nome: Andre, cpf: 02345678912, nascido no dia 30/10/1983
When cadastramos o cliente no Sistema
Then o Sistema exibe as informações do cliente