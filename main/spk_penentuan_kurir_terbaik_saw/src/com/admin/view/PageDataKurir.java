package com.admin.view;

import com.admin.controler.DataKurir;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PageDataKurir extends javax.swing.JPanel {

    public PageDataKurir() {
      initComponents();
      DataKurir data  = new DataKurir();
      data.TabelKurir(tblKurir);

      //  add row table
      spTable.setVerticalScrollBar(new ScrollBar());
      spTable.getVerticalScrollBar().setBackground(Color.WHITE);
      spTable.getViewport().setBackground(Color.WHITE);
      JPanel p = new JPanel();
      p.setBackground(Color.WHITE);
      spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);     
    }
    

    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.swing.PanelBorder();
            refresh = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tblKurir = new com.swing.Table();
            btn_tambah = new swing.ButtonGradient();
            btn_hapus = new swing.ButtonGradient();
            btn_ubah = new swing.ButtonGradient();
            txt_cari = new textfield.TextField();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh.setForeground(new java.awt.Color(97, 103, 122));
            refresh.setText("Data Alternatif");
            refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refreshMouseClicked(evt);
                  }
            });
            panelBorder.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

            spTable.setBorder(null);

            tblKurir.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable.setViewportView(tblKurir);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 480));

            btn_tambah.setText("Tambah");
            btn_tambah.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 90, 30));

            btn_hapus.setText("Hapus");
            btn_hapus.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapusActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 90, 30));

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 90, 30));

            txt_cari.setBackground(new java.awt.Color(255, 255, 255));
            txt_cari.setForeground(new java.awt.Color(97, 103, 122));
            txt_cari.setLabelText("Cari");
            txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyPressed(java.awt.event.KeyEvent evt) {
                        txt_cariKeyPressed(evt);
                  }
            });
            panelBorder.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 10, 120, -1));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
            FormDataKurir data = new FormDataKurir();
            data.setVisible(true);
            
      }//GEN-LAST:event_btn_tambahActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
            DataKurir data = new DataKurir();
            FormDataKurir add = new FormDataKurir();
            add.setVisible(true);
            data.TampilFormEditKurir(tblKurir, add.txtIdKurir, add.txtNamaKurir, add.txtAlamat, add.txtEmail, add.txtNoTelp, add.tglBergabung);
      }//GEN-LAST:event_btn_ubahActionPerformed

      private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
            DataKurir data = new DataKurir();  
            data.HapusDataKurir(tblKurir);
      }//GEN-LAST:event_btn_hapusActionPerformed

      private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
            DataKurir data  = new DataKurir();
            data.TabelKurir(tblKurir);
            txt_cari.setText("");
      }//GEN-LAST:event_refreshMouseClicked

      private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
            DataKurir data  = new DataKurir();
            data.CariDataAlt(txt_cari, tblKurir);
      }//GEN-LAST:event_txt_cariKeyPressed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_hapus;
      private swing.ButtonGradient btn_tambah;
      private swing.ButtonGradient btn_ubah;
      private com.swing.PanelBorder panelBorder;
      private javax.swing.JLabel refresh;
      private javax.swing.JScrollPane spTable;
      public com.swing.Table tblKurir;
      private textfield.TextField txt_cari;
      // End of variables declaration//GEN-END:variables
}
