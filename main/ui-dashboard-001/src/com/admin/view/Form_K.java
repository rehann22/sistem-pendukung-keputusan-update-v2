package com.admin.view;

import com.admin.controler.MasterDataUsers;
import com.formdev.flatlaf.FlatLightLaf;

public class Form_K extends javax.swing.JFrame {

      public Form_K() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            txt_password = new textfield.TextField();
            txt_username = new textfield.TextField();
            buttonGradient2 = new swing.ButtonGradient();
            txt_id = new textfield.TextField();
            txt_nama = new textfield.TextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_password.setBackground(new java.awt.Color(255, 255, 255));
            txt_password.setForeground(new java.awt.Color(130, 130, 130));
            txt_password.setLabelText("Password");
            jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 250, -1));

            txt_username.setBackground(new java.awt.Color(255, 255, 255));
            txt_username.setForeground(new java.awt.Color(130, 130, 130));
            txt_username.setLabelText("Username");
            jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 250, -1));

            buttonGradient2.setText("Simpan");
            buttonGradient2.setColor1(new java.awt.Color(93, 7, 130));
            buttonGradient2.setColor2(new java.awt.Color(7, 65, 115));
            buttonGradient2.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonGradient2ActionPerformed(evt);
                  }
            });
            jPanel1.add(buttonGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 240, 30));

            txt_id.setEditable(false);
            txt_id.setBackground(new java.awt.Color(255, 255, 255));
            txt_id.setForeground(new java.awt.Color(130, 130, 130));
            txt_id.setLabelText("Id");
            jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 250, -1));

            txt_nama.setBackground(new java.awt.Color(255, 255, 255));
            txt_nama.setForeground(new java.awt.Color(130, 130, 130));
            txt_nama.setLabelText("Nama");
            jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 250, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void buttonGradient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient2ActionPerformed
            MasterDataUsers data = new MasterDataUsers();
            Form_C form = new Form_C();
            data.EditDataUsers(form.tabel_pengguna, txt_id, txt_nama, txt_username, txt_password);
      }//GEN-LAST:event_buttonGradient2ActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_K().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient buttonGradient2;
      private javax.swing.JPanel jPanel1;
      public textfield.TextField txt_id;
      public textfield.TextField txt_nama;
      public textfield.TextField txt_password;
      public textfield.TextField txt_username;
      // End of variables declaration//GEN-END:variables
}
