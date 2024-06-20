package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.admin.controler.DataKurir;
import com.admin.view.PageDataKurir;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class FormDataKurir extends javax.swing.JFrame {
      

      public FormDataKurir() {
            initComponents();
//            customizeDateChooser(tglBergabung);
      }
      
//      public void customizeDateChooser(JDateChooser tgl) {
//            // Mengatur latar belakang menjadi putih
//            tgl.getDateEditor().getUiComponent().setBackground(Color.WHITE);
//
//            // Mengatur border hanya di bawah
//            ((JTextField)tgl.getDateEditor().getUiComponent()).setBorder(
//                BorderFactory.createMatteBorder(0, 0, 1, 0, (new Color(97, 103, 122))) // Menggunakan warna hitam untuk border bawah
//            );
//
//            tgl.getDateEditor().getUiComponent().setForeground(new Color(97, 103, 122));
//
//            // Mengatur font
//            tgl.getDateEditor().getUiComponent().setFont(new Font("Segoe UI", Font.PLAIN, 12));
//       }

      
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
            txtEmail = new textfield.TextField();
            tglBergabung = new com.toedter.calendar.JDateChooser();
            jLabel1 = new javax.swing.JLabel();

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

            txtEmail.setBackground(new java.awt.Color(255, 255, 255));
            txtEmail.setForeground(new java.awt.Color(97, 103, 122));
            txtEmail.setLabelText("Email");
            jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 290, 40));

            tglBergabung.setBackground(new java.awt.Color(255, 255, 255));
            tglBergabung.setForeground(new java.awt.Color(97, 103, 122));
            jPanel1.add(tglBergabung, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 290, 30));
            tglBergabung.getDateEditor().getUiComponent().setBackground(Color.WHITE);

            // Mengatur border hanya di bawah
            ((JTextField)tglBergabung.getDateEditor().getUiComponent()).setBorder(
                  BorderFactory.createMatteBorder(0, 0, 1, 0, (new Color(97, 103, 122))) // Menggunakan warna hitam untuk border bawah
            );

            tglBergabung.getDateEditor().getUiComponent().setForeground(new Color(97, 103, 122));

            // Mengatur font
            tglBergabung.getDateEditor().getUiComponent().setFont(new Font("Segoe UI", Font.PLAIN, 12));

            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Tanggal Bergabung");
            jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 366, 120, 20));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
           DataKurir data = new DataKurir(); //class
           PageDataKurir page = new PageDataKurir();
           data.simpanDataKurir(page.tblKurir, txtIdKurir, txtNamaKurir, txtAlamat, txtEmail, txtNoTelp, tglBergabung);
      }//GEN-LAST:event_btn_simpanActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
            DataKurir data = new DataKurir(); //class
            PageDataKurir page = new PageDataKurir();
            data.EditDataKurir(page.tblKurir, txtIdKurir, txtNamaKurir, txtAlamat, txtEmail, txtNoTelp, tglBergabung);
      }//GEN-LAST:event_btn_ubahActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new FormDataKurir().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private swing.ButtonGradient btn_ubah;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JPanel jPanel1;
      private textarea.TextAreaScroll textAreaScroll1;
      public com.toedter.calendar.JDateChooser tglBergabung;
      public textarea.TextArea txtAlamat;
      public textfield.TextField txtEmail;
      public textfield.TextField txtIdKurir;
      public textfield.TextField txtNamaKurir;
      public textfield.TextField txtNoTelp;
      // End of variables declaration//GEN-END:variables
}
