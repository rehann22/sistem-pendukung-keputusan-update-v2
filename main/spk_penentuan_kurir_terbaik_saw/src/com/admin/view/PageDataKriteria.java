package com.admin.view;

import com.admin.controler.DataKriteria;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PageDataKriteria extends javax.swing.JPanel {

      public PageDataKriteria() {
            initComponents();
            DataKriteria data = new DataKriteria();
            data.TabelKriteria(tblKriteria);
            data.TblSubKriteria(tblSubKriteria);
            
            TScrolPane(spTable);
            TScrolPane(spTable1);
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

            panelBorder1 = new com.swing.PanelBorder();
            jLabel2 = new javax.swing.JLabel();
            spTable1 = new javax.swing.JScrollPane();
            tblSubKriteria = new com.swing.Table();
            panelBorder = new com.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tblKriteria = new com.swing.Table();

            setBackground(new java.awt.Color(242, 242, 242));
            setPreferredSize(new java.awt.Dimension(935, 880));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setText("Data Sub Kriteria ");
            jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel2MouseClicked(evt);
                  }
            });
            panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

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

            add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 890, 470));

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Data Kriteria ");
            jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel1MouseClicked(evt);
                  }
            });
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 40));

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

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 890, 340));
      }// </editor-fold>//GEN-END:initComponents

      private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
            DataKriteria data = new DataKriteria();
            data.TabelKriteria(tblKriteria);
      }//GEN-LAST:event_jLabel1MouseClicked

      private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
            // TODO add your handling code here:
      }//GEN-LAST:event_jLabel2MouseClicked


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel2;
      private com.swing.PanelBorder panelBorder;
      private com.swing.PanelBorder panelBorder1;
      private javax.swing.JScrollPane spTable;
      private javax.swing.JScrollPane spTable1;
      public com.swing.Table tblKriteria;
      public com.swing.Table tblSubKriteria;
      // End of variables declaration//GEN-END:variables
}
