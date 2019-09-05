-- Exemplo migração de dados de uma tabela para outra de BDs diferentes
INSERT INTO LUIZ.[dbo].tblProduto ( [codpro],[descricao],[quantidade],[precounit])
SELECT        [codpro],[descricao],[quantidade],[precounit]
FROM           bd.dbo.pc_Produto;