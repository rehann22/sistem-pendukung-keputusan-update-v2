package com.admin.view;

import com.admin.controler.PenilaianKurir;
import com.formdev.flatlaf.FlatLightLaf;

public class FormPenilaian extends javax.swing.JFrame {

      public FormPenilaian() {
            initComponents();
            PenilaianKurir data = new PenilaianKurir();
            data.TampilIdKurir(cbb_IdKurir);
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            btn_ubah = new swing.ButtonGradient();
            btn_simpan = new swing.ButtonGradient();
            cbb_IdKurir = new combobox.Combobox();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 140, 30));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
            btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 140, 30));

            cbb_IdKurir.setForeground(new java.awt.Color(97, 103, 122));
            cbb_IdKurir.setLabeText("Id Kurir");
            jPanel1.add(cbb_IdKurir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 270, 50));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed

      }//GEN-LAST:event_btn_simpanActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
           
      }//GEN-LAST:event_btn_ubahActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new FormPenilaian().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private swing.ButtonGradient btn_ubah;
      private combobox.Combobox cbb_IdKurir;
      private javax.swing.JPanel jPanel1;
      // End of variables declaration//GEN-END:variables
}
