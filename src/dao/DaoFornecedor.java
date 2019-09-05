/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Fornecedor;

/**
 *
 * @author aluno
 */
public class DaoFornecedor extends Fornecedor {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {

        String sql = "insert into pc_fornecedor(razao, fantasia, endereco, "
                + "cidade, bairro, uf, cep, telefone, fax, cnpj, ie, datacad)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        this.conexao = BancoSQL.getConnection();

        comandoSQL = conexao.prepareStatement(sql);

        comandoSQL.setString(1, this.getRazao());
        comandoSQL.setString(2, this.getFantasia());
        comandoSQL.setString(3, this.getEndereco());
        comandoSQL.setString(4, this.getCidade());
        comandoSQL.setString(5, this.getBairro());
        comandoSQL.setString(6, this.getUf());
        comandoSQL.setString(7, this.getCep());
        comandoSQL.setString(8, this.getTelefone());
        comandoSQL.setString(9, this.getFax());
        comandoSQL.setString(10, this.getCnpj());
        comandoSQL.setString(11, this.getIe());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDatacad().getTime());
        comandoSQL.setString(12, sdf.format(data));

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();

    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {

        String sql = "set dateformat dmy "
                + "UPDATE pc_fornecedor SET "
                + "razao=?, "
                + "fantasia=?, "
                + "endereco=?, "
                + "cidade=?, "
                + "bairro=?, "
                + "uf=?, "
                + "cep=?, "
                + "telefone=?, "
                + "fax=?, "
                + "cnpj=?, "
                + "ie=?, "
                + "datacad=?"
                + " WHERE codFor = ?";

        this.conexao = BancoSQL.getConnection();

        comandoSQL = conexao.prepareStatement(sql);

        comandoSQL.setString(1, this.getRazao());
        comandoSQL.setString(2, this.getFantasia());
        comandoSQL.setString(3, this.getEndereco());
        comandoSQL.setString(4, this.getCidade());
        comandoSQL.setString(5, this.getBairro());
        comandoSQL.setString(6, this.getUf());
        comandoSQL.setString(7, this.getCep());
        comandoSQL.setString(8, this.getTelefone());
        comandoSQL.setString(9, this.getFax());
        comandoSQL.setString(10, this.getCnpj());
        comandoSQL.setString(11, this.getIe());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDatacad().getTime());
        comandoSQL.setString(12, sdf.format(data));

        comandoSQL.setInt(13, this.getCodFor());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();

    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM pc_fornecedor "
                + " WHERE codFor = ?";

        try {

            this.conexao = BancoSQL.getConnection();
            comandoSQL = conexao.prepareStatement(sql);

            comandoSQL.setInt(1, this.getCodFor());

            boolean apagou = comandoSQL.execute();

            comandoSQL.close();
            this.conexao.close();

            return apagou;

        } catch (SQLException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
            throw ex;
        }

    }

    public ArrayList<DaoFornecedor> pesquisar(DaoFornecedor fornecedor)
            throws SQLException, ClassNotFoundException {

        DaoFornecedor fornecedorRetorno = null;

        String sql = "SELECT * FROM pc_fornecedor WHERE RAZAO LIKE ?";

        ArrayList<DaoFornecedor> listaFor = new ArrayList<DaoFornecedor>();

        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        comandoSQL.setString(1, "%" + fornecedor.getRazao() + "%");

        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {

            fornecedorRetorno = new DaoFornecedor();
            fornecedorRetorno.setCodFor(rs.getInt("CODFOR"));
            fornecedorRetorno.setRazao(rs.getString("RAZAO"));
            fornecedorRetorno.setFantasia(rs.getString("FANTASIA"));
            fornecedorRetorno.setEndereco(rs.getString("ENDERECO"));
            fornecedorRetorno.setCidade(rs.getString("CIDADE"));
            fornecedorRetorno.setBairro(rs.getString("BAIRRO"));
            fornecedorRetorno.setUf(rs.getString("UF"));
            fornecedorRetorno.setCep(rs.getString("CEP"));
            fornecedorRetorno.setTelefone(rs.getString("TELEFONE"));
            fornecedorRetorno.setFax(rs.getString("FAX"));
            fornecedorRetorno.setCnpj(rs.getString("CNPJ"));
            fornecedorRetorno.setIe(rs.getString("IE"));
            fornecedorRetorno.setDatacad(rs.getDate("DATACAD"));

            listaFor.add(fornecedorRetorno);

        }

        rs.close();

        comandoSQL.close();
        this.conexao.close();

        return listaFor;
    }
    
    public ArrayList<DaoFornecedor> Preencher(DaoFornecedor fornecedor)
            throws SQLException, ClassNotFoundException {

        DaoFornecedor fornecedorRetorno = null;

        String sql = "SELECT * FROM pc_fornecedor";

        ArrayList<DaoFornecedor> listaFor = new ArrayList<DaoFornecedor>();

        this.conexao = BancoSQL.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {

            fornecedorRetorno = new DaoFornecedor();
            fornecedorRetorno.setCodFor(rs.getInt("CODFOR"));
            fornecedorRetorno.setRazao(rs.getString("RAZAO"));
            fornecedorRetorno.setFantasia(rs.getString("FANTASIA"));
            fornecedorRetorno.setEndereco(rs.getString("ENDERECO"));
            fornecedorRetorno.setCidade(rs.getString("CIDADE"));
            fornecedorRetorno.setBairro(rs.getString("BAIRRO"));
            fornecedorRetorno.setUf(rs.getString("UF"));
            fornecedorRetorno.setCep(rs.getString("CEP"));
            fornecedorRetorno.setTelefone(rs.getString("TELEFONE"));
            fornecedorRetorno.setFax(rs.getString("FAX"));
            fornecedorRetorno.setCnpj(rs.getString("CNPJ"));
            fornecedorRetorno.setIe(rs.getString("IE"));
            fornecedorRetorno.setDatacad(rs.getDate("DATACAD"));

            listaFor.add(fornecedorRetorno);

        }

        rs.close();

        comandoSQL.close();
        this.conexao.close();

        return listaFor;
    }

}
