
package test;

import bean.Temperatura;
import dao.TemperaturaDAO;
import java.sql.SQLException;

/**
 *
 * @author Rafael Carvalho
 */
public class Test {
    
    
    
     public static void main(String[] args){
        Temperatura temp = new Temperatura();
        
        temp.setValor(26.5);
        
        TemperaturaDAO dao = new TemperaturaDAO();
        
        try {
            if(dao.save(temp)){
                System.out.println("Salvo com sucesso ..."+temp.getValor());
            }else{
                
                System.err.println("erro ... ");
            }
        } catch (SQLException ex) {
            System.err.println("erro ... "+ex);
        }
                
    }
}
