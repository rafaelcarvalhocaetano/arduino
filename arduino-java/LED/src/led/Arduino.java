/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package led;

import gnu.io.*;
import java.util.Enumeration;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Arduino extends javax.swing.JFrame implements SerialPortEventListener{
    
    private String [] PORT_NAME_LIST; //retornará as portas disponiveis no SO
    private Enumeration BUSCA_LISTA_PORT; //retorna uma lista de porta disponíveis
    
    public Arduino() {
        initComponents();
    }
    
    //retorna as portas disponiveis
    public String [] RetornaPortas(){
        int i = 0;
        
        BUSCA_LISTA_PORT = CommPortIdentifier.getPortIdentifiers();
        PORT_NAME_LIST = new String[10];
        
        while (BUSCA_LISTA_PORT.hasMoreElements()) {
            
            CommPortIdentifier PORTA_ATUAL = (CommPortIdentifier)BUSCA_LISTA_PORT.nextElement();
            
            PORT_NAME_LIST[i] = PORTA_ATUAL.getName();
            
            i++;
            
        }
        return PORT_NAME_LIST;       
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        portas = new javax.swing.JComboBox<>();
        modelo_placa = new javax.swing.JComboBox<>();
        bauldRate = new javax.swing.JComboBox<>();
        status = new javax.swing.JTextField();
        led_status = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();
        btnBuscarPortas = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ligando Led");

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

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
        portas.setSelectedIndex(-1);
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

        led_status.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        led_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        led_status.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(portas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modelo_placa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bauldRate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(led_status, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscarPortas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesconectar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modelo_placa, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bauldRate, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(portas, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(led_status, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(406, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
       
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        
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
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bauldRate;
    private javax.swing.JButton btnBuscarPortas;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel led_status;
    private javax.swing.JComboBox<String> modelo_placa;
    private javax.swing.JComboBox<String> portas;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
