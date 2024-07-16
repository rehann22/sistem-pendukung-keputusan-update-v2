package com.admin.controler;

import com.admin.main.MainDashboard;
import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLogin {

      public boolean isLogin(String email, String password) {
            boolean x = false;
            String query = "SELECT * FROM tbl_admin WHERE email_admin = ? AND password_admin = ?";
            try {
                  Connection conn = new ConnectionDb().connect();
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, email);
                  ps.setString(2, password);

                  try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                              x = true;
                              SessionAdmin.setLoggedInAdmin(rs.getString("id_admin"), rs.getString("nama_admin"), rs.getString("email_admin"), rs.getString("password_admin"));
                              MainDashboard dashboard = new MainDashboard();
                              dashboard.setVisible(true);
                        }

                  } catch (Exception ex) {
                        System.out.println("Eror Login");
                  }

            } catch (Exception ex) {
                  // Lakukan penanganan eksepsi sesuai kebutuhan, misalnya mencatat dalam log
                  ex.printStackTrace();
                  System.out.println("Eror di isLogin");
            }
            return x;
      }
}
