package com.admin.controler;
import com.admin.main.MainDashboard;
import com.database.ConnectionDb;
import com.raven.main.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLogin {
    public boolean isLogin(String id_admin, String password) {
            boolean x = false;
            String query = "SELECT * FROM tbl_admin WHERE id_admin = ? AND password = ?";
            try {
                  Connection conn = new ConnectionDb().connect();
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, id_admin);
                  ps.setString(2, password);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            x = true;
                            SessionAdmin.setLoggedInAdmin(rs.getString("id_admin"), rs.getString("nama"), rs.getString("password"));
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

