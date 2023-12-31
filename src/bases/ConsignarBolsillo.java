/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author VALENTINA
 */
public class ConsignarBolsillo extends javax.swing.JFrame {

    private String numero;
    private Bases bases;
    private Connection conexion;
    /**
     * Creates new form ConsignarBolsillo
     */
    public ConsignarBolsillo(String numero) {
        initComponents();
        this.numero = numero;
        bases = Bases.getInstancia();
        conexion = bases.conectar();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtSaldoConsignar = new javax.swing.JTextField();
        btnCancelarConsignar = new javax.swing.JButton();
        btnConfirmarConsigna = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombreBolsillo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Saldo a Consignar:");

        btnCancelarConsignar.setText("Cancelar");
        btnCancelarConsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConsignarActionPerformed(evt);
            }
        });

        btnConfirmarConsigna.setText("Confirmar");
        btnConfirmarConsigna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarConsignaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del Bolsillo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtSaldoConsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConfirmarConsigna, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarConsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(txtNombreBolsillo)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreBolsillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSaldoConsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarConsignar)
                    .addComponent(btnConfirmarConsigna))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarConsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsignarActionPerformed
        MenuBolsillo ventanaBanco = new MenuBolsillo(numero);
        ventanaBanco.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarConsignarActionPerformed

    private void btnConfirmarConsignaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarConsignaActionPerformed

        String nombreBolsillo = txtNombreBolsillo.getText();
        String saldoConsignar = txtSaldoConsignar.getText();
        double saldoDisponible = obtenerSaldoDisponible(numero);

        Bolsillo bolsillo = new Bolsillo();
        boolean datosCorrectos = bolsillo.verificarNombreBolsillo(nombreBolsillo);
        
        if(datosCorrectos){
            if (validarSaldo(saldoConsignar, saldoDisponible)) {
                double saldo = Double.parseDouble(saldoConsignar);
                consignarDinero(nombreBolsillo, numero, saldo);
            } else {
                JOptionPane.showMessageDialog(null, "El saldo ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Los datos son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_btnConfirmarConsignaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsignarBolsillo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsignarBolsillo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsignarBolsillo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsignarBolsillo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String numero = JOptionPane.showInputDialog(null, "Ingrese el número de celular:");
                new ConsignarBolsillo(numero).setVisible(true);
            }
        });
    }
    
    private boolean validarSaldo(String saldo, double saldoDisponible) {
        try {
            double valor = Double.parseDouble(saldo);
            if(valor <= saldoDisponible){
                return valor >= 0;
            }else{
            return false;
            }
            
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    private void consignarDinero(String nombreBolsillo, String celular, double saldo) {
        
        Bolsillo bolsillo = new Bolsillo();
        int filasActualizadas = bolsillo.consignarDineroBolsillo(nombreBolsillo, celular, saldo);
        
        try {
            
            if (filasActualizadas > 0) {
                MensajeExitoBolsillo ventanaMensaje = new MensajeExitoBolsillo(numero);
                ventanaMensaje.setVisible(true);
                this.dispose();  
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la consignación", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private double obtenerSaldoDisponible(String celular) {
    Connection conexion = bases.conectar();
    try {
        Statement statement = conexion.createStatement();
        String query = "SELECT SaldoInicial FROM usuario WHERE Celular = '" + celular + "'";
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            return resultSet.getDouble("SaldoInicial");
        } else {
            return 0.0; // Si no se encuentra el usuario, se asume saldo disponible 0
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return 0.0;
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarConsignar;
    private javax.swing.JButton btnConfirmarConsigna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNombreBolsillo;
    private javax.swing.JTextField txtSaldoConsignar;
    // End of variables declaration//GEN-END:variables
}
