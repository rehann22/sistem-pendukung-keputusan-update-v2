package com.admin.view;

import com.admin.controler.DataKriteria;
import com.admin.controler.DataSubKriteria;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PageDataKriteria extends javax.swing.JPanel {
      
      public PageDataKriteria() {
            initComponents();
            DataKriteria dk = new DataKriteria();
            dk.TabelKriteria(tblKriteria);
            DataSubKriteria dsk = new DataSubKriteria();
            dsk.TblSubKriteria(tblSubKriteria);
            
            TScrolPane(spTable);
            TScrolPane(spTable1);
      }
      
      private void TScrolPane(JScrollPane scroll) {
            scroll.setVerticalScrollBar(new ScrollBar());
            scroll.getVerticalScrollBar().setBackground(Color.WHITE);
            scroll.getViewport().setBackground(Color.WHITE);
            JPanel p = new JPanel();
            p.setBackground(Color.WHITE);
            scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
      }
      
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder1 = new com.swing.PanelBorder();
            refresh_sub_kriteria = new javax.swing.JLabel();
            spTable1 = new javax.swing.JScrollPane();
            tblSubKriteria = new com.swing.Table();
            btn_tambahsubk = new swing.ButtonGradient();
            btn_ubahsubk = new swing.ButtonGradient();
            btn_hapussubk = new swing.ButtonGradient();
            panelBorder = new com.swing.PanelBorder();
            refresh_kriteria = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tblKriteria = new com.swing.Table();
            btn_tambah = new swing.ButtonGradient();
            btn_ubah = new swing.ButtonGradient();
            btn_hapus = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setPreferredSize(new java.awt.Dimension(935, 880));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh_sub_kriteria.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh_sub_kriteria.setForeground(new java.awt.Color(97, 103, 122));
            refresh_sub_kriteria.setText("Data Sub Kriteria ");
            refresh_sub_kriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh_sub_kriteria.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refresh_sub_kriteriaMouseClicked(evt);
                  }
            });
            panelBorder1.add(refresh_sub_kriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

            spTable1.setBorder(null);

            tblSubKriteria.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable1.setViewportView(tblSubKriteria);

            panelBorder1.add(spTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 850, 370));

            btn_tambahsubk.setText("Tambah");
            btn_tambahsubk.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambahsubk.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambahsubk.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambahsubkActionPerformed(evt);
                  }
            });
            panelBorder1.add(btn_tambahsubk, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 90, 30));

            btn_ubahsubk.setText("Ubah");
            btn_ubahsubk.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubahsubk.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubahsubk.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahsubkActionPerformed(evt);
                  }
            });
            panelBorder1.add(btn_ubahsubk, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 90, 30));

            btn_hapussubk.setText("Hapus");
            btn_hapussubk.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapussubk.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapussubk.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapussubkActionPerformed(evt);
                  }
            });
            panelBorder1.add(btn_hapussubk, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 90, 30));

            add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 890, 470));

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh_kriteria.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh_kriteria.setForeground(new java.awt.Color(97, 103, 122));
            refresh_kriteria.setText("Data Kriteria ");
            refresh_kriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh_kriteria.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refresh_kriteriaMouseClicked(evt);
                  }
            });
            panelBorder.add(refresh_kriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

            spTable.setBorder(null);

            tblKriteria.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tblKriteria);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 850, 250));

            btn_tambah.setText("Tambah");
            btn_tambah.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 90, 30));

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 90, 30));

            btn_hapus.setText("Hapus");
            btn_hapus.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapusActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 90, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 890, 340));
      }// </editor-fold>//GEN-END:initComponents

      private void refresh_kriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_kriteriaMouseClicked
            DataKriteria dk = new DataKriteria();
            dk.TabelKriteria(tblKriteria);
      }//GEN-LAST:event_refresh_kriteriaMouseClicked

      private void refresh_sub_kriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_sub_kriteriaMouseClicked
            DataSubKriteria dsk = new DataSubKriteria();
            dsk.TblSubKriteria(tblSubKriteria);
      }//GEN-LAST:event_refresh_sub_kriteriaMouseClicked

      private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
            KelolaKriteria kk = new KelolaKriteria();
            kk.setVisible(true);
      }//GEN-LAST:event_btn_tambahActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
            KelolaKriteria kk = new KelolaKriteria();
            DataKriteria dk = new DataKriteria();
            dk.FormEditKriteria(tblKriteria, kk.txt_kode_kriteria, kk.txt_namakriteria, kk.txt_bobotkriteria, kk.cbb_jeniskriteria);
            kk.setVisible(true);
      }//GEN-LAST:event_btn_ubahActionPerformed

      private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
            DataKriteria dk = new DataKriteria();
            dk.HapusDataKriteria(tblKriteria);
      }//GEN-LAST:event_btn_hapusActionPerformed

      private void btn_tambahsubkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahsubkActionPerformed
            KelolaSubKriteria ksk = new KelolaSubKriteria();
            ksk.setVisible(true);
      }//GEN-LAST:event_btn_tambahsubkActionPerformed

      private void btn_ubahsubkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahsubkActionPerformed
            KelolaSubKriteria ksk = new KelolaSubKriteria();
            DataSubKriteria dsk = new DataSubKriteria();
            dsk.FormEditSubKriteria(tblSubKriteria, ksk.cbb_jeniskriteria, ksk.txt_keterangan, ksk.txt_nilai, ksk.txt_kodesubk);
            ksk.setVisible(true);
      }//GEN-LAST:event_btn_ubahsubkActionPerformed

      private void btn_hapussubkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapussubkActionPerformed
            DataSubKriteria dsk = new DataSubKriteria();
            dsk.HapusData(tblSubKriteria);
      }//GEN-LAST:event_btn_hapussubkActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_hapus;
      private swing.ButtonGradient btn_hapussubk;
      private swing.ButtonGradient btn_tambah;
      private swing.ButtonGradient btn_tambahsubk;
      private swing.ButtonGradient btn_ubah;
      private swing.ButtonGradient btn_ubahsubk;
      private com.swing.PanelBorder panelBorder;
      private com.swing.PanelBorder panelBorder1;
      private javax.swing.JLabel refresh_kriteria;
      private javax.swing.JLabel refresh_sub_kriteria;
      private javax.swing.JScrollPane spTable;
      private javax.swing.JScrollPane spTable1;
      public com.swing.Table tblKriteria;
      public com.swing.Table tblSubKriteria;
      // End of variables declaration//GEN-END:variables
}
