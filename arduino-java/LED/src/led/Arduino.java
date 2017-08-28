
package led;

import gnu.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Arduino extends javax.swing.JFrame implements SerialPortEventListener{
    
    private String [] PORT_NAME_LIST; //retornará as portas disponiveis no SO
    private Enumeration BUSCA_LISTA_PORT; //retorna uma lista de porta disponíveis
    private CommPortIdentifier ID_PORTAS;
    private SerialPort SERIAL_PORT;
    private String appName = "Supervisor";
    private final int TIME_OUT = 1000;
    private OutputStream output = null;
    private BufferedReader input = null;
    private String SERIAL_PORT_NAME;
    private int BAULD_RATE;
    private String LEITURA_SERIAL;
    
    public Arduino() {
        initComponents();
    }
    
    //retorna as portas disponiveis
    public String [] RetornaPortas(){
        int i = 0;
        
        BUSCA_LISTA_PORT = null;        
        BUSCA_LISTA_PORT = CommPortIdentifier.getPortIdentifiers();
        
        PORT_NAME_LIST = new String[10];
        
        while (BUSCA_LISTA_PORT.hasMoreElements()) {
            
            CommPortIdentifier PORTA_ATUAL = (CommPortIdentifier)BUSCA_LISTA_PORT.nextElement();
            
            PORT_NAME_LIST[i] = PORTA_ATUAL.getName();
            
            i++;
            
        }
        return PORT_NAME_LIST;       
    }
    
    public boolean inicia_serial(String serial_port_name, int baul_rate){
        boolean status = false;
        try {
            BUSCA_LISTA_PORT = null;        
            BUSCA_LISTA_PORT = CommPortIdentifier.getPortIdentifiers();
            ID_PORTAS = null;
            
            while(ID_PORTAS == null && BUSCA_LISTA_PORT.hasMoreElements()){
               
                CommPortIdentifier PORTA_ATUAL = (CommPortIdentifier) BUSCA_LISTA_PORT.nextElement();
                if(PORTA_ATUAL.getName().equals(serial_port_name) || PORTA_ATUAL.getName().startsWith(serial_port_name)){
                    SERIAL_PORT = (SerialPort) PORTA_ATUAL.open(appName, TIME_OUT);
                    ID_PORTAS = PORTA_ATUAL;
                    
                    System.out.println("Conectando a porta serial: "+ID_PORTAS.getName());
                    System.out.println("Taxa de transmissão: "+baul_rate);
                    break;
                }
            }
            SERIAL_PORT.setSerialPortParams(baul_rate, SERIAL_PORT.DATABITS_8, SERIAL_PORT.STOPBITS_1, SERIAL_PORT.PARITY_NONE);
            SERIAL_PORT.addEventListener(this);
            SERIAL_PORT.notifyOnDataAvailable(true);
            
            status = true;
            
            if(ID_PORTAS == null || SERIAL_PORT == null){
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }
    public void enviarDados(String dados){
        try {
            output = SERIAL_PORT.getOutputStream();
            output.write(dados.getBytes());
            
            
           
        } catch (Exception e) {
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(null, "ERRO AO ENVIAR OS DADOS ... "+e);
        }
    }
    public synchronized void closeSerial(){
        if(SERIAL_PORT != null){
            SERIAL_PORT.removeEventListener();
            SERIAL_PORT.close();
            System.out.println("Comunicação encerrada ... ");
            //JOptionPane.showMessageDialog(null, "A comunicação serial foi encerrada com sucesso ... ");
            imgAlt.setIcon(new ImageIcon(getClass().getResource("/imagem/parado.png")));
        }
    }
    
    private void Bauld_Rates(){
        bauldRate.addItem("300");
        bauldRate.addItem("1200");
        bauldRate.addItem("2400");
        bauldRate.addItem("4800");
        bauldRate.addItem("9600");
        bauldRate.addItem("19200");
        bauldRate.addItem("38400");
        bauldRate.addItem("57600");
        bauldRate.addItem("115200");
        bauldRate.addItem("230400");
        bauldRate.addItem("250000");        
    }
    
    private void Modelo_Plca(){
        modelo_placa.addItem("Arduino Yún");
        modelo_placa.addItem("Arduino UNO");
        modelo_placa.addItem("Arduino Duemilanove");
        modelo_placa.addItem("Arduino Diecimila");
        modelo_placa.addItem("Arduino Nano");
        modelo_placa.addItem("Arduino Mega");
        modelo_placa.addItem("Arduino Mega 2560");
        modelo_placa.addItem("Arduino Mega ADK");
        modelo_placa.addItem("Arduino Leonardo");
        modelo_placa.addItem("Arduino Micro");
        modelo_placa.addItem("Arduino Esplora");
        modelo_placa.addItem("Arduino Mini");
        modelo_placa.addItem("Arduino Ethernet");
        modelo_placa.addItem("Arduino Fio");
        modelo_placa.addItem("Arduino BT");
       
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        portas = new javax.swing.JComboBox<>();
        modelo_placa = new javax.swing.JComboBox<>();
        bauldRate = new javax.swing.JComboBox<>();
        status = new javax.swing.JTextField();
        lbInfo = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();
        btnBuscarPortas = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();
        imgAlt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ligando Led");

        img.setBackground(new java.awt.Color(51, 102, 255));
        img.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        img.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dados da Comunicação");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Status :");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mod. Placa :");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bauld. Rate :");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Portas :");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        portas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        portas.setEnabled(false);

        modelo_placa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        modelo_placa.setEnabled(false);
        modelo_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelo_placaActionPerformed(evt);
            }
        });

        bauldRate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bauldRate.setEnabled(false);
        bauldRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bauldRateActionPerformed(evt);
            }
        });

        status.setEditable(false);
        status.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        status.setForeground(new java.awt.Color(255, 0, 0));
        status.setText("Desconectado !");
        status.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbInfo.setBackground(new java.awt.Color(255, 255, 255));
        lbInfo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnConectar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnConectar.setText("Conectar");
        btnConectar.setEnabled(false);
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnBuscarPortas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscarPortas.setText("Buscar Portas");
        btnBuscarPortas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPortasActionPerformed(evt);
            }
        });

        btnDesconectar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDesconectar.setText("Desconectar");
        btnDesconectar.setEnabled(false);
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });

        imgAlt.setBackground(new java.awt.Color(255, 255, 255));
        imgAlt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        imgAlt.setForeground(new java.awt.Color(255, 255, 255));
        imgAlt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgAlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/if_buttons_16_10672.png"))); // NOI18N

        javax.swing.GroupLayout imgLayout = new javax.swing.GroupLayout(img);
        img.setLayout(imgLayout);
        imgLayout.setHorizontalGroup(
            imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(imgLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(portas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(imgLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modelo_placa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(imgLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bauldRate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(imgLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imgAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgLayout.createSequentialGroup()
                        .addComponent(btnBuscarPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesconectar)))
                .addContainerGap())
        );
        imgLayout.setVerticalGroup(
            imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modelo_placa, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bauldRate, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(portas, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgAlt)
                    .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
       
        SERIAL_PORT_NAME = (String)(portas.getSelectedItem());
        BAULD_RATE = Integer.parseInt((String) bauldRate.getSelectedItem());
                
        if(inicia_serial(SERIAL_PORT_NAME, BAULD_RATE)){
            
            btnBuscarPortas.setEnabled(false);
            btnConectar.setEnabled(false);
            btnDesconectar.setEnabled(true);
                
            bauldRate.setEnabled(false);
            modelo_placa.setEnabled(false);
            portas.setEnabled(false);
            status.setText("Conectado");
            lbInfo.setText("Conectado a porta:"+portas.getSelectedItem());
            imgAlt.setIcon(new ImageIcon(getClass().getResource("/imagem/stop.png")));
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        closeSerial();
        btnBuscarPortas.setEnabled(true);
        btnConectar.setEnabled(false);
        btnDesconectar.setEnabled(false);
                
        bauldRate.setEnabled(false);
        modelo_placa.setEnabled(false);
        portas.setEnabled(false);
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void btnBuscarPortasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPortasActionPerformed
       
        bauldRate.setModel(new DefaultComboBoxModel(new String[]{} ));
        modelo_placa.setModel(new DefaultComboBoxModel(new String[]{} ));
        portas.setModel(new DefaultComboBoxModel(new String[]{} ));
        
        RetornaPortas();
        
        for(int i=0; i<PORT_NAME_LIST.length; i++){
            
            portas.addItem(PORT_NAME_LIST[i]); 
        }
        if(PORT_NAME_LIST[0] != null){
                
                btnBuscarPortas.setEnabled(true);
                btnConectar.setEnabled(true);
                btnDesconectar.setEnabled(true);
                
                bauldRate.setEnabled(true);
                modelo_placa.setEnabled(true);
                portas.setEnabled(true);
                
                lbInfo.setText("Informe os Valores e click em conectar ... ");
                
                Bauld_Rates();
                Modelo_Plca();
                
            }else if(PORT_NAME_LIST[0] == null){
               
                lbInfo.setText("Nenhuma porta localizada ... ");
                JOptionPane.showConfirmDialog(null, "Nenhuma porta foi localizada, verifique novamente ...");
                lbInfo.setText("Click no botão buscar portas ... ");
                
                btnBuscarPortas.setEnabled(true);
                btnConectar.setEnabled(false);
                btnDesconectar.setEnabled(false);
                
                bauldRate.setEnabled(false);
                modelo_placa.setEnabled(false);
                portas.setEnabled(false);
                
            }
    }//GEN-LAST:event_btnBuscarPortasActionPerformed

    private void bauldRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bauldRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bauldRateActionPerformed

    private void modelo_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelo_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelo_placaActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arduino().setVisible(true);
            }
        });
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        try {
            switch(spe.getEventType()){
                case SerialPortEvent.DATA_AVAILABLE:
                    if(input == null){
                        input = new BufferedReader(new InputStreamReader(SERIAL_PORT.getInputStream()));
                    }
                    if(input.ready()){
                        LEITURA_SERIAL = input.readLine();
                        System.out.println("Dados recebido pela serial ..."+LEITURA_SERIAL);
                    }else{
                        input = new BufferedReader(new InputStreamReader(SERIAL_PORT.getInputStream()));
                    }
                    break;
                    default:
                        break;
            }
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bauldRate;
    private javax.swing.JButton btnBuscarPortas;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JPanel img;
    private javax.swing.JLabel imgAlt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JComboBox<String> modelo_placa;
    private javax.swing.JComboBox<String> portas;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
