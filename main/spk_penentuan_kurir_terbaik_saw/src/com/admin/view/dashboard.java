package com.admin.view;

import com.admin.controler.ProsesPerhitungan;
import com.model.Model_Card;
import com.swing.ScrollBar;
import java.awt.Color;
import javaswingdev.chart.PieChart;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class dashboard extends javax.swing.JPanel {

      public dashboard() {
          
            initComponents();        
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/icon/1.png")), "NULL",  0));
            card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/icon/1.png")), "NULL", 0));
            card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/icon/1.png")), "NULL", 0));
            card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/icon/1.png")), "NULL", 0));

            //  add row table
            spTable.setVerticalScrollBar(new ScrollBar());
            spTable.getVerticalScrollBar().setBackground(Color.WHITE);
            spTable.getViewport().setBackground(Color.WHITE);
            JPanel p = new JPanel();
            p.setBackground(Color.WHITE);
            spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
            pieChart();
      }
    
      public void pieChart () {
            pie_chart.setChartType(PieChart.PeiChartType.DONUT_CHART);
            // Ambil data dari database

      }
         
      public void refreshDashboard () {

      }


    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panel = new javax.swing.JLayeredPane();
            card1 = new com.component.Card();
            card2 = new com.component.Card();
            card3 = new com.component.Card();
            card4 = new com.component.Card();
            panelBorder1 = new com.swing.PanelBorder();
            pie_chart = new javaswingdev.chart.PieChart();
            jLabel3 = new javax.swing.JLabel();
            panelBorder2 = new com.swing.PanelBorder();
            jLabel2 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_dashboard = new com.swing.Table();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

            card1.setColor1(new java.awt.Color(142, 142, 250));
            card1.setColor2(new java.awt.Color(0, 153, 0));
            panel.add(card1);

            card2.setColor1(new java.awt.Color(186, 107, 24));
            card2.setColor2(new java.awt.Color(167, 94, 236));
            panel.add(card2);

            card3.setColor1(new java.awt.Color(241, 208, 62));
            card3.setColor2(new java.awt.Color(0, 0, 255));
            panel.add(card3);

            card4.setColor1(new java.awt.Color(153, 0, 153));
            card4.setColor2(new java.awt.Color(211, 184, 61));
            panel.add(card4);

            add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 915, -1));

            panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            panelBorder1.add(pie_chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 430, 290));

            jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(97, 103, 122));
            jLabel3.setText("Pengirman Paket Perbulan");
            panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

            add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 450, 350));

            panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setText("Kurir Terbaik");
            panelBorder2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

            spTable.setBorder(null);

            tabel_dashboard.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tabel_dashboard);

            panelBorder2.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 280));

            add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 231, 450, 350));
      }// </editor-fold>//GEN-END:initComponents


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private com.component.Card card1;
      private com.component.Card card2;
      private com.component.Card card3;
      private com.component.Card card4;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLayeredPane panel;
      private com.swing.PanelBorder panelBorder1;
      private com.swing.PanelBorder panelBorder2;
      public javaswingdev.chart.PieChart pie_chart;
      private javax.swing.JScrollPane spTable;
      public com.swing.Table tabel_dashboard;
      // End of variables declaration//GEN-END:variables
}
