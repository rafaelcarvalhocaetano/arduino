
package dao;

import bean.Temperatura;
import java.sql.Connection;
import conection.ConnectorFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Developer
 */
public class TemperaturaDAO {
    
  public boolean temp(Temperatura t) throws SQLException{
      
      Connection c = ConnectorFactory.getConnection();
      PreparedStatement ps = null;
      try {
           ps = c.prepareStatement("INSERT INTO temperatura (valor) VALUES (?)");
           ps.setDouble(1, t.getValor());
           
           ps.executeUpdate();
           
           return true;
          
      } catch (SQLException e) {
          System.err.println("Erro em "+e);
         //Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, e);
          return false;
      }     
  }
    
}
