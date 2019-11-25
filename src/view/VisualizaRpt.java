/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import dao.BancoSQL;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aluno
 */
public class VisualizaRpt {
    
    public static void GerarRel(String arquivo, Map param, String titulo)
            throws Exception {
        
        Connection con = BancoSQL.getConnection();
        JasperPrint jp = JasperFillManager.fillReport("src/view/" + arquivo, param, con);
        JasperViewer view = new JasperViewer(jp,false);
        view.setTitle(titulo);
        view.setVisible(true);
        
    }
    
}
