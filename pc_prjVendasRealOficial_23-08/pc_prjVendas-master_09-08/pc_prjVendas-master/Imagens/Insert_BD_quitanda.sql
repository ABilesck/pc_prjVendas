-- Trocar "banco_java" pelo nome do seu banco (Ex.: fp050000000)
use quitanda;
--set dateformat ymd;
INSERT INTO cliente
           (nome,endereco,numero,telefone)
     VALUES
           ('Zelao Silva', 'Rua do ze','666','15 33445666');

INSERT INTO cliente
           (nome,endereco,numero,telefone)
     VALUES
           ('Tiao Bastiao', 'Av. Tiao', '123','15 43336677');

INSERT INTO Produto
			(descricao, precounit)
	VALUES 
		('mouse', 12.3);

INSERT INTO Produto
			(descricao, precounit)
	VALUES 
		('teclado', 15.2);		

INSERT INTO Produto
			(descricao, precounit)
	VALUES 
		('pen drive', 25);	

INSERT INTO Produto
			(descricao, precounit)
	VALUES 
		('mouse pad', 10.22);
		
INSERT INTO venda
		(datavenda, cod_cli)
	VALUES
		('1999-11-11', 1);

INSERT INTO venda
		( datavenda, cod_cli)
	VALUES
		('2009-02-18', 2);
		
INSERT INTO itemvenda
		(numvenda, codpro, quantidade, precounit)
	VALUES
		(1,	2,	1,	15.2);

INSERT INTO itemvenda
		(numvenda, codpro, quantidade, precounit)
	VALUES
		(1,	1,	4,	12.3);

INSERT INTO itemvenda
		(numvenda, codpro, quantidade, precounit)
	VALUES	
		(1,	4,	4,	10.22);
	
INSERT INTO itemvenda
		(numvenda, codpro, quantidade, precounit)
	VALUES
		(2,	4,	1,	10.22);
	
INSERT INTO itemvenda
		(numvenda, codpro, quantidade, precounit)
	VALUES
		(2,	2,	2,	25);