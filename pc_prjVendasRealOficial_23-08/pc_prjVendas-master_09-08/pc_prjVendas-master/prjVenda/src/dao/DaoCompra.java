/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Compra;

/**
 *
 * @author aluno
 */
public class DaoCompra extends Compra {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;

    public void incluir() throws SQLException, ClassNotFoundException {

        String sql = "set dateformat dmy INSERT INTO pc_compra "
                + "(codFor, dataCompra, dataEntrega, obs)"
                + "VALUES"
                + "(?,?,?,?)";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        comandoSQL.setInt(1, this.getCodFor());
        comandoSQL.setString(2, sdf.format(this.getDataCompra()));
        comandoSQL.setString(3, sdf.format(this.getDataEntrega()));
        comandoSQL.setString(4, this.getObs());

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();

    }

    public void alterar() throws SQLException, ClassNotFoundException {

        String sql = "set dateformat dmy "
                + "UPDATE pc_compra SET "
                + "codFor = ?,"
                + "dataCompra = ?, "
                + "dataEntrega = ?, "
                + "obs = ? "
                + " WHERE numCompra = ?";

        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodFor());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        comandoSQL.setString(2, sdf.format(this.getDataCompra()));
        comandoSQL.setString(3, sdf.format(this.getDataEntrega()));
        comandoSQL.setString(4, this.getObs());

        comandoSQL.setInt(5, this.getNumCompra());

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();

    }

    public boolean excluir() throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM pc_compra "
                + "WHERE NUMCOMPRA = ?";

        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getNumCompra());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        return apagou;

    }
    
    public ArrayList<DaoCompra> Pesquisar (DaoCompra compra) 
            throws SQLException, ClassNotFoundException{
        
        DaoCompra compraRetorno = null;
        String sql = "";
        
        if(compra.getNumCompra() > 0){
            
            sql = "set dateformat dmy SELECT numCompra, pc_compra.codFor, nome, dataCompra,"
                    + " dataEntrega, obs "
                    + "FROM pc_compra INNER JOIN pc_fornecedor ON pc_compra.codFor = pc_fornecedor.codFor"
                    + " WHERE numCompra = ?";
            
        }else{
            
            sql = "set dateformat dmy SELECT numCompra, pc_compra.codFor, nome, dataCompra,"
                    + " dataEntrega, obs "
                    + "FROM pc_compra INNER JOIN pc_fornecedor ON pc_compra.codFor = pc_fornecedor.codFor";
        }
        
        ArrayList<DaoCompra> listaCompras = new ArrayList<DaoCompra>();
        
        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        
        if(compra.getNumCompra() > 0){
            comandoSQL.setInt(1, compra.getNumCompra());
        }
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while(rs.next()){
            compraRetorno = new DaoCompra();
            compraRetorno.setNumCompra(rs.getInt("numcompra"));
            compraRetorno.setCodFor(rs.getInt("codfor"));
            compraRetorno.setNome(rs.getString("nome"));
            compraRetorno.setDataCompra(rs.getDate("datacompra"));
            compraRetorno.setDataEntrega(rs.getDate("dataentrega"));
            compraRetorno.setObs(rs.getString("obs"));
            
            listaCompras.add(compraRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaCompras;
    }
}
