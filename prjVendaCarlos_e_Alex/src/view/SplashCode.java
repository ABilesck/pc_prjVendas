/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JWindow;

/**
 *
 * @author aluno
 */
public class SplashCode extends JWindow{
    
    private int duracao;

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public SplashCode(int duracao) {
        this.duracao = duracao;
    }
    
    
    
}
