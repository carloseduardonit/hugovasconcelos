-- criação do banco de bados do curso de Java e Mysql com Hugo Vasconcelos
create database dbinfoq;
-- Indica o banco de dados a ser usado
use dbinfoq;
-- Criaçao da tabela  de usuario de login
create table tbusuarios(
	iduser int primary key auto_increment,
	usuario varchar(50) not null,
        endereço varchar(15)
	telefone varchar(15),
        tipo varchar(15) not null,
        situacao varchar(15) not null,
	login varchar(15) not null unique,
	senha varchar(15) not null
);
-- inserindo o primeiro usuario na tabela tbusuarios
insert into tbusuarios(iduser,usuario,telefone,tipo,situacao,login,senha) values(0,"System","000000","system","system");
-- descrevendo as colunas  da tabela tbusuarios
desc tbusuarios;
-- demostrando os dados da tabela tbusuarios da aula 08
select * from tbusuarios;
-- criaçao da tabela  tbclientes da aula 08
create table tbclientes(
	idcliente int primary key auto_increment,
    nomecliente varchar (50) not null,
    enderecocliente varchar(100) not null,
    telefonecliente varchar(15) not null,
    emailcliente varchar(50)
);
create table tbCN(
       idCN int primary key,
       nomeCompleto varchar(100) not null,
       --Filiação
       nomeMae varchar(100) not null,
       nomePai varchar(100),
       --Cartorio
       nomedoCatorio varchar,
       enderecodoCatorio varchar,       
       --Livro
       --Data de Nascimento
       dataNas date not null,
       localNas varchar (50)not null
       
);
create table tbRG(
    idRG int primary key
	
);

create table tdCPF(
    idCPF int primary key
);
-- inserindo dados na tabela tbclientes
insert into tbclientes(nomecliente,enderecocliente,telefonecliente,emailcliente) 
values('cliente1','rua da bala perdida','(21) 2617-5737',null);
-- descrevendo as colunas da tabela tdclientes;
describe tbclientes;
-- demostrando os dados da tbclientes
select * from tbclientes;