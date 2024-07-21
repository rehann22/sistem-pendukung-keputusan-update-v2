package com.admin.view;

import com.admin.controler.DataSubKriteria;

public class KelolaSubKriteria extends javax.swing.JFrame {
      
      public KelolaSubKriteria() {
            initComponents();
            DataSubKriteria dsk = new DataSubKriteria();
            dsk.KodeSubK(cbb_jeniskriteria);
      }

      /**
       * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
       */
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            txt_keterangan = new textfield.TextField();
            txt_nilai = new textfield.TextField();
            btn_simpan = new swing.ButtonGradient();
            cbb_jeniskriteria = new combobox.Combobox();
            txt_kodesubk = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel2.setBackground(new java.awt.Color(255, 255, 255));
            jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel2.setText("Kode kriteria");
            jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 90, 30));

            jLabel4.setBackground(new java.awt.Color(255, 255, 255));
            jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(97, 103, 122));
            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel4.setText("Keterangan");
            jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 90, 30));

            jLabel5.setBackground(new java.awt.Color(255, 255, 255));
            jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(97, 103, 122));
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel5.setText("Nilai");
            jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 90, 30));

            txt_keterangan.setBackground(new java.awt.Color(255, 255, 255));
            txt_keterangan.setForeground(new java.awt.Color(97, 103, 122));
            txt_keterangan.setLabelText("");
            jPanel1.add(txt_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 210, -1));

            txt_nilai.setBackground(new java.awt.Color(255, 255, 255));
            txt_nilai.setForeground(new java.awt.Color(97, 103, 122));
            txt_nilai.setLabelText("");
            jPanel1.add(txt_nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 210, -1));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
            btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 210, 30));

            cbb_jeniskriteria.setForeground(new java.awt.Color(97, 103, 122));
            cbb_jeniskriteria.setToolTipText("");
            cbb_jeniskriteria.setLabeText("");
            cbb_jeniskriteria.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cbb_jeniskriteriaItemStateChanged(evt);
                  }
            });
            jPanel1.add(cbb_jeniskriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, -1));

            txt_kodesubk.setEditable(false);
            txt_kodesubk.setBackground(new java.awt.Color(255, 255, 255));
            txt_kodesubk.setForeground(new java.awt.Color(255, 255, 255));
            txt_kodesubk.setBorder(null);
            jPanel1.add(txt_kodesubk, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
            DataSubKriteria dsk = new DataSubKriteria();
            dsk.SimpanAtauUbahDataKriteria(cbb_jeniskriteria, txt_keterangan, txt_nilai, txt_kodesubk);
      }//GEN-LAST:event_btn_simpanActionPerformed

      private void cbb_jeniskriteriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_jeniskriteriaItemStateChanged
            
      }//GEN-LAST:event_cbb_jeniskriteriaItemStateChanged

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
                  java.util.logging.Logger.getLogger(KelolaSubKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(KelolaSubKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(KelolaSubKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(KelolaSubKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new KelolaSubKriteria().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      public combobox.Combobox cbb_jeniskriteria;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel5;
      private javax.swing.JPanel jPanel1;
      public textfield.TextField txt_keterangan;
      public javax.swing.JTextField txt_kodesubk;
      public textfield.TextField txt_nilai;
      // End of variables declaration//GEN-END:variables
}
