
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    
    private static final String PASS = "q1w2e3r4";
    private static final String USER = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/conectandoc";
    
    
    
    public static Connection conexao() throws SQLException{
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
        } catch (SQLException e) {
            System.out.println("Erro na conexão do MYSQL");
            e.printStackTrace();
        }
        
        Connection con = DriverManager.getConnection(URL, USER, PASS);
            
        return con;
       
    }
    
    
}
