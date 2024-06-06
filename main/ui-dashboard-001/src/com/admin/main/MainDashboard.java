package com.admin.main;
import com.admin.view.DataAdmin;
import com.admin.view.DataKriteria;
import com.admin.view.DataKurir;
import com.admin.view.Laporan;
import com.admin.view.PenilaianKurir;
import com.admin.view.ProsesPerhitungan;
import com.raven.event.EventMenuSelected;
import com.admin.view.dashboard;
import java.awt.Color;
import javaswingdev.chart.PieChart;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class MainDashboard extends javax.swing.JFrame {

    private dashboard admin_dashboard;
    private DataKurir dataKurir;
    private DataKriteria datakriteria;
    private PenilaianKurir penilaianKurir;
    private ProsesPerhitungan prosesPerhitungan;
    private Laporan laporan;
    private DataAdmin dataAdmin;

    public MainDashboard() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        admin_dashboard = new dashboard();
        dataKurir = new DataKurir();
        datakriteria = new DataKriteria();
        penilaianKurir = new PenilaianKurir();
        prosesPerhitungan = new ProsesPerhitungan();
        laporan = new Laporan();
        dataAdmin = new DataAdmin();
        menu.initMoving(MainDashboard.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                  
                  if (index == 0) {
                  setForm(admin_dashboard);
                  } else if (index == 1) {
                         setForm(dataKurir);
                  } else if (index == 2) {
                         setForm(datakriteria);
                  } else if (index == 3) {
                         setForm(penilaianKurir);
                  } else if (index == 4) {
                         setForm(prosesPerhitungan);
                  } else if (index == 5) {
                        setForm(laporan);
                  } else if (index == 6) {
                         //setForm(form_f);
                  } else if (index == 7) {
                        refreshAll();
                        System.out.println("refresh");
                  }else if (index == 8) {  //profile  
                        System.out.println("Data Admin");
                  } else if (index == 11) { //logout
                        int jawaban = JOptionPane.showConfirmDialog(null, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                        if (jawaban == JOptionPane.YES_OPTION) {
                             System.exit(0);
                        }
                  }
            }
        });

        setForm(new dashboard());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    private void refreshAll () {           
          admin_dashboard.refreshDashboard();
    }


    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder1 = new com.raven.swing.PanelBorder();
            menu = new com.raven.component.Menu();
            header2 = new com.raven.component.Header();
            mainPanel = new javax.swing.JPanel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

            header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

            mainPanel.setOpaque(false);
            mainPanel.setLayout(new java.awt.BorderLayout());

            javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
            panelBorder1.setLayout(panelBorder1Layout);
            panelBorder1Layout.setHorizontalGroup(
                  panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                              .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())))
            );
            panelBorder1Layout.setVerticalGroup(
                  panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                  .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDashboard().setVisible(true);
            }
        });
    }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private com.raven.component.Header header2;
      private javax.swing.JPanel mainPanel;
      private com.raven.component.Menu menu;
      private com.raven.swing.PanelBorder panelBorder1;
      // End of variables declaration//GEN-END:variables
}
