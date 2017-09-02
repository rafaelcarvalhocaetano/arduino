package dao;

import bean.Dados;
import factory.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Crud {
    
    public void salvar(Dados d) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("INSERT INTO conexao (nome) VALUE (?) ");
        
        Connection con = Conexao.conexao();
        
        PreparedStatement ptt = con.prepareStatement(sql.toString());
        
        ptt.setString(1, d.getNome());
        
        ptt.executeUpdate();
        
    }
    public void excluir(Dados d) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("DELETE FROM conexao WHERE id = ? ");
        
        Connection conexao = Conexao.conexao();
        PreparedStatement ptt = conexao.prepareStatement(sql.toString());
        
        ptt.setInt(1, d.getId());
        ptt.executeUpdate();
    }
    public void editar(Dados d) throws SQLException{
        StringBuilder sql = new StringBuilder();
        
        sql.append("UPDATE conexao SET nome = ? WHERE id = ? ");
        
        Connection conexao = Conexao.conexao();
        PreparedStatement ptt = conexao.prepareStatement(sql.toString());
        
        ptt.setString(1, d.getNome());
        
        ptt.executeUpdate();
                        
    }
    public ArrayList<Dados> listar() throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, nome FROM conexao ");
        
        Connection conexao = Conexao.conexao();
        PreparedStatement ptt = conexao.prepareStatement(sql.toString());
        
        ResultSet rs = ptt.executeQuery();
        
        ArrayList<Dados> itens = new ArrayList<Dados>();
        
        while (rs.next()) {
            Dados dd = new Dados();
            
            dd.setId(rs.getInt("id"));
            dd.setNome(rs.getString("nome"));
            
            itens.add(dd);
            
        }
        return itens;
    }

    public void listar(Dados d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
