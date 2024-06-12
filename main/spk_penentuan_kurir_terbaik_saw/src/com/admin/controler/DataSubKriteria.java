package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataSubKriteria {
      private DefaultTableModel tabMode;
      
      public void Criteria1 (JTable tabel) {
            Object[] rows = {"Kode Kriteria", "Kriteria", "Keterangan", "Bobot", "Jenis"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
            
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT tbl_sub_kriteria.kode_kriteria, tbl_kriteria.nama_kriteria, tbl_sub_kriteria.keterangan, tbl_sub_kriteria.bobot, tbl_kriteria.jenis\n" +
                              "FROM tbl_sub_kriteria\n" +
                              "INNER JOIN tbl_kriteria ON tbl_sub_kriteria.kode_kriteria = tbl_kriteria.kode_kriteria\n" +
                              "WHERE tbl_sub_kriteria.kode_kriteria = \"C01\"\n" +
                              "ORDER BY tbl_sub_kriteria.bobot ASC";

                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                      String a = rs.getString("kode_kriteria");
                      String b = rs.getString("nama_kriteria");
                      String c = rs.getString("keterangan");  
                      String d = rs.getString("bobot");
                      String e = rs.getString("jenis");
                      
                      String[] data = {a, b, c, d, e};
                      tabMode.addRow(data);
                  }
            } catch (SQLException ex) {
                System.out.println("Error Criteria1: " + ex.getMessage());
            } 
      }
      public void Criteria2 (JTable tabel) {
            Object[] rows = {"Kode Kriteria", "Kriteria", "Keterangan", "Bobot", "Jenis"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
            
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT tbl_sub_kriteria.kode_kriteria, tbl_kriteria.nama_kriteria, tbl_sub_kriteria.keterangan, tbl_sub_kriteria.bobot, tbl_kriteria.jenis\n" +
                              "FROM tbl_sub_kriteria\n" +
                              "INNER JOIN tbl_kriteria ON tbl_sub_kriteria.kode_kriteria = tbl_kriteria.kode_kriteria\n" +
                              "WHERE tbl_sub_kriteria.kode_kriteria = \"C02\"\n" +
                              "ORDER BY tbl_sub_kriteria.bobot ASC";

                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                      String a = rs.getString("kode_kriteria");
                      String b = rs.getString("nama_kriteria");
                      String c = rs.getString("keterangan");  
                      String d = rs.getString("bobot");
                      String e = rs.getString("jenis");
                      
                      String[] data = {a, b, c, d, e};
                      tabMode.addRow(data);
                  }
            } catch (SQLException ex) {
                System.out.println("Error Criteria1: " + ex.getMessage());
            } 
      }
      public void Criteria3 (JTable tabel) {
            Object[] rows = {"Kode Kriteria", "Kriteria", "Keterangan", "Bobot", "Jenis"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
            
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT tbl_sub_kriteria.kode_kriteria, tbl_kriteria.nama_kriteria, tbl_sub_kriteria.keterangan, tbl_sub_kriteria.bobot, tbl_kriteria.jenis\n" +
                              "FROM tbl_sub_kriteria\n" +
                              "INNER JOIN tbl_kriteria ON tbl_sub_kriteria.kode_kriteria = tbl_kriteria.kode_kriteria\n" +
                              "WHERE tbl_sub_kriteria.kode_kriteria = \"C03\"\n" +
                              "ORDER BY tbl_sub_kriteria.bobot ASC";

                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                      String a = rs.getString("kode_kriteria");
                      String b = rs.getString("nama_kriteria");
                      String c = rs.getString("keterangan");  
                      String d = rs.getString("bobot");
                      String e = rs.getString("jenis");
                      
                      String[] data = {a, b, c, d, e};
                      tabMode.addRow(data);
                  }
            } catch (SQLException ex) {
                System.out.println("Error Criteria1: " + ex.getMessage());
            } 
      }
      public void Criteria4 (JTable tabel) {
            Object[] rows = {"Kode Kriteria", "Kriteria", "Keterangan", "Bobot", "Jenis"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
            
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT tbl_sub_kriteria.kode_kriteria, tbl_kriteria.nama_kriteria, tbl_sub_kriteria.keterangan, tbl_sub_kriteria.bobot, tbl_kriteria.jenis\n" +
                              "FROM tbl_sub_kriteria\n" +
                              "INNER JOIN tbl_kriteria ON tbl_sub_kriteria.kode_kriteria = tbl_kriteria.kode_kriteria\n" +
                              "WHERE tbl_sub_kriteria.kode_kriteria = \"C04\"\n" +
                              "ORDER BY tbl_sub_kriteria.bobot ASC";

                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                      String a = rs.getString("kode_kriteria");
                      String b = rs.getString("nama_kriteria");
                      String c = rs.getString("keterangan");  
                      String d = rs.getString("bobot");
                      String e = rs.getString("jenis");
                      
                      String[] data = {a, b, c, d, e};
                      tabMode.addRow(data);
                  }
            } catch (SQLException ex) {
                System.out.println("Error Criteria1: " + ex.getMessage());
            } 
      }
   
}
