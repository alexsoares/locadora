Title: Gest�o do estoque.
Narrative:
As um funcionario da locadora
I want manter o estoque da locadora atualizado
So consigo realizar o planejamento da Locadora
     


Scenario: Cadastrar um cliente 

Given um novo cliente com nome: Valdir, cpf: 12345670012, nascido no dia 10/03/1971
When cadastramos o cliente no Sistema
Then o Sistema exibe as informa��es do cliente


Scenario: Cadastrar uma nova m�dia

Given uma nova m�dia, VHS com a descricao: Fitas VHS
When a cadastramos no Sistema
Then o Sistema exibe as informa��es da m�dia


Scenario: Cadastrar um g�nero

Given Genero Anima��o com a descricao: Descricao do Genero Anima��o
When o inseremos no Sistema
Then o Sistema exibe as informa��es do G�nero adicionado.


Scenario: Cadastrar um novo filme

Given um novo filme com nome: A Era do Gelo, custando 4.2, lan�ando em 15/12/2011 com a faixa et�ria de 6 anos, com a sinopse: (Sinopse do filme A Era do Gelo) 
pertencente ao g�nero Anima��o
When o cadastramos no Sistema
Then o Sistema exibe as informa��es do Filme


Scenario: Cadastrar um novo Item

Given um item que possui o c�digo de barras 12153035E10, associado ao filme A Era do Gelo, na m�dia VHS, realizado na data 02/10/2011
When o cadastramos no sistema
Then o Sistema retorna os dados do item 12153035E10


Scenario: Alocar um filme

Given um item existente com o c�digo 12153035E10, um cliente com o cpf 12345670012 na data 15/02/2012
When registramos a locacao
Then o Sistema exibe da loca��o

