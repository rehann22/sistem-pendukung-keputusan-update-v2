package com.admin.main;

import com.admin.controler.AdminLogin;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JOptionPane;

public class MainLogin extends javax.swing.JFrame {

      public MainLogin() {
            initComponents();
            icon.setIcon(new FlatSVGIcon("com/icon/kurir.svg", icon.getWidth(), icon.getHeight()));
      }
      
      private void btnLoginOnClick () {
            String email = txt_email.getText();
            char[] passwordChars = txt_password.getPassword();
            String password = new String(passwordChars);

            if (email.trim().isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Email & Password tidak boleh kosong");
            } else {
                AdminLogin log = new AdminLogin();
               boolean loginSuccessful = log.isLogin(email, password);

                if (loginSuccessful) {
                    dispose(); // Hanya dispose jika login berhasil
                    System.out.println("Login Admin Berhasil");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Email atau Password salah");
                }
            }
     }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            btn_login = new swing.ButtonGradient();
            txt_email = new textfield.TextField();
            txt_password = new textfield.PasswordField();
            icon = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            btn_login.setText("Login");
            btn_login.setColor1(new java.awt.Color(35, 20, 226));
            btn_login.setColor2(new java.awt.Color(209, 18, 235));
            btn_login.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_loginActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 240, 30));

            txt_email.setBackground(new java.awt.Color(255, 255, 255));
            txt_email.setForeground(new java.awt.Color(97, 103, 122));
            txt_email.setLabelText("Email");
            jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 240, -1));

            txt_password.setBackground(new java.awt.Color(255, 255, 255));
            txt_password.setForeground(new java.awt.Color(97, 103, 122));
            txt_password.setLabelText("Password");
            txt_password.setShowAndHide(true);
            jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 240, -1));
            jPanel1.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 320, 240));

            jLabel2.setBackground(new java.awt.Color(255, 255, 255));
            jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Login Admin");
            jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 240, 30));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 420));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
           btnLoginOnClick();
      }//GEN-LAST:event_btn_loginActionPerformed

      /**
       * @param args the command line arguments
       */
      public static void main(String args[]) {
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
                  java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new MainLogin().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_login;
      private javax.swing.JLabel icon;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JPanel jPanel1;
      private textfield.TextField txt_email;
      private textfield.PasswordField txt_password;
      // End of variables declaration//GEN-END:variables
}
