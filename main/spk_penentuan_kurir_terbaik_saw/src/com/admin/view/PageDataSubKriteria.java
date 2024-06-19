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
          data.Criteria1(tbl_sub_c1);
          data.Criteria2(tbl_sub_c2);
          data.Criteria3(tbl_sub_c3);
          data.Criteria4(tbl_sub_c4);
          
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
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tbl_sub_c1 = new com.swing.Table();
            btn_tambah = new swing.ButtonGradient();
            btn_hapus = new swing.ButtonGradient();
            btn_ubah = new swing.ButtonGradient();
            panelBorder1 = new com.swing.PanelBorder();
            jLabel2 = new javax.swing.JLabel();
            spTable1 = new javax.swing.JScrollPane();
            tbl_sub_c4 = new com.swing.Table();
            btn_tambah1 = new swing.ButtonGradient();
            btn_hapus1 = new swing.ButtonGradient();
            btn_ubah1 = new swing.ButtonGradient();
            panelBorder2 = new com.swing.PanelBorder();
            jLabel3 = new javax.swing.JLabel();
            spTable2 = new javax.swing.JScrollPane();
            tbl_sub_c2 = new com.swing.Table();
            btn_tambah2 = new swing.ButtonGradient();
            btn_hapus2 = new swing.ButtonGradient();
            btn_ubah2 = new swing.ButtonGradient();
            panelBorder3 = new com.swing.PanelBorder();
            jLabel4 = new javax.swing.JLabel();
            spTable3 = new javax.swing.JScrollPane();
            tbl_sub_c3 = new com.swing.Table();
            btn_tambah3 = new swing.ButtonGradient();
            btn_hapus3 = new swing.ButtonGradient();
            btn_ubah3 = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setPreferredSize(new java.awt.Dimension(920, 1340));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Sub Kriteria C1");
            jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel1MouseClicked(evt);
                  }
            });
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

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

            btn_tambah.setText("Tambah");
            btn_tambah.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 90, 30));

            btn_hapus.setText("Hapus");
            btn_hapus.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapusActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 900, 310));

            panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder1.setPreferredSize(new java.awt.Dimension(880, 290));
            panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setText("Sub Kriteria C4");
            jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel2MouseClicked(evt);
                  }
            });
            panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

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

            btn_tambah1.setText("Tambah");
            btn_tambah1.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah1.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambah1ActionPerformed(evt);
                  }
            });
            panelBorder1.add(btn_tambah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 90, 30));

            btn_hapus1.setText("Hapus");
            btn_hapus1.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus1.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapus1ActionPerformed(evt);
                  }
            });
            panelBorder1.add(btn_hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            btn_ubah1.setText("Ubah");
            btn_ubah1.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah1.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubah1ActionPerformed(evt);
                  }
            });
            panelBorder1.add(btn_ubah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1000, 900, 310));

            panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(97, 103, 122));
            jLabel3.setText("Sub Kriteria C2");
            jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel3MouseClicked(evt);
                  }
            });
            panelBorder2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

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

            btn_tambah2.setText("Tambah");
            btn_tambah2.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah2.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah2.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambah2ActionPerformed(evt);
                  }
            });
            panelBorder2.add(btn_tambah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 90, 30));

            btn_hapus2.setText("Hapus");
            btn_hapus2.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus2.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus2.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapus2ActionPerformed(evt);
                  }
            });
            panelBorder2.add(btn_hapus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            btn_ubah2.setText("Ubah");
            btn_ubah2.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah2.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah2.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubah2ActionPerformed(evt);
                  }
            });
            panelBorder2.add(btn_ubah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 900, 310));

            panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(97, 103, 122));
            jLabel4.setText("Sub Kriteria C3");
            jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel4MouseClicked(evt);
                  }
            });
            panelBorder3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

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

            btn_tambah3.setText("Tambah");
            btn_tambah3.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah3.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah3.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambah3ActionPerformed(evt);
                  }
            });
            panelBorder3.add(btn_tambah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 90, 30));

            btn_hapus3.setText("Hapus");
            btn_hapus3.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus3.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus3.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapus3ActionPerformed(evt);
                  }
            });
            panelBorder3.add(btn_hapus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

            btn_ubah3.setText("Ubah");
            btn_ubah3.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah3.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah3.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubah3ActionPerformed(evt);
                  }
            });
            panelBorder3.add(btn_ubah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

            add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 900, 310));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed

      }//GEN-LAST:event_btn_tambahActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
         

      }//GEN-LAST:event_btn_ubahActionPerformed

      private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed

      }//GEN-LAST:event_btn_hapusActionPerformed

      private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
  
      }//GEN-LAST:event_jLabel1MouseClicked

      private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

      }//GEN-LAST:event_jLabel2MouseClicked

      private void btn_tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah1ActionPerformed

      }//GEN-LAST:event_btn_tambah1ActionPerformed

      private void btn_hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus1ActionPerformed

      }//GEN-LAST:event_btn_hapus1ActionPerformed

      private void btn_ubah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah1ActionPerformed

      }//GEN-LAST:event_btn_ubah1ActionPerformed

      private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

      }//GEN-LAST:event_jLabel3MouseClicked

      private void btn_tambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah2ActionPerformed

      }//GEN-LAST:event_btn_tambah2ActionPerformed

      private void btn_hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus2ActionPerformed

      }//GEN-LAST:event_btn_hapus2ActionPerformed

      private void btn_ubah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah2ActionPerformed
    
      }//GEN-LAST:event_btn_ubah2ActionPerformed

      private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
     
      }//GEN-LAST:event_jLabel4MouseClicked

      private void btn_tambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah3ActionPerformed
 
      }//GEN-LAST:event_btn_tambah3ActionPerformed

      private void btn_hapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus3ActionPerformed
            
      }//GEN-LAST:event_btn_hapus3ActionPerformed

      private void btn_ubah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah3ActionPerformed
            
      }//GEN-LAST:event_btn_ubah3ActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_hapus;
      private swing.ButtonGradient btn_hapus1;
      private swing.ButtonGradient btn_hapus2;
      private swing.ButtonGradient btn_hapus3;
      private swing.ButtonGradient btn_tambah;
      private swing.ButtonGradient btn_tambah1;
      private swing.ButtonGradient btn_tambah2;
      private swing.ButtonGradient btn_tambah3;
      private swing.ButtonGradient btn_ubah;
      private swing.ButtonGradient btn_ubah1;
      private swing.ButtonGradient btn_ubah2;
      private swing.ButtonGradient btn_ubah3;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private com.swing.PanelBorder panelBorder;
      private com.swing.PanelBorder panelBorder1;
      private com.swing.PanelBorder panelBorder2;
      private com.swing.PanelBorder panelBorder3;
      private javax.swing.JScrollPane spTable;
      private javax.swing.JScrollPane spTable1;
      private javax.swing.JScrollPane spTable2;
      private javax.swing.JScrollPane spTable3;
      public com.swing.Table tbl_sub_c1;
      public com.swing.Table tbl_sub_c2;
      public com.swing.Table tbl_sub_c3;
      public com.swing.Table tbl_sub_c4;
      // End of variables declaration//GEN-END:variables
}
