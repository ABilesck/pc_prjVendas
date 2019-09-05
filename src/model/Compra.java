/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Compra {

    private int numCompra;
    private int codFor;
    private String nome;
    private Date dataCompra;
    private Date dataEntrega;
    private String obs;

    public Compra() {
        this(0, 0, "", new Date(), new Date(), "");
    }

    public Compra(int numCompra, int codFor, String nome, Date dataCompra, 
            Date dataEntrega, String obs) {
        this.numCompra = numCompra;
        this.codFor = codFor;
        this.nome = nome;
        this.dataCompra = dataCompra;
        this.dataEntrega = dataEntrega;
        this.obs = obs;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getCodFor() {
        return codFor;
    }

    public void setCodFor(int codFor) {
        this.codFor = codFor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    /*
    @Override
    public String toString() {
        return "\nItemCompra:"
                + "\nNº da Compra: " + getNumCompra()
                + "\nCódigo do Fornecedor: " + getCodFor()
                + "\nNome: " + getNome()
                + "\nData da Compra: " + getDataCompra()
                + "\nData de Entrega: " + getDataEntrega()
                + "\nObservações: " + getObs()
                + "\n";
    }
    */
}