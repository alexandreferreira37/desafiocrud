# Desafio Crud.

## 1) Tecnologias Utilizadas:

Para desenvolvimento do crud foi o utilizado o Spring Boot Framework com código escrito em java.
Para banco de dados está sendo considerado o mysql em instancia local.
A configuração do servidor pode ser alterada no arquivo application.properties do projeto.

## 2) ide do projeto 
Como ide do projeto foi utilizado o sts (Spring Tool Suite)

## 3) instalação no servidor.

Se for utilizar o sql crie o schema no servidor antes da primeira execução.
e altere os parâmetros no arquivo application.properties do projeto

O Spring boot permite gerar um Fat jar contendo um servidor tomcat que roda a aplicação.
este jar pode ser gerado através da linha de comando conforme abaixo:

$ mvn package
$ java -jar target/desafiocrud-SNAPSHOT.jar

também pode ser gerado um arquivo war para instalação em um servidor externo.