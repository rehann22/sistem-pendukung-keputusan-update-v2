package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.admin.controler.DataKurir;
import com.admin.view.PageDataKurir;

public class TambahDataKurir extends javax.swing.JFrame {

      public TambahDataKurir() {
            initComponents();
      }

      
      @SuppressWarnings("unchecked")
                   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
                   private void initComponents() {

                                      jPanel1 = new javax.swing.JPanel();
                                      textAreaScroll1 = new textarea.TextAreaScroll();
                                      txtAlamat = new textarea.TextArea();
                                      txtNamaKurir = new textfield.TextField();
                                      txtIdKurir = new textfield.TextField();
                                      btn_ubah = new swing.ButtonGradient();
                                      btn_simpan = new swing.ButtonGradient();
                                      txtNoTelp = new textfield.TextField();
                                      txtTglBergabung = new textfield.TextField();
                                      txtEmail = new textfield.TextField();

                                      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                                      getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                                      jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                                      jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                                      textAreaScroll1.setLabelText("Alamat");

                                      txtAlamat.setBackground(new java.awt.Color(255, 255, 255));
                                      txtAlamat.setColumns(20);
                                      txtAlamat.setForeground(new java.awt.Color(97, 103, 122));
                                      txtAlamat.setRows(5);
                                      textAreaScroll1.setViewportView(txtAlamat);

                                      jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 290, 110));

                                      txtNamaKurir.setBackground(new java.awt.Color(255, 255, 255));
                                      txtNamaKurir.setForeground(new java.awt.Color(97, 103, 122));
                                      txtNamaKurir.setLabelText("Nama Kurir");
                                      jPanel1.add(txtNamaKurir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 290, -1));

                                      txtIdKurir.setBackground(new java.awt.Color(255, 255, 255));
                                      txtIdKurir.setForeground(new java.awt.Color(97, 103, 122));
                                      txtIdKurir.setLabelText("Id Kurir");
                                      jPanel1.add(txtIdKurir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 290, -1));

                                      btn_ubah.setText("Ubah");
                                      btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
                                      btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
                                      btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                            btn_ubahActionPerformed(evt);
                                                         }
                                      });
                                      jPanel1.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 117, 30));

                                      btn_simpan.setText("Simpan");
                                      btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
                                      btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
                                      btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                            btn_simpanActionPerformed(evt);
                                                         }
                                      });
                                      jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 117, 30));

                                      txtNoTelp.setBackground(new java.awt.Color(255, 255, 255));
                                      txtNoTelp.setForeground(new java.awt.Color(97, 103, 122));
                                      txtNoTelp.setLabelText("No Telp");
                                      jPanel1.add(txtNoTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 290, 40));

                                      txtTglBergabung.setBackground(new java.awt.Color(255, 255, 255));
                                      txtTglBergabung.setForeground(new java.awt.Color(97, 103, 122));
                                      txtTglBergabung.setLabelText("Tanggal Bergabung");
                                      jPanel1.add(txtTglBergabung, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 290, 40));

                                      txtEmail.setBackground(new java.awt.Color(255, 255, 255));
                                      txtEmail.setForeground(new java.awt.Color(97, 103, 122));
                                      txtEmail.setLabelText("Email");
                                      jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 290, 40));

                                      getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

                                      pack();
                                      setLocationRelativeTo(null);
                   }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
           DataKurir data = new DataKurir(); //class
           PageDataKurir page = new PageDataKurir();
           data.simpanDataKurir(page.tblKurir, txtIdKurir, txtNamaKurir, txtAlamat, txtEmail, txtNoTelp, txtTglBergabung);
      }//GEN-LAST:event_btn_simpanActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
                    DataKurir data = new DataKurir(); //class
                   PageDataKurir page = new PageDataKurir();
                   data.EditDataKurir(page.tblKurir, txtIdKurir, txtNamaKurir, txtAlamat, txtEmail, txtNoTelp, txtTglBergabung);
      }//GEN-LAST:event_btn_ubahActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new TambahDataKurir().setVisible(true);
                  }
            });
      }

                   // Variables declaration - do not modify//GEN-BEGIN:variables
                   private swing.ButtonGradient btn_simpan;
                   private swing.ButtonGradient btn_ubah;
                   private javax.swing.JPanel jPanel1;
                   private textarea.TextAreaScroll textAreaScroll1;
                   public textarea.TextArea txtAlamat;
                   public textfield.TextField txtEmail;
                   public textfield.TextField txtIdKurir;
                   public textfield.TextField txtNamaKurir;
                   public textfield.TextField txtNoTelp;
                   public textfield.TextField txtTglBergabung;
                   // End of variables declaration//GEN-END:variables
}
