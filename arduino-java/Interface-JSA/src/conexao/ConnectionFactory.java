/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;
/**
 *
 * @author Developer
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConnectionFactory {
   
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/arduinojava";
    private static final String PASS = "q1w2e3r4";
    private static final String USER = "root";
    
    
    public static Connection getConnection() throws SQLException{
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexao = DriverManager.getConnection(URL, USER, PASS);
        return conexao;
    }
    public static void closeConnection(Connection c){
        if(c != null){
            try {
                c.close();
            } catch (SQLException e) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    public static void closeConnection(Connection c, PreparedStatement pst){
       if(pst != null){
           try {
               pst.close();
           } catch (SQLException e) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
           }
       }
    }
    public static void closeConnection(Connection c, PreparedStatement pst, ResultSet rs){
       if(rs != null){
           try {
               rs.close();
           } catch (SQLException e) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
           }
       }
        closeConnection(c, pst);
    }
}