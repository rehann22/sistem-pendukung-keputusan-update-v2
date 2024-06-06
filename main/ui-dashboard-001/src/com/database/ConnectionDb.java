package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
      private Connection connectionDb;
      public Connection connect () {
            try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
//                  System.out.println("Koneksi Berhasil");
            } catch (ClassNotFoundException ex) {
                  System.out.println("Gagal koneksi" + ex);
            }
            String url = "jdbc:mysql://localhost:3306/spk_kurir_terbaik";
            
            try {
                  connectionDb = DriverManager.getConnection(url, "root" , "");
//                  System.out.println("Berhasil Koneksi Database");
            } catch (SQLException ex) {
                  System.out.println("Gagal koneksi database!!!" + ex);
            }
            return connectionDb;
      }  
}
