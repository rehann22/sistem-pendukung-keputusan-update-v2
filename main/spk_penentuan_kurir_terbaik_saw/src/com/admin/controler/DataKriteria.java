package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataKriteria {
      private DefaultTableModel tabMode;
      
      static {
        // Atur locale default ke Locale.US
        Locale.setDefault(Locale.US);
      }
      
      public void bersihkanForm (JTextField kodeK, JTextField namaK, JTextField nilai, JComboBox jenis) {
            kodeK.setText("");
            namaK.setText("");
            nilai.setText("");
            jenis.setSelectedIndex(0);
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
}
