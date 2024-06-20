package com.admin.view;

import com.admin.controler.PenilaianKurir;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PagePenilaianKurir extends javax.swing.JPanel {

    public PagePenilaianKurir() {
            initComponents();
            PenilaianKurir pnl = new PenilaianKurir();
            pnl.TabelPenilaian(tblPenilaianKurir);

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
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tblPenilaianKurir = new com.swing.Table();
            btn_hapus = new swing.ButtonGradient();
            btn_Tambah = new swing.ButtonGradient();
            btn_ubah = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Penilaian Alternatif");
            jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel1MouseClicked(evt);
                  }
            });
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, -1));

            spTable.setBorder(null);

            tblPenilaianKurir.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tblPenilaianKurir);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 480));

            btn_hapus.setText("Hapus");
            btn_hapus.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapusActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 90, 30));

            btn_Tambah.setText("Tambah");
            btn_Tambah.setColor1(new java.awt.Color(35, 20, 226));
            btn_Tambah.setColor2(new java.awt.Color(209, 18, 235));
            btn_Tambah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_TambahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 90, 30));

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 90, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahActionPerformed
            FormPenilaian data = new FormPenilaian();
            data.setVisible(true);
      }//GEN-LAST:event_btn_TambahActionPerformed

      private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed

      }//GEN-LAST:event_btn_hapusActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_btn_ubahActionPerformed

      private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
            PenilaianKurir pnl = new PenilaianKurir();
            pnl.TabelPenilaian(tblPenilaianKurir);
      }//GEN-LAST:event_jLabel1MouseClicked


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_Tambah;
      private swing.ButtonGradient btn_hapus;
      private swing.ButtonGradient btn_ubah;
      private javax.swing.JLabel jLabel1;
      private com.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      public com.swing.Table tblPenilaianKurir;
      // End of variables declaration//GEN-END:variables
}
