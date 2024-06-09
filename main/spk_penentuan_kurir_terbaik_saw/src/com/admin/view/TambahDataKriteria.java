package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;

public class TambahDataKriteria extends javax.swing.JFrame {

      public TambahDataKriteria() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
                   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
                   private void initComponents() {

                                      jPanel1 = new javax.swing.JPanel();
                                      txtNilai = new textfield.TextField();
                                      txtNamaKriteria = new textfield.TextField();
                                      btn_ubah = new swing.ButtonGradient();
                                      btn_simpan = new swing.ButtonGradient();
                                      cbbJenis = new combobox.Combobox();
                                      txtKodeKriteria = new textfield.TextField();

                                      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                                      getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                                      jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                                      jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                                      txtNilai.setBackground(new java.awt.Color(255, 255, 255));
                                      txtNilai.setForeground(new java.awt.Color(97, 103, 122));
                                      txtNilai.setLabelText("Nilai");
                                      jPanel1.add(txtNilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 250, -1));

                                      txtNamaKriteria.setEditable(false);
                                      txtNamaKriteria.setBackground(new java.awt.Color(255, 255, 255));
                                      txtNamaKriteria.setForeground(new java.awt.Color(97, 103, 122));
                                      txtNamaKriteria.setLabelText("Nama Kriteria");
                                      jPanel1.add(txtNamaKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 250, -1));

                                      btn_ubah.setText("Ubah");
                                      btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
                                      btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
                                      btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                            btn_ubahActionPerformed(evt);
                                                         }
                                      });
                                      jPanel1.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 120, 30));

                                      btn_simpan.setText("Simpan");
                                      btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
                                      btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
                                      btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                            btn_simpanActionPerformed(evt);
                                                         }
                                      });
                                      jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 120, 30));

                                      cbbJenis.setForeground(new java.awt.Color(97, 103, 122));
                                      cbbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Benefit", "Cost" }));
                                      cbbJenis.setSelectedIndex(1);
                                      cbbJenis.setLabeText("Jenis");
                                      jPanel1.add(cbbJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 240, -1));

                                      txtKodeKriteria.setEditable(false);
                                      txtKodeKriteria.setBackground(new java.awt.Color(255, 255, 255));
                                      txtKodeKriteria.setForeground(new java.awt.Color(97, 103, 122));
                                      txtKodeKriteria.setLabelText("Kode Kriteria");
                                      jPanel1.add(txtKodeKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 250, -1));

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
                        new TambahDataKriteria().setVisible(true);
                  }
            });
      }

                   // Variables declaration - do not modify//GEN-BEGIN:variables
                   private swing.ButtonGradient btn_simpan;
                   private swing.ButtonGradient btn_ubah;
                   public combobox.Combobox cbbJenis;
                   private javax.swing.JPanel jPanel1;
                   public textfield.TextField txtKodeKriteria;
                   public textfield.TextField txtNamaKriteria;
                   public textfield.TextField txtNilai;
                   // End of variables declaration//GEN-END:variables
}
