Title: Testes CRUD M�dias
Narrative:
As um funcionario da locadora
I want gerir as m�dias dispon�veis na locadora
So ter melhor controle do conte�do em estoque
     

Scenario: Cadastrar uma nova m�dia

Given uma nova m�dia, DVD com a descricao: Disco que suporta 4.7 GB de Dados
When a cadastramos no Sistema
Then o Sistema exibe as informa��es da m�dia