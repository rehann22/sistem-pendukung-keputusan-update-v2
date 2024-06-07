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
            cbbJenis3 = new combobox.Combobox();
            cbbJenis4 = new combobox.Combobox();
            cbbJenis5 = new combobox.Combobox();
            txtKodeKriteria2 = new textfield.TextField();
            cbbJenis2 = new combobox.Combobox();
            cbbJenis6 = new combobox.Combobox();
            cbbJenis7 = new combobox.Combobox();
            cbbJenis8 = new combobox.Combobox();
            cbbJenis9 = new combobox.Combobox();
            txtKodeKriteria3 = new textfield.TextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setPreferredSize(new java.awt.Dimension(840, 530));
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

            txtKodeKriteria1.setEditable(false);
            txtKodeKriteria1.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria1.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria1.setLabelText("Jumlah Pengiriman Perbulan");
            jPanel1.add(txtKodeKriteria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 190, 50));

            cbbJenis3.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
            cbbJenis3.setSelectedIndex(-1);
            cbbJenis3.setLabeText("Kecepatan Pengiriman");
            jPanel1.add(cbbJenis3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 190, 50));

            cbbJenis4.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
            cbbJenis4.setSelectedIndex(-1);
            cbbJenis4.setLabeText("Keandalan");
            jPanel1.add(cbbJenis4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 190, 50));

            cbbJenis5.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
            cbbJenis5.setSelectedIndex(-1);
            cbbJenis5.setLabeText("Kepuasan Pelanggan");
            jPanel1.add(cbbJenis5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 190, 50));

            txtKodeKriteria2.setEditable(false);
            txtKodeKriteria2.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria2.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria2.setLabelText("Jumlah Return perbulan");
            jPanel1.add(txtKodeKriteria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 190, 50));

            cbbJenis2.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis2.setLabeText("Nama Kurir");
            jPanel1.add(cbbJenis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 190, 50));

            cbbJenis6.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
            cbbJenis6.setSelectedIndex(-1);
            cbbJenis6.setLabeText("Komunikasi Dengan Pelanggan");
            jPanel1.add(cbbJenis6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 200, 50));

            cbbJenis7.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
            cbbJenis7.setSelectedIndex(-1);
            cbbJenis7.setLabeText("Disiplin & Kehadiran");
            jPanel1.add(cbbJenis7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 200, 50));

            cbbJenis8.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
            cbbJenis8.setSelectedIndex(-1);
            cbbJenis8.setLabeText("Komunikasi Dengan Pelanggan");
            jPanel1.add(cbbJenis8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 200, 50));

            cbbJenis9.setForeground(new java.awt.Color(97, 103, 122));
            cbbJenis9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
            cbbJenis9.setSelectedIndex(-1);
            cbbJenis9.setLabeText("Pemahaman Rute");
            jPanel1.add(cbbJenis9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 200, 50));

            txtKodeKriteria3.setEditable(false);
            txtKodeKriteria3.setBackground(new java.awt.Color(255, 255, 255));
            txtKodeKriteria3.setForeground(new java.awt.Color(97, 103, 122));
            txtKodeKriteria3.setLabelText("Id Kurir");
            jPanel1.add(txtKodeKriteria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 190, 50));

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
      public combobox.Combobox cbbJenis2;
      public combobox.Combobox cbbJenis3;
      public combobox.Combobox cbbJenis4;
      public combobox.Combobox cbbJenis5;
      public combobox.Combobox cbbJenis6;
      public combobox.Combobox cbbJenis7;
      public combobox.Combobox cbbJenis8;
      public combobox.Combobox cbbJenis9;
      private javax.swing.JPanel jPanel1;
      public textfield.TextField txtKodeKriteria1;
      public textfield.TextField txtKodeKriteria2;
      public textfield.TextField txtKodeKriteria3;
      // End of variables declaration//GEN-END:variables
}
