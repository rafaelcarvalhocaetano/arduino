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
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO temp (valor) VALUES (?)");
        try {
            ps = c.prepareStatement(sql.toString());
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
}