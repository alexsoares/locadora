Title: Validar o CRUD de Gênero
Narrative:
As um funcionario da locadora
I want gerir os gêneros de filmes cadastrados
So eu mantenho o sistema coeso.
     

Scenario: Cadastrar um gênero
Given o gênero Romance com a descrição: Filmes que contenham histórias de amor (ainda não cadastrado)
When o cadastro no Sistema
Then o Sistema exibe as informações do gênero

Scenario: Alterar a descrição de um gênero
Given um genêro cadastrado, Romance
When atualizo a descrição para Nova descrição do Gênero Romante
Then o Sistema exibe as informações do gênero

Scenario: Remover o gênero Românce
Given um genêro cadastrado, Romance 
When o mesmo é removido
Then o Sistema exibe todos os gêneros cadastrados