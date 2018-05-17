/*testes de inserção de valores nas tabelas contas e transacoes*/
insert into contas(idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao) 
values	(1, 1028.55, 500, true, 1, '2017-05-01'), 
		(2, 954.00, 300, true, 2, '2018-05-01');

select * from contas;

insert into transacoes(idConta, valor, dataTransacao) 
values 	(1, 500, '2018-05-10'), 
		(2, 200, '2018-05-10');

select * from transacoes;





/**teste de join entre as tabelas pessoas e contas*/
select p.idPessoa, p.nome, p.cpf, p.dataNascimento, 
	c.idConta, c.idPessoa, c.saldo, c.limiteSaqueDiario, 
    c.flagAtivo, c.tipoConta, c.dataCriacao from pessoas 
    as p inner join contas as c 
    on p.idPessoa = c.idPessoa;

/*teste de join com as 3 tabelas*/
select p.idPessoa, p.nome, p.cpf, p.dataNascimento, 
	c.idConta, c.idPessoa, c.saldo, c.limiteSaqueDiario, c.flagAtivo, c.tipoConta, c.dataCriacao, 
    t.idTransacao, t.idConta, t.valor, t.dataTransacao 
    from pessoas as p 
    inner join contas as c 
    inner join transacoes as t 
    on p.idPessoa = c.idPessoa 
    and c.idConta = t.idConta;

/*testes de select com datas*/
select * from transacoes where idConta = 1 and dataTransacao = current_date;
select * from transacoes where idConta = 1 and dataTransacao between '2018-05-09' and '2018-05-12';
select sum(valor) from transacoes where idConta=1 and dataTransacao= current_date;