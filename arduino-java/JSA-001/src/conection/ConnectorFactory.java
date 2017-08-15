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
import java.sql.SQLException;



public class ConnectorFactory {
   
    //private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql//localhost:3306/arduino";
    private static final String PASS = "q1w2e3r4";
    private static final String USER = "root";
    
    
    public static Connection getConnection() throws SQLException{
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexao = DriverManager.getConnection(URL, USER, PASS);
        return conexao;
    }
    
            
    
    
    
}
