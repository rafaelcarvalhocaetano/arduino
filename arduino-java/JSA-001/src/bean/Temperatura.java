
package bean;

import java.util.Date;

/**
 * @author Rafael
 */
public class Temperatura {
    
    private int id;
    private Double valor;
    private Date data;

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
