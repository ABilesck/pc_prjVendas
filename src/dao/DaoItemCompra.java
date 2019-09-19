/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import model.ItemCompra;

/**
 *
 * @author aluno
 */
public class DaoItemCompra extends ItemCompra{

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;
    
    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        
        String sql = "INSERT INTO pc_itemcompra "
                + " (numCompra, codPro, quantidade, precounit)"
                + "VALUES "
                + "(?,?,?,?)";
        
        this.conexao = BancoSQL.getConnection();
        
        comandoSQL = conexao.prepareStatement(sql);
        
        comandoSQL.setInt(1, getNumCompra());
        comandoSQL.setInt(2, getCodPro());
        comandoSQL.setInt(3, getQuantidade());
        comandoSQL.setDouble(4, getPrecoUnit());
        
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        
        String sql = "UPDATE pc_itemcompra SET "
                + "codpro = ?, "
                + "quantidade = ?, "
                + "precounit = ?, "
                + "WHERE numCompra = ?";
        
        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodPro());
        comandoSQL.setInt(2, this.getQuantidade());
        comandoSQL.setDouble(3, this.getPrecoUnit());
        comandoSQL.setInt(4, this.getNumCompra());
        
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        
        
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        
        String sql = "DELETE FROM pc_itemcompra "
                + "WHERE NUMCOMPRA = ?";
        
        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getNumCompra());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        
        return apagou;
        
    }
    
    public ArrayList<DaoItemCompra> Pesquisar(DaoItemCompra item) 
            throws SQLException, ClassNotFoundException{
        
        DaoItemCompra itemRetorno = null;
        
       String sql = "";
        
       if(item.getCodPro() > 0){
           sql =  "SELECT numCompra, pc_itemcompra.codpro, pc_produto.descricao, "
                   + "pc_itemcompra.quantidade, pc_itemcompra.precounit, "
                   + "(pc_itemcompra.quantidade * pc_itemcompra.precounit) AS SubTotal "
                   + "FROM pc_itemcompra INNER JOIN pc_produto ON "
                   + "pc_itemcompra.codpro = pc_produto.codpro "
                   + "WHERE pc_itemcompra.numCompra = ? and pc_itemcompra.codpro = ?";
       } else{
           sql = "SELECT numCompra, pc_itemcompra.codpro, pc_produto.descricao, "
                   + "pc_itemcompra.quantidade, pc_itemcompra.precounit, "
                   + "(pc_itemcompra.quantidade * pc_itemcompra.precounit) AS SubTotal "
                   + "FROM pc_itemcompra INNER JOIN pc_produto ON pc_itemcompra.codpro = pc_Produto.codpro "
                   + "WHERE numCompra = ?";
       }
       
       ArrayList<DaoItemCompra> listaItens = new ArrayList<>();
       
       this.conexao = BancoSQL.getConnection();
       comandoSQL = conexao.prepareStatement(sql);
       
       if(item.getCodPro() > 0){
           comandoSQL.setInt(1, item.getNumCompra());
           comandoSQL.setInt(2, item.getCodPro());
       } else{
           comandoSQL.setInt(1, item.getNumCompra());
       }
       
       ResultSet rs = comandoSQL.executeQuery();
       
       while (rs.next()){
           itemRetorno = new DaoItemCompra();
           itemRetorno.setNumCompra(rs.getInt("numCompra"));
           itemRetorno.setCodPro(rs.getInt("codpro"));
           itemRetorno.setDescricao(rs.getString("descricao"));
           itemRetorno.setQuantidade(rs.getInt("quantidade"));
           itemRetorno.setPrecoUnit(rs.getDouble("precounit"));
           itemRetorno.setSubtotal(rs.getInt("subtotal"));
           
           listaItens.add(itemRetorno);
       }
       
       rs.close();
       
       comandoSQL.close();
       this.conexao.close();
       
       return listaItens;
    }
    
}
