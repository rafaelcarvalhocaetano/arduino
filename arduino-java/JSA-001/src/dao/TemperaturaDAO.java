package dao;

import bean.Temperatura;
import java.sql.Connection;
import conection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * @author Rafael Carvalho
 */
public class TemperaturaDAO {

    public boolean save(Temperatura t) throws SQLException {

        Connection c = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("INSERT INTO temp (valor) VALUES (?)");
            ps.setDouble(1, t.getValor());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Erro em " + e);
            //Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(c, ps);
        }
    }
    
    public static void main(String[] args){
        Temperatura temp = new Temperatura();
        
        temp.setValor(23.5);
        
        TemperaturaDAO dao = new TemperaturaDAO();
        
        try {
            if(dao.save(temp)){
                System.out.println("Salvo com sucesso ...");
            }else{
                
                System.err.println("erro ... ");
            }
        } catch (SQLException ex) {
            System.err.println("erro ... "+ex);
        }
                
    }

}
