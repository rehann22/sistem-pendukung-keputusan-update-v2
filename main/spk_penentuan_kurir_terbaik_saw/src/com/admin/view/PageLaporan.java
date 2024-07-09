package com.admin.view;

import com.admin.controler.Report;
import com.formdev.flatlaf.extras.FlatSVGIcon;

public class PageLaporan extends javax.swing.JPanel {

      public PageLaporan() {
            initComponents();
            penilaianAlter.setIcon(new FlatSVGIcon("com/icon/Report Analysis 1.svg", penilaianAlter.getWidth(), penilaianAlter.getHeight()));
            dataPeringkat.setIcon(new FlatSVGIcon("com/icon/Report Analysis 2.svg", dataPeringkat.getWidth(), dataPeringkat.getHeight()));
      }

    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.swing.PanelBorder();
            dataPeringkat = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            penilaianAlter = new javax.swing.JLabel();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            dataPeringkat.setBackground(new java.awt.Color(204, 204, 255));
            dataPeringkat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            dataPeringkat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            dataPeringkat.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        dataPeringkatMouseClicked(evt);
                  }
            });
            panelBorder.add(dataPeringkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 190, 200));

            jLabel4.setForeground(new java.awt.Color(97, 103, 122));
            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel4.setText("Peringkat");
            panelBorder.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 160, 30));

            jLabel5.setForeground(new java.awt.Color(97, 103, 122));
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setText("Penilaian Alternatif");
            panelBorder.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 160, 30));

            penilaianAlter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            penilaianAlter.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        penilaianAlterMouseClicked(evt);
                  }
            });
            panelBorder.add(penilaianAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 170, 190));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void dataPeringkatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPeringkatMouseClicked
            PageProsesPerhitungan tab = new PageProsesPerhitungan(); // Inisialisasi atau ambil JTable Anda
            // Inisialisasi JTable dengan data atau model yang sesuai
            Report reportGenerator = new Report();
            reportGenerator.ReportPeringkat(tab.tblPerankingan);

      }//GEN-LAST:event_dataPeringkatMouseClicked

      private void penilaianAlterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penilaianAlterMouseClicked
            Report data = new Report();
            data.ReportPenilaianKurir();
      }//GEN-LAST:event_penilaianAlterMouseClicked


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel dataPeringkat;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel5;
      private com.swing.PanelBorder panelBorder;
      private javax.swing.JLabel penilaianAlter;
      // End of variables declaration//GEN-END:variables
}
