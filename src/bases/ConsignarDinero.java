/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bases;

import javax.swing.JOptionPane;
/**
 *
 * @author VALENTINA
 */
public class ConsignarDinero extends javax.swing.JFrame {

    private String numero;
    /**
     * Creates new form ConsignarDinero
     */
    public ConsignarDinero(String numero) {
        initComponents();
        this.numero = numero;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmarConsigna, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarConsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtSaldoConsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSaldoConsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarConsignar)
                    .addComponent(btnConfirmarConsigna))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarConsignaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarConsignaActionPerformed

       
        String saldoConsignar = txtSaldoConsignar.getText();
        
        Usuario usuario = new Usuario();
 
            if (validarSaldo(saldoConsignar)) {
                double saldo = Double.parseDouble(saldoConsignar);
                consignarDinero(numero, saldo);
            } else {
                JOptionPane.showMessageDialog(null, "El saldo ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btnConfirmarConsignaActionPerformed

    private void btnCancelarConsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsignarActionPerformed
        MenuBanco ventanaBanco = new MenuBanco(numero);
        ventanaBanco.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarConsignarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsignarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsignarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsignarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsignarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String numero = JOptionPane.showInputDialog(null, "Ingrese el número de celular:");
                new ConsignarDinero(numero).setVisible(true);
            }
        });
    }
    

    private boolean validarSaldo(String saldo) {
        try {
            double valor = Double.parseDouble(saldo);
            return valor >= 0;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void consignarDinero(String celular, double saldo) {
        
        AplicacionBancaria aplicacionBancaria = new AplicacionBancaria();
        int filasActualizadas = aplicacionBancaria.consignarDinero(celular, saldo);
        
        try {
            if (filasActualizadas > 0) {
                MensajeExito2 ventanaMensaje = new MensajeExito2(numero);
                ventanaMensaje.setVisible(true);
                this.dispose();  
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la consignación", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarConsignar;
    private javax.swing.JButton btnConfirmarConsigna;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtSaldoConsignar;
    // End of variables declaration//GEN-END:variables
}