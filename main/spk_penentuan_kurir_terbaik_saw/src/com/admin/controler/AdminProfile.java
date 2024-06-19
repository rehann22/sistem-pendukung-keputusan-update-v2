package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminProfile {
      String logName = SessionAdmin.log_nama();
      String logId = SessionAdmin.log_idAdmin();
      
      public void editData (JTextField id, JTextField nama, JTextField email, JTextField password) {
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "UPDATE `tbl_admin` SET `nama_admin`=?, `email_admin`=?, `password_admin`=? WHERE `id_admin`=?";
                  PreparedStatement st = conn.prepareStatement(query);
                  st.setString(1, nama.getText());
                  st.setString(2, email.getText());
                  st.setString(3, password.getText());
                  st.setString(4, id.getText());
                  st.executeUpdate();
                  
                  JOptionPane.showMessageDialog(null, "Data Terupdate");
                  TampilData(id, nama, email, password);
            } catch (SQLException ex) {
                  System.out.println("Eror edit data adminr\n" + ex);
            }
      }
      
      public void TampilData (JTextField id, JTextField nama, JTextField email, JTextField password) {
            try {
                  
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM `tbl_admin` WHERE `id_admin` = ? ";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, logId);
                  ResultSet rs = ps.executeQuery();

              String[] data = new String[4];
              if (rs.next()) {
                  data[0] = rs.getString("id_admin");
                  data[1] = rs.getString("nama_admin");
                  data[2] = rs.getString("email_admin");
                  data[3] = rs.getString("password_admin");
              }
              
              id.setText(data[0]);
              nama.setText(data[1]);
              email.setText((data[2]));
              password.setText((data[3]));
              
              conn.close();
              rs.close();
                  
            } catch (SQLException ex) {
                  System.out.println("Eror Form Data Admin\n" + ex );
            }
      }
      
      
}
