package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Dashboard {
      public int totalAlternatif() {
            int totalAlt = 0; // Inisialisasi total
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT COUNT(id_kurir) AS total_data FROM tbl_data_kurir";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  if (rs.next()) {
                      totalAlt = rs.getInt("total_data");
                  }
                  rs.close();
                  st.close();
                  conn.close();
            } catch (Exception ex) {
                  ex.printStackTrace();
            }
            return totalAlt;
      }
      
      public int totalKriteria() {
            int totalKrit = 0;
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT COUNT(kode_kriteria) AS total_data FROM tbl_kriteria;";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  if (rs.next()) {
                      totalKrit = rs.getInt("total_data");
                  }
                  rs.close();
                  st.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return totalKrit;
      }
      
      public int totalCrips() {
            int totalCp = 0;
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT COUNT(keterangan) AS total_data FROM tbl_sub_kriteria;;";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  if (rs.next()) {
                      totalCp = rs.getInt("total_data");
                  }
                  rs.close(); 
                  st.close(); 
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return totalCp;
      }
      
      public int totalPenilainAlternatif() {
            int totalPA = 0;
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT COUNT(id_kurir) AS total_data FROM tbl_penilaian;";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  if (rs.next()) {
                      totalPA = rs.getInt("total_data");
                  }
                  rs.close(); 
                  st.close(); 
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return totalPA;
      }
}
