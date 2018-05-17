create database conductor;

use conductor;

create table if not exists pessoas(
idPessoa int not null unique primary key auto_increment,
nome varchar(50) not null,
cpf varchar(11) not null,
dataNascimento date
)default charset=utf8;

create table if not exists contas(
idConta int not null unique primary key auto_increment,
idPessoa int not null unique,
saldo decimal(11,2),
limiteSaqueDiario decimal(11,2),
flagAtivo boolean,
tipoConta int,
dataCriacao date,
constraint fk_idPessoa foreign key(idPessoa) references pessoas(idPessoa)
)default charset=utf8;

create table if not exists transacoes(
idTransacao int not null unique primary key auto_increment,
idConta int not null,
valor decimal(11,2) not null,
dataTransacao date,
constraint fk_idConta foreign key(idConta) references contas(idConta)
)default charset=utf8;

insert into pessoas(nome, cpf, dataNascimento) 
values	('José Italo Gouveia Soares', '11897835418', '1998-04-01'),
		('Wesley Felipe Gouveia Soares', '13703633421', '2000-03-23'), 
        ('João', '21435465454', '2000-03-12');

select * from pessoas;