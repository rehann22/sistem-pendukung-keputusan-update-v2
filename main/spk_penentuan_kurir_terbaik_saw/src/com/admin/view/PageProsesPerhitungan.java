package com.admin.view;

import com.admin.controler.PenilaianKurir;
import com.admin.controler.ProsesPerhitungan;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PageProsesPerhitungan extends javax.swing.JPanel {

      public PageProsesPerhitungan() {
              initComponents();
              PenilaianKurir pnl = new PenilaianKurir();
              pnl.TabelPenilaian(tblPenilaianAlternatif);

              ProsesPerhitungan data = new ProsesPerhitungan();
              data.DataPenilaianAlternatif(tblDataPenilaianAlternatif);
              data.HitungPenilaianAlternatif(tblMatrixNormalisasi);
              data.HasilNormalisasi(tblHasilPembobotan, tblPerankingan);
              
              tblPenilaianAlternatif.getColumnModel().getColumn(0).setPreferredWidth(0); 
              tblDataPenilaianAlternatif.getColumnModel().getColumn(0).setPreferredWidth(0); 
              tblMatrixNormalisasi.getColumnModel().getColumn(0).setPreferredWidth(0); 
              tblPerankingan.getColumnModel().getColumn(0).setPreferredWidth(0); 
              tblHasilPembobotan.getColumnModel().getColumn(0).setPreferredWidth(0); 
              
              TScrolPane(spTable1);
              TScrolPane(spTable2);
              TScrolPane(spTable4);
              TScrolPane(spTable5);
              TScrolPane(spTable6);
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
            spTable1 = new javax.swing.JScrollPane();
            tblPenilaianAlternatif = new com.swing.Table();
            jLabel2 = new javax.swing.JLabel();
            panelBorder3 = new com.swing.PanelBorder();
            spTable4 = new javax.swing.JScrollPane();
            tblPerankingan = new com.swing.Table();
            jLabel5 = new javax.swing.JLabel();
            panelBorder2 = new com.swing.PanelBorder();
            spTable2 = new javax.swing.JScrollPane();
            tblDataPenilaianAlternatif = new com.swing.Table();
            jLabel3 = new javax.swing.JLabel();
            panelBorder5 = new com.swing.PanelBorder();
            spTable6 = new javax.swing.JScrollPane();
            tblHasilPembobotan = new com.swing.Table();
            jLabel7 = new javax.swing.JLabel();
            panelBorder4 = new com.swing.PanelBorder();
            spTable5 = new javax.swing.JScrollPane();
            tblMatrixNormalisasi = new com.swing.Table();
            jLabel6 = new javax.swing.JLabel();

            setBackground(new java.awt.Color(242, 242, 242));
            setPreferredSize(new java.awt.Dimension(900, 2325));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setPreferredSize(new java.awt.Dimension(870, 460));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable1.setBorder(null);

            tblPenilaianAlternatif.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable1.setViewportView(tblPenilaianAlternatif);

            panelBorder.add(spTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setText("Penilaian Alternatif");
            panelBorder.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, -1));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 900, 460));

            panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable4.setBorder(null);

            tblPerankingan.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable4.setViewportView(tblPerankingan);

            panelBorder3.add(spTable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 280));

            jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(97, 103, 122));
            jLabel5.setText("Perankingan");
            panelBorder3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, -1));

            add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1930, 900, 370));

            panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable2.setBorder(null);

            tblDataPenilaianAlternatif.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable2.setViewportView(tblDataPenilaianAlternatif);

            panelBorder2.add(spTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(97, 103, 122));
            jLabel3.setText("Nilai Setiap Alternatif");
            panelBorder2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

            add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 900, 460));

            panelBorder5.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable6.setBorder(null);

            tblHasilPembobotan.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable6.setViewportView(tblHasilPembobotan);

            panelBorder5.add(spTable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(97, 103, 122));
            jLabel7.setText("Matrix Hasil Pembobotan");
            panelBorder5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 370, -1));

            add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1450, 900, 460));

            panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable5.setBorder(null);

            tblMatrixNormalisasi.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable5.setViewportView(tblMatrixNormalisasi);

            panelBorder4.add(spTable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(97, 103, 122));
            jLabel6.setText("Matrix Normalisasi");
            panelBorder4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

            add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 970, 900, 460));
      }// </editor-fold>//GEN-END:initComponents


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel5;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JLabel jLabel7;
      private com.swing.PanelBorder panelBorder;
      private com.swing.PanelBorder panelBorder2;
      private com.swing.PanelBorder panelBorder3;
      private com.swing.PanelBorder panelBorder4;
      private com.swing.PanelBorder panelBorder5;
      private javax.swing.JScrollPane spTable1;
      private javax.swing.JScrollPane spTable2;
      private javax.swing.JScrollPane spTable4;
      private javax.swing.JScrollPane spTable5;
      private javax.swing.JScrollPane spTable6;
      public com.swing.Table tblDataPenilaianAlternatif;
      public com.swing.Table tblHasilPembobotan;
      public com.swing.Table tblMatrixNormalisasi;
      public com.swing.Table tblPenilaianAlternatif;
      public com.swing.Table tblPerankingan;
      // End of variables declaration//GEN-END:variables
}
