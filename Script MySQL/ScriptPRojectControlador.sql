CREATE DATABASE DBCONTROLADOR;

CREATE USER 'userADMIN'@'%' IDENTIFIED BY '123';

GRANT ALL ON *.* TO 'userADMIN'@'%' WITH GRANT OPTION;


flush privileges;


USE DBCONTROLADOR;

CREATE TABLE VENDAS(
id int auto_increment primary key,
cliente Varchar(150),
produto Varchar(150),
endereco Varchar(200),
telefone Varchar(20),
compra Varchar(15),
venda Varchar(15),
cep Varchar(20),
data_registro Varchar(200),
pagamento Varchar(100),
quantidade int
);

CREATE TABLE ESTOQUE(
id int auto_increment primary key,
nome Varchar(100),
venda Varchar(20),
compra Varchar(20),
data_registro Varchar(20),
data_vencimento Varchar(20),
descricao Varchar(200),
prioridade Varchar(40),
marca Varchar(100),
quantidade int,
imagem longblob
);

CREATE TABLE lixeira(
id int auto_increment primary key,
nome Varchar(100),
venda Varchar(20),
compra Varchar(20),
data_registro Varchar(20),
data_vencimento Varchar(20),
descricao Varchar(200),
prioridade Varchar(40),
marca Varchar(100),
quantidade int,
imagem longblob
);