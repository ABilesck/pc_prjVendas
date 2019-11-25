/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author aluno
 */
public class SplashCode extends JWindow {

    private int _duracao;

    public int getDuracao() {
        return _duracao;
    }

    public void setDuracao(int duracao) {
        this._duracao = duracao * 1000;
    }

    public SplashCode(int duracao) {
        setDuracao(duracao);
    }

    public void ShowSplash() {

        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        int width = 600;
        int height = 520;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;

        setBounds(x, y, width, height);

        JLabel label = new JLabel(new ImageIcon("src/view/SplashImage.png"));

        JLabel copyrt = new JLabel("Controle de vendas - java edition", JLabel.CENTER);
        label.setSize(x / 2, y / 2);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(156, 20, 20, 255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 5));

        setVisible(true);

        try {

            Thread.sleep(getDuracao());
            
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " +
                    ex.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void ShowSplashAndExit() throws Exception{
        
        ShowSplash();
        
        FrmMenu frmMenu = new FrmMenu();
        
        try{
            
            frmMenu.setVisible(true);
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " +
                    ex.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
        
        this.dispose();
        
    }

}
