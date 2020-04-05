/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infoq.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author carlos
 */
public class ModuloConexao {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/dbinfoq";
    private static String user = "Carlos";
    private static String password ="";


    public static Connection conector() {
        java.sql.Connection conexao= null;
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return conexao;
        }
        
    }

    public static void reset() {
        
        try {
            
            conector();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
