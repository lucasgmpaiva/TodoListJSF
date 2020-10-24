# TodoListJSF

## TodoList Implementado com JSF

Este projeto trata-se da implementação de uma TodoList (Lista de Afazeres) por meio de Java Web para a realização do desafio de recrutamento de estagiários da empresa ESIG -  Software e Consultoria em TI.

### Tecnologias Utilizadas
Para a realização do projeto foram utilizadas as seguintes tecnologias:
- Java
- JavaServer Faces
- PrimeFaces
- MySQL
- Hibernate
- JUnit
- Apache TomCat

### Instruções de execução
Para a execução deste projeto é necessário, primeiro possuir os seguintes recursos em sua máquina:
- Java 1.8 (JDK)
- Eclipse IDE (com Maven)
- MySQL
- Apache TomCat 8.5
É necessário também que o banco de dados seja configurado na pasta: "JavaResources/src/main/resources/hibernate.cfg.xml". Neste caso é preciso criar o banco de dados no MySQL Server, mas apenas o banco, pois a aplicação está configurada para realizar a criação automática da tabela a cada inicialização do projeto.
1. Baixe o projeto como .zip
2. Descompacte o arquivo
3. Na IDE Eclipse, siga o seguinte caminho: File -> Import... -> Existing Maven Projects -> Busque a pasta na qual você descompactou o arquivo -> Selecione o projeto: 
4. Adicione o Projeto a seu server Apache TomCat
5. Inicialize o servidor
6. Em um navegador, acesse o endereço: "localhost:8080/ToDoJSF/pages/testJSF.xhtml". Se necessário, substitua a porta "8080" pela porta com a qual o seu TomCat foi configurado.
7. O projeto já estará em execução.
