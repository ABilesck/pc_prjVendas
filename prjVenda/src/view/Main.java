/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author aluno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SplashCode splash = new SplashCode(0);
        
        try{
            
            NimbusLookAndFeel nimbus = new NimbusLookAndFeel();
            UIManager.setLookAndFeel(nimbus);
            SwingUtilities.updateComponentTreeUI(splash);
            splash.ShowSplashAndExit();
            
        }catch (Exception ex){
            
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao iniciar o sistema\n: " +
                    ex.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
}
