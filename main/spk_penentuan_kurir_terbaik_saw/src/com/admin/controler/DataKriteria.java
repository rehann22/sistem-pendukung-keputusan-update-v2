package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataKriteria {

      private DefaultTableModel tabMode;

      static {
            // Atur locale default ke Locale.US
            Locale.setDefault(Locale.US);
      }

      public void TabelKriteria(JTable tabel) {
            Object[] rows = {"Kode Kriteria", "Nama Kriteria", "Bobot", "Jenis"};
            tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM `tbl_kriteria`";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                        String a = rs.getString("kode_kriteria");
                        String b = rs.getString("nama_kriteria");
                        String c = rs.getString("bobot");
                        String d = rs.getString("jenis");

                        String[] data = {a, b, c, d};
                        tabMode.addRow(data);
                  }
                  conn.close();

            } catch (SQLException e) {
                  System.out.println("Error Method TabelKriteria");
                  e.printStackTrace();
            }
      }

      public void TblSubKriteria(JTable tabel) {
            Object[] rows = {"Kode Kriteria", "Sub Kriteria", "Keterangan", "Nilai", "Jenis"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT \n"
                          + "    tbl_sub_kriteria.kode_kriteria, \n"
                          + "    tbl_kriteria.nama_kriteria, \n"
                          + "    tbl_sub_kriteria.keterangan, \n"
                          + "    tbl_sub_kriteria.bobot, \n"
                          + "    tbl_kriteria.jenis\n"
                          + "FROM \n"
                          + "    tbl_sub_kriteria\n"
                          + "INNER JOIN \n"
                          + "    tbl_kriteria \n"
                          + "    ON tbl_sub_kriteria.kode_kriteria = tbl_kriteria.kode_kriteria\n"
                          + "ORDER BY \n"
                          + "    tbl_sub_kriteria.kode_kriteria, \n"
                          + "    tbl_sub_kriteria.bobot ASC";

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

                  rs.close();
                  ps.close();
                  conn.close();
            } catch (SQLException ex) {
                  System.out.println("Error TblSubKriteria: " + ex.getMessage());
            }
      }
}
