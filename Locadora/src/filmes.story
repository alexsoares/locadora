Title: Validar o CRUD de Filmes
Narrative:
As um funcionario da locadora
I want gerenciar o estoque de filmes
So que possa manter o controle da locadora
     

Scenario: Cadastrar um g�nero

Given Genero Drama com a descricao: Descricao do Genero Drama
When o inseremos no Sistema
Then o Sistema exibe as informa��es do G�nero adicionado.


Scenario: Cadastrar um novo filme

Given um novo filme com nome: O Filme da minha vida, custando 1.0, lan�ando em 01/10/1997 com a faixa et�ria de 13 anos, com a sinopse: (Sinopse do filme da minha vida) 
pertencente ao g�nero Drama
When o cadastramos no Sistema
Then o Sistema exibe as informa��es do Filme


Scenario: Atualizar um filme

Given o Filme: O Filme da minha vida
When atualizamos a sinopse para: Nova Sinopse
Then podemos visualizar a nova sinopse nas informa��es do filme

Scenario: Remover um filme

Given o Filme: O Filme da minha vida
When o removemos
Then o mesmo n�o aparecer� na lista de filmes cadastrados