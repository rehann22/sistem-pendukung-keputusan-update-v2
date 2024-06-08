package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class DataKriteria {
      private DefaultTableModel tabMode;

      public int getTotalNilai() {
            int totalNilai = 0;
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT SUM(nilai) AS total_nilai FROM tbl_kriteria";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();

                  if (rs.next()) {
                      totalNilai = rs.getInt("total_nilai");
                      System.out.println(totalNilai);
                  }
            } catch (SQLException ex) {
                System.out.println("Error calculating total nilai\n" + ex);
            }
            return totalNilai;
      }

      public void TabelKriteria(JTable tabel) {
            Object[] rows = {"Kode kriteria", "Kriteria", "Nilai", "Jenis", "Bobot"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
            
            // Menentukan lebar kolom
            TableColumnModel columnModel = tabel.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50); // Kolom Kode kriteria
            columnModel.getColumn(1).setPreferredWidth(250); // Kolom Kriteria

            int totalNilai = getTotalNilai();
            if (totalNilai == 0) {
                System.out.println("Total nilai is zero, cannot calculate bobot.");
                return;
            }

             double totalBobot = 0;

            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM tbl_kriteria";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                      String a = rs.getString("kode_kriteria");
                      String b = rs.getString("nama_kriteria");
                      int c = rs.getInt("nilai");  // Pastikan kolom 'nilai' adalah tipe integer di database
                      String d = rs.getString("jenis");

                      double e = (double) c / totalNilai;  // Hitung bobot
                      totalBobot += e;

                      // Membulatkan ke dua angka di belakang koma
                      double scaledValue = e * 100;
                      double roundedValue;

                              // Jika nilai lebih besar dari .50 bulatkan ke atas, jika lebih kecil atau sama dengan .50 bulatkan ke bawah
                              if (scaledValue % 1 >= 0.5) {
                                  roundedValue = Math.ceil(scaledValue);
                              } else {
                                  roundedValue = Math.floor(scaledValue);
                              }

                      // Kembalikan ke dua angka desimal
                      roundedValue /= 100;

                      String formattedE = String.format("%.2f", roundedValue); // Format bobot dengan 2 angka di belakang koma

                      String[] data = {a, b, String.valueOf(c), d, formattedE};
                      tabMode.addRow(data);
                  }

//                // Tambahkan baris footer
                String formattedTotalBobot = String.format("%.2f", totalBobot);
                String[] footer = {"", "Total", String.valueOf(totalNilai), "", formattedTotalBobot};
                tabMode.addRow(footer);

                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error dataTabel: " + ex.getMessage());
            }

      }

      public void TampilFormKriteria(JTable tabelKriteria, JTextField kodeKriteria, JTextField namaKriteria, JTextField nilai, JComboBox jenis) {
            try {
                  int selectedRow = tabelKriteria.getSelectedRow();
                  String index = tabelKriteria.getValueAt(selectedRow, 0).toString();
                  System.out.println(index);

                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM tbl_kriteria WHERE kode_kriteria =?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, index);
                  ResultSet rs = ps.executeQuery();

                  String[] data = new String[4];
                        if (rs.next()) {
                            data[0] = rs.getString("kode_kriteria");
                            data[1] = rs.getString("nama_kriteria");
                            data[2] = rs.getString("nilai");
                            data[3] = rs.getString("jenis");
                        }

                  kodeKriteria.setText(data[0]);
                  namaKriteria.setText(data[1]);
                  nilai.setText((data[2]));
                  jenis.setSelectedItem(data[3]);

                  conn.close();
                  rs.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error di TampilFormKriteria");
            }
      }

             
}
