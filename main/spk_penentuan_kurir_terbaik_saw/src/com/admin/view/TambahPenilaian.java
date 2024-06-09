package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;

public class TambahPenilaian extends javax.swing.JFrame {

      public TambahPenilaian() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            btn_ubah = new swing.ButtonGradient();
            btn_simpan = new swing.ButtonGradient();
            txtKodeKriteria1 = new textfield.TextField();
            idKurir = new textfield.TextField();
            txtKodeKriteria3 = new textfield.TextField();
            txtKodeKriteria4 = new textfield.TextField();
            txtKodeKriteria5 = new textfield.TextField();
            txtKodeKriteria6 = new textfield.TextField();
            txtKodeKriteria7 = new textfield.TextField();
            txtKodeKriteria8 = new textfield.TextField();
            txtKodeKriteria9 = new textfield.TextField();
            combobox1 = new combobox.Combobox();

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
            jPanel1.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 140, 30));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
            btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 140, 30));

            txtKodeKriteria1.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria1.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria1.setLabelText("Pemahaman Rute");
            jPanel1.add(txtKodeKriteria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 190, 50));

            idKurir.setEditable(false);
            idKurir.setBackground(new java.awt.Color(255, 255, 255));
            idKurir.setForeground(new java.awt.Color(97, 103, 122));
            idKurir.setLabelText("Id Kurir");
            jPanel1.add(idKurir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 190, 50));

            txtKodeKriteria3.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria3.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria3.setLabelText("Kepuasan Pelanggan");
            jPanel1.add(txtKodeKriteria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 190, 50));

            txtKodeKriteria4.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria4.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria4.setLabelText("Jumlah Return perbulan");
            jPanel1.add(txtKodeKriteria4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 190, 50));

            txtKodeKriteria5.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria5.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria5.setLabelText("Kecepatan Pengiriman");
            jPanel1.add(txtKodeKriteria5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, 50));

            txtKodeKriteria6.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria6.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria6.setLabelText("Keandalan");
            jPanel1.add(txtKodeKriteria6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 190, 50));

            txtKodeKriteria7.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria7.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria7.setLabelText("Jumlah Pengiriman Perbulan");
            jPanel1.add(txtKodeKriteria7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 190, 50));

            txtKodeKriteria8.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria8.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria8.setLabelText("Komunikasi Dengan Pelanggan");
            jPanel1.add(txtKodeKriteria8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 190, 50));

            txtKodeKriteria9.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria9.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria9.setLabelText("Kehadiran");
            jPanel1.add(txtKodeKriteria9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 190, 50));

            combobox1.setLabeText("Nama Kurir");
            jPanel1.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, 50));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 500));

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
                        new TambahPenilaian().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private swing.ButtonGradient btn_ubah;
      private combobox.Combobox combobox1;
      public textfield.TextField idKurir;
      private javax.swing.JPanel jPanel1;
      public textfield.TextField txtKodeKriteria1;
      public textfield.TextField txtKodeKriteria3;
      public textfield.TextField txtKodeKriteria4;
      public textfield.TextField txtKodeKriteria5;
      public textfield.TextField txtKodeKriteria6;
      public textfield.TextField txtKodeKriteria7;
      public textfield.TextField txtKodeKriteria8;
      public textfield.TextField txtKodeKriteria9;
      // End of variables declaration//GEN-END:variables
}
