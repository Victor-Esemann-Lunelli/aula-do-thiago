--subQuery
--1. Retorne Nome, cpf e cnpj dos clientes que são fornecedores
--2. Todas as vendas e o nome do cliente.
--3.  Todos os produtos, inclusive aqueles que não foram fornecidos por nenhum fornecedor.
--4.  Nomes das pessoas que são clientes mas não são fornecedores.
--5. Nomes das pessoas que são tanto clientes quanto fornecedores.
--6. Nomes Produtos que não estão em estoque.
--7 . Produtos que estão em estoque mas nunca foram vendidos.
--8. Vendas que não têm produtos associados.
--9. Nome dos Clientes que nunca fizeram uma compra.
--10. Nome, cpf e cnpj das Pessoas que não são clientes.
--11. Nome e cpnj das Pessoas que não são fornecedores.
--12. Nome das Pessoas que não são clientes nem fornecedores.
--13. Nome dos Fornecedores que não têm produtos associados a eles.

--1

select nome,  (select cpf from cliente 
		where id_cliente = id_pessoa),
			( select cnpj from fornecedor
		where id_fornecedor = id_pessoa) 
			from pessoa
				where id_pessoa in
			(select id_cliente from cliente)
			and 
				id_pessoa in
				(select id_fornecedor from fornecedor )  

--2

select id_venda,( select nome from pessoa
	where venda.id_cliente = pessoa.id_pessoa	)
	from venda
	
--3

select nome from produto
	where id_produto not in 
		( select id_fornecedor from fornecedor )

--4

select nome
	from pessoa
	where id_pessoa in
		( select id_cliente from cliente  )
	and
		id_pessoa not in
			(select id_fornecedor from fornecedor)

--5

select nome
	from pessoa
	where id_pessoa in
		( select id_cliente from cliente  )
	and
		id_pessoa  in
			(select id_fornecedor from fornecedor

--6

select nome from produto
	where id_produto not in
		(select id_item from item_estoque)

--7

select nome from produto
	where id_produto in 
		( select id_item from item_estoque
where id_venda is not null	)

--8

select * from produto