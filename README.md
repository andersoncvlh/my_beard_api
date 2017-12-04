# README #

This README would normally document whatever steps are necessary to get your application up and running.


### How do I get set up? ###

*	Como utilizamos Spring boot é recomendado a utilização da ferramenta Spring Tool Suite.
*	Plugin EclEmma Java Code Coverage para análise da cobertura de testes de integração e unitários.
*	Plugin Sonar Lint para manter a qualidade de código.
*	Postman para simulação das requisições Rest.

* Dependencies:
	*	Java 8 
	*	Spring boot  versão 1.5.3.RELEASE
	*	Spring boot web e Jackson para API restful
	*	JPA e Hibernate
	*	Banco de dados postgres como padrão e o H2 apenas para testes de integração
	*	Migração de banco de dados com Flyway
	*	Segurança com spring security, JWT e OAuth2
	*	Spring dev tools para agilidade no desenvolvimento ('redeploy' automático em ambiente de desenvolvimento para economizar tempo)

* Database configuration:
	*	PostgresSQL e PGAdmin para administração do banco de dados, lembrar de criar um banco local com o nome mybeard.

* How to run tests
	*	Existem duas suites de testes, com.mybeardapi.test.unit.SuiteClassesUnitarios (para os testes unitários) e com.mybeardapi.test.integration.SuiteClassesIntegracao (para os testes de integração)
	*	O desenvolvedor será responsável por criar os dois Testes para cada nova funcionalidade e manter os testes quando houver melhorias ou correções e garantir que os testes funcionem
* Deployment instructions (a adicionar)

### Contribution guidelines ###

*	Testes Unitários e de Integração devem ser feitas para todos os serviços.
	*	Cobertura mínima de código dos testes unitários é de no mínimo 90% (isso vale para os pacotes: services, repositories e resources)
*	Revisão de código por conta do @dantas.johnatan
*	Evitar duplicação de código
*	Utilização de branchs:
	*	master - código de produção, pronto para utilização do usuário
	*	develop - branch de onde os desenvolvedores criarão as branchs de desenvolvimento como features e bugfixs
	*	bugfix - correção de bug
	*	feature - novas funcionalidades ou melhorias

### Who do I talk to? ###

*	meios de comunicação da equipe (a adicionar)