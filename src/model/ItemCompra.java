/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public abstract class ItemCompra implements IMetodosPadrao{
    
    private int numCompra;
    private int codPro;
    private String descricao;
    private int quantidade;
    private double precoUnit;
    private double subtotal;

    public ItemCompra() {
        this(0,0,"",0,0,0);
    }

    public ItemCompra(int numCompra, int codPro, String descricao, int quantidade,
            double precoUnit, double subtotal) {
        this.numCompra = numCompra;
        this.codPro = codPro;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.subtotal = subtotal;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /*
    @Override
    public String toString() {
        return "\nItemVenda:" 
                + "\nNº da Venda: " + getNumCompra()
                + "\nCódigo do Produto: " + getCodPro()
                + "\nDescrição: " + getDescricao()
                + "\nQuantidade: " + getQuantidade()
                + "\nPreço Unitário: " + getPrecoUnit()
                + "\nSubtotal: " + getSubtotal();
    }*/
}