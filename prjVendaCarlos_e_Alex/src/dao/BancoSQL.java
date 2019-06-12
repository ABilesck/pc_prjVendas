/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class BancoSQL {
    
    private static String servidor = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String urlBanco = "jdbc:sqlserver://localhost:1433;";
    private static String nomeBanco = "databaseName=banco;";
    private static String usuario = "user=alex;";
    private static String senha = "password=alex123";
    
    public static Connection getConnection() throws SQLException,
            ClassNotFoundException{
    
        Class.forName(servidor);
        
        System.out.println("conectado");
        
        return DriverManager.getConnection(urlBanco + nomeBanco + 
                usuario + senha);
    }
    
}
