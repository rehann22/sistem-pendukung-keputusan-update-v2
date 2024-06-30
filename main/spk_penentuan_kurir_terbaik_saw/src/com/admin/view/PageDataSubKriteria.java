package com.admin.view;

import com.admin.controler.DataKriteria;
import com.admin.controler.DataSubKriteria;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PageDataSubKriteria extends javax.swing.JPanel {

      public PageDataSubKriteria() {
            initComponents();
            DataSubKriteria data = new DataSubKriteria();
            data.TblSubKriteria(tbl_sub_c1, "c01");
            data.TblSubKriteria(tbl_sub_c2, "c02");
            data.TblSubKriteria(tbl_sub_c3, "c03");
            data.TblSubKriteria(tbl_sub_c4, "c04");

            TScrolPane(spTable);
            TScrolPane(spTable1);
            TScrolPane(spTable2);
            TScrolPane(spTable3);
      }
    
      private void TScrolPane (JScrollPane scroll) {
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

            panelBorder = new com.swing.PanelBorder();
            refresh_c01 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tbl_sub_c1 = new com.swing.Table();
            tambah_c01 = new swing.ButtonGradient();
            hapus_c01 = new swing.ButtonGradient();
            panelBorder1 = new com.swing.PanelBorder();
            refresh_c04 = new javax.swing.JLabel();
            spTable1 = new javax.swing.JScrollPane();
            tbl_sub_c4 = new com.swing.Table();
            tambah_c04 = new swing.ButtonGradient();
            hapus_c04 = new swing.ButtonGradient();
            panelBorder2 = new com.swing.PanelBorder();
            refresh_c02 = new javax.swing.JLabel();
            spTable2 = new javax.swing.JScrollPane();
            tbl_sub_c2 = new com.swing.Table();
            tambah_c02 = new swing.ButtonGradient();
            hapus_c02 = new swing.ButtonGradient();
            panelBorder3 = new com.swing.PanelBorder();
            refresh_c03 = new javax.swing.JLabel();
            spTable3 = new javax.swing.JScrollPane();
            tbl_sub_c3 = new com.swing.Table();
            tambah_c03 = new swing.ButtonGradient();
            hapus_c03 = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setPreferredSize(new java.awt.Dimension(920, 1340));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh_c01.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh_c01.setForeground(new java.awt.Color(97, 103, 122));
            refresh_c01.setText("Sub Kriteria C01");
            refresh_c01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh_c01.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refresh_c01MouseClicked(evt);
                  }
            });
            panelBorder.add(refresh_c01, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

            spTable.setBorder(null);

            tbl_sub_c1.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tbl_sub_c1);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 220));

            tambah_c01.setText("Tambah");
            tambah_c01.setColor1(new java.awt.Color(35, 20, 226));
            tambah_c01.setColor2(new java.awt.Color(209, 18, 235));
            tambah_c01.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        tambah_c01ActionPerformed(evt);
                  }
            });
            panelBorder.add(tambah_c01, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            hapus_c01.setText("Hapus");
            hapus_c01.setColor1(new java.awt.Color(35, 20, 226));
            hapus_c01.setColor2(new java.awt.Color(209, 18, 235));
            hapus_c01.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        hapus_c01ActionPerformed(evt);
                  }
            });
            panelBorder.add(hapus_c01, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 900, 310));

            panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder1.setPreferredSize(new java.awt.Dimension(880, 290));
            panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh_c04.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh_c04.setForeground(new java.awt.Color(97, 103, 122));
            refresh_c04.setText("Sub Kriteria C04");
            refresh_c04.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh_c04.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refresh_c04MouseClicked(evt);
                  }
            });
            panelBorder1.add(refresh_c04, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

            spTable1.setBorder(null);

            tbl_sub_c4.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable1.setViewportView(tbl_sub_c4);

            panelBorder1.add(spTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 220));

            tambah_c04.setText("Tambah");
            tambah_c04.setColor1(new java.awt.Color(35, 20, 226));
            tambah_c04.setColor2(new java.awt.Color(209, 18, 235));
            tambah_c04.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        tambah_c04ActionPerformed(evt);
                  }
            });
            panelBorder1.add(tambah_c04, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            hapus_c04.setText("Hapus");
            hapus_c04.setColor1(new java.awt.Color(35, 20, 226));
            hapus_c04.setColor2(new java.awt.Color(209, 18, 235));
            hapus_c04.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        hapus_c04ActionPerformed(evt);
                  }
            });
            panelBorder1.add(hapus_c04, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1000, 900, 310));

            panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh_c02.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh_c02.setForeground(new java.awt.Color(97, 103, 122));
            refresh_c02.setText("Sub Kriteria C02");
            refresh_c02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh_c02.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refresh_c02MouseClicked(evt);
                  }
            });
            panelBorder2.add(refresh_c02, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

            spTable2.setBorder(null);

            tbl_sub_c2.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable2.setViewportView(tbl_sub_c2);

            panelBorder2.add(spTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 220));

            tambah_c02.setText("Tambah");
            tambah_c02.setColor1(new java.awt.Color(35, 20, 226));
            tambah_c02.setColor2(new java.awt.Color(209, 18, 235));
            tambah_c02.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        tambah_c02ActionPerformed(evt);
                  }
            });
            panelBorder2.add(tambah_c02, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            hapus_c02.setText("Hapus");
            hapus_c02.setColor1(new java.awt.Color(35, 20, 226));
            hapus_c02.setColor2(new java.awt.Color(209, 18, 235));
            hapus_c02.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        hapus_c02ActionPerformed(evt);
                  }
            });
            panelBorder2.add(hapus_c02, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 900, 310));

            panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh_c03.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh_c03.setForeground(new java.awt.Color(97, 103, 122));
            refresh_c03.setText("Sub Kriteria C03");
            refresh_c03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh_c03.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refresh_c03MouseClicked(evt);
                  }
            });
            panelBorder3.add(refresh_c03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

            spTable3.setBorder(null);

            tbl_sub_c3.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable3.setViewportView(tbl_sub_c3);

            panelBorder3.add(spTable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 220));

            tambah_c03.setText("Tambah");
            tambah_c03.setColor1(new java.awt.Color(35, 20, 226));
            tambah_c03.setColor2(new java.awt.Color(209, 18, 235));
            tambah_c03.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        tambah_c03ActionPerformed(evt);
                  }
            });
            panelBorder3.add(tambah_c03, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            hapus_c03.setText("Hapus");
            hapus_c03.setColor1(new java.awt.Color(35, 20, 226));
            hapus_c03.setColor2(new java.awt.Color(209, 18, 235));
            hapus_c03.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        hapus_c03ActionPerformed(evt);
                  }
            });
            panelBorder3.add(hapus_c03, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 900, 310));
      }// </editor-fold>//GEN-END:initComponents

      private void tambah_c01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_c01ActionPerformed
            FormSubKriteria form = new FormSubKriteria();
            form.setVisible(true);
            
      }//GEN-LAST:event_tambah_c01ActionPerformed

      private void hapus_c01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_c01ActionPerformed
            DataSubKriteria method = new DataSubKriteria();
            method.HapusData(tbl_sub_c1);
            method.TblSubKriteria(tbl_sub_c1, "c01");
      }//GEN-LAST:event_hapus_c01ActionPerformed

      private void refresh_c01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_c01MouseClicked
            DataSubKriteria method = new DataSubKriteria();
            method.TblSubKriteria(tbl_sub_c1, "c01");
      }//GEN-LAST:event_refresh_c01MouseClicked

      private void refresh_c04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_c04MouseClicked
            DataSubKriteria method = new DataSubKriteria();
            method.TblSubKriteria(tbl_sub_c4, "c04");
      }//GEN-LAST:event_refresh_c04MouseClicked

      private void tambah_c04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_c04ActionPerformed
            FormSubKriteria form = new FormSubKriteria();
            form.setVisible(true);
      }//GEN-LAST:event_tambah_c04ActionPerformed

      private void hapus_c04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_c04ActionPerformed
            DataSubKriteria method = new DataSubKriteria();
            method.HapusData(tbl_sub_c4);
            method.TblSubKriteria(tbl_sub_c4, "c04");
      }//GEN-LAST:event_hapus_c04ActionPerformed

      private void refresh_c02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_c02MouseClicked
            DataSubKriteria method = new DataSubKriteria();
            method.TblSubKriteria(tbl_sub_c2, "c02");
      }//GEN-LAST:event_refresh_c02MouseClicked

      private void tambah_c02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_c02ActionPerformed
            FormSubKriteria form = new FormSubKriteria();
            form.setVisible(true);
      }//GEN-LAST:event_tambah_c02ActionPerformed

      private void hapus_c02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_c02ActionPerformed
            DataSubKriteria method = new DataSubKriteria();
            method.HapusData(tbl_sub_c2);
            method.TblSubKriteria(tbl_sub_c2, "c02");
      }//GEN-LAST:event_hapus_c02ActionPerformed

      private void refresh_c03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_c03MouseClicked
            DataSubKriteria method = new DataSubKriteria();
            method.TblSubKriteria(tbl_sub_c3, "c03");
      }//GEN-LAST:event_refresh_c03MouseClicked

      private void tambah_c03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_c03ActionPerformed
            FormSubKriteria form = new FormSubKriteria();
            form.setVisible(true);
      }//GEN-LAST:event_tambah_c03ActionPerformed

      private void hapus_c03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_c03ActionPerformed
            DataSubKriteria method = new DataSubKriteria();
            method.HapusData(tbl_sub_c3); 
            method.TblSubKriteria(tbl_sub_c3, "c03");
      }//GEN-LAST:event_hapus_c03ActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient hapus_c01;
      private swing.ButtonGradient hapus_c02;
      private swing.ButtonGradient hapus_c03;
      private swing.ButtonGradient hapus_c04;
      private com.swing.PanelBorder panelBorder;
      private com.swing.PanelBorder panelBorder1;
      private com.swing.PanelBorder panelBorder2;
      private com.swing.PanelBorder panelBorder3;
      private javax.swing.JLabel refresh_c01;
      private javax.swing.JLabel refresh_c02;
      private javax.swing.JLabel refresh_c03;
      private javax.swing.JLabel refresh_c04;
      private javax.swing.JScrollPane spTable;
      private javax.swing.JScrollPane spTable1;
      private javax.swing.JScrollPane spTable2;
      private javax.swing.JScrollPane spTable3;
      private swing.ButtonGradient tambah_c01;
      private swing.ButtonGradient tambah_c02;
      private swing.ButtonGradient tambah_c03;
      private swing.ButtonGradient tambah_c04;
      public com.swing.Table tbl_sub_c1;
      public com.swing.Table tbl_sub_c2;
      public com.swing.Table tbl_sub_c3;
      public com.swing.Table tbl_sub_c4;
      // End of variables declaration//GEN-END:variables
}
