Title: Validar o CRUD de G�nero
Narrative:
As um funcionario da locadora
I want gerir os g�neros de filmes cadastrados
So eu mantenho o sistema coeso.
     

Scenario: Cadastrar um g�nero
Given o g�nero Romance com a descri��o: Filmes que contenham hist�rias de amor (ainda n�o cadastrado)
When o cadastro no Sistema
Then o Sistema exibe as informa��es do g�nero

Scenario: Alterar a descri��o de um g�nero
Given um gen�ro cadastrado, Romance
When atualizo a descri��o para Nova descri��o do G�nero Romante
Then o Sistema exibe as informa��es do g�nero

Scenario: Remover o g�nero Rom�nce
Given um gen�ro cadastrado, Romance 
When o mesmo � removido
Then o Sistema exibe todos os g�neros cadastrados