Title: Testes CRUD Mídias
Narrative:
As um funcionario da locadora
I want gerir as mídias disponíveis na locadora
So ter melhor controle do conteúdo em estoque
     

Scenario: Cadastrar uma nova mídia

Given uma nova mídia, DVD com a descricao: Disco que suporta 4.7 GB de Dados
When a cadastramos no Sistema
Then o Sistema exibe as informações da mídia