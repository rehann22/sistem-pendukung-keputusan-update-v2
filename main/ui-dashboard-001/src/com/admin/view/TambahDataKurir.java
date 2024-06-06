package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;

public class TambahDataKurir extends javax.swing.JFrame {

      public TambahDataKurir() {
            initComponents();
      }

      
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            textAreaScroll1 = new textarea.TextAreaScroll();
            txt_deskripsi = new textarea.TextArea();
            txt_namapenyakit = new textfield.TextField();
            txt_obat = new textfield.TextField();
            textarea = new textarea.TextAreaScroll();
            txt_pencegahan = new textarea.TextArea();
            textAreaScroll3 = new textarea.TextAreaScroll();
            txt_gejala = new textarea.TextArea();
            txt_kodepenyakit = new textfield.TextField();
            btn_ubah = new swing.ButtonGradient();
            btn_simpan = new swing.ButtonGradient();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            textAreaScroll1.setLabelText("Deskripsi Penyakit");

            txt_deskripsi.setBackground(new java.awt.Color(255, 255, 255));
            txt_deskripsi.setColumns(20);
            txt_deskripsi.setForeground(new java.awt.Color(97, 103, 122));
            txt_deskripsi.setRows(5);
            textAreaScroll1.setViewportView(txt_deskripsi);

            jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 290, 80));

            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapenyakit.setLabelText("Nama Penyakit");
            jPanel1.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 290, -1));

            txt_obat.setBackground(new java.awt.Color(255, 255, 255));
            txt_obat.setForeground(new java.awt.Color(97, 103, 122));
            txt_obat.setLabelText("Obat");
            jPanel1.add(txt_obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 290, -1));

            textarea.setBackground(new java.awt.Color(255, 255, 255));
            textarea.setForeground(new java.awt.Color(130, 130, 130));
            textarea.setLabelText("Pencegahan");

            txt_pencegahan.setBackground(new java.awt.Color(255, 255, 255));
            txt_pencegahan.setColumns(20);
            txt_pencegahan.setForeground(new java.awt.Color(97, 103, 122));
            txt_pencegahan.setRows(5);
            textarea.setViewportView(txt_pencegahan);

            jPanel1.add(textarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 290, 80));

            textAreaScroll3.setLabelText("Gejala");

            txt_gejala.setBackground(new java.awt.Color(255, 255, 255));
            txt_gejala.setColumns(20);
            txt_gejala.setForeground(new java.awt.Color(97, 103, 122));
            txt_gejala.setRows(5);
            textAreaScroll3.setViewportView(txt_gejala);

            jPanel1.add(textAreaScroll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 290, 80));

            txt_kodepenyakit.setEditable(false);
            txt_kodepenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_kodepenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_kodepenyakit.setLabelText("Kode Penyakit");
            jPanel1.add(txt_kodepenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 290, -1));

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
                        new TambahDataKurir().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private swing.ButtonGradient btn_ubah;
      private javax.swing.JPanel jPanel1;
      private textarea.TextAreaScroll textAreaScroll1;
      private textarea.TextAreaScroll textAreaScroll3;
      public textarea.TextAreaScroll textarea;
      public textarea.TextArea txt_deskripsi;
      public textarea.TextArea txt_gejala;
      public textfield.TextField txt_kodepenyakit;
      public textfield.TextField txt_namapenyakit;
      public textfield.TextField txt_obat;
      public textarea.TextArea txt_pencegahan;
      // End of variables declaration//GEN-END:variables
}
