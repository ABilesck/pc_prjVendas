--consulta pelo nome

declare @nome varchar(50) = '%cata%';

set dateformat dmy;
SELECT        codCli, nome, endereco, cidade, bairro, uf, cep, telefone, dataNasc
FROM            pc_Cliente
WHERE        (nome LIKE @nome);

--consulta pela data de nasc

declare @data varchar(4);
set @data = '09'
set dateformat dmy;
SELECT        codCli, nome, endereco, cidade, bairro, uf, cep, telefone, dataNasc
FROM            pc_Cliente
WHERE        (MONTH(dataNasc) = @data)

---------------------------------------------------------------

SELECT        pc_Venda.numVenda, pc_Venda.dataVenda, pc_Venda.dataEntrega, pc_Venda.codCli, pc_Cliente.nome, 
pc_Venda.obs, pc_ItemVenda.codPro, pc_Produto.descricao, pc_ItemVenda.quantidade, pc_ItemVenda.precoUnit, 
                         pc_ItemVenda.quantidade * pc_ItemVenda.precoUnit AS Subtotal
FROM            pc_Cliente INNER JOIN
                         pc_Venda ON pc_Cliente.codCli = pc_Venda.codCli LEFT OUTER JOIN
                         pc_Produto INNER JOIN
                         pc_ItemVenda ON pc_Produto.codPro = pc_ItemVenda.codPro ON pc_Venda.numVenda = pc_ItemVenda.numVenda;

SELECT        numVenda, dataVenda, dataEntrega, codCli, obs
FROM            pc_Venda

SELECT        codPro, descricao, quantidade, precoUnit
FROM            pc_Produto;