# TodoListJSF

## TodoList Implementado com JSF

Este projeto trata-se da implementação de uma TodoList (Lista de Tarefas) por meio de Java Web para a realização do desafio de recrutamento de estagiários da empresa ESIG -  Software e Consultoria em TI.

#### Autor: Lucas Gabriel Matias Paiva

### Pontos do Desafio realizados neste projeto:
- A, B, C (Apenas Hibernate), G e H.

### Tecnologias Utilizadas
Para a realização do projeto foram utilizadas as seguintes tecnologias:
- Java
- JavaServer Faces
- PrimeFaces
- MySQL
- Hibernate
- JUnit
- Apache TomCat

### Instruções Para A Execução
Para a execução deste projeto é necessário, primeiro possuir os seguintes recursos em sua máquina:
- Java 1.8 (JDK)
- Eclipse IDE (com Maven)
- MySQL
- Apache TomCat 8.5

#### Observação Importante
É necessário também que o banco de dados seja configurado na pasta: "src/main/resources/hibernate.cfg.xml". 
Neste caso é preciso criar o banco de dados no MySQL Server, mas apenas o banco, pois a aplicação está configurada para realizar a criação automática da tabela a cada inicialização do servidor. Você pode fazer as alterações descritas a seguir após o passo 4 das instruções de execução.
As mudanças no arquivo de configuração devem ser as seguintes:
1. Alterar a propriedade "hibernate.connection.url", para a url do banco que foi criado em seu MySQL Server.
2. Alterar as propriedades: "hibernate.connection.username" e "hibernate.connection.password" para o usuário e senha de seu servidor MySQL.

#### Execução:
1. Baixe o projeto como .zip
2. Descompacte o arquivo
3. Na IDE Eclipse, siga o seguinte caminho: File -> Import... -> Existing Maven Projects -> Busque a pasta na qual você descompactou o arquivo -> Selecione o projeto e pressione "Finish".
4. Adicione o Projeto a seu server Apache TomCat
5. Inicialize o servidor
6. Em um navegador, acesse o endereço: "localhost:8080/ToDoJSF/pages/testJSF.xhtml". Se necessário, substitua a porta "8080" pela porta com a qual o seu TomCat foi configurado.
7. O projeto já estará em execução.

### Versão Spring Boot:
Este projeto possui uma versão utilizando Spring Boot disponível no repositório a seguir: https://github.com/lucasgmpaiva/TodoListSpring
