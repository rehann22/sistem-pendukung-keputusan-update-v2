
package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PenilaianKurir {
      private DefaultTableModel tabMode;
      
      public void TabelPenilaian(JTable tabel) {
          Object[] rows = {"Id Kurir", "Nama Kurir", "Presensi", "Kecepatan Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal"};
          tabMode = new DefaultTableModel(null, rows);
          tabel.setModel(tabMode);

            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM tbl_penilaian";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                      String a = rs.getString("id_kurir");
                      String b = rs.getString("nama_kurir");
                      String c = rs.getString("presensi");
                      String d = rs.getString("kecepatan_pengiriman");
                      String e = rs.getString("pengiriman_berhasil");
                      String f = rs.getString("pengiriman_gagal");
                      String[] data = {a,b,c,d,e,f};
                      tabMode.addRow(data);
                  }
                  conn.close();
                  tabel.getColumnModel().getColumn(0).setPreferredWidth(0); 
                  tabel.getColumnModel().getColumn(2).setPreferredWidth(10); 

            } catch (SQLException e) {
                System.out.println("Error dataTabel: " + e.getMessage());
            }
      }
      
      public void CariData(JTextField namaKurir, JTable tabel) {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Presensi", "Kecepatan Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT id_kurir, nama_kurir, presensi, kecepatan_pengiriman, pengiriman_berhasil, pengiriman_gagal " +
                                 "FROM tbl_penilaian " +
                                 "WHERE nama_kurir LIKE ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, "%" + namaKurir.getText() + "%");
                  ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                      String idKurir = rs.getString("id_kurir");
                      String nama = rs.getString("nama_kurir");
                      String presensi = rs.getString("presensi");
                      String kecepatanPengiriman = rs.getString("kecepatan_pengiriman");
                      String pengirimanBerhasil = rs.getString("pengiriman_berhasil");
                      String pengirimanGagal = rs.getString("pengiriman_gagal");
                      String[] data = {idKurir, nama, presensi, kecepatanPengiriman, pengirimanBerhasil, pengirimanGagal};
                      tabMode.addRow(data);
                  }
                  tabel.getColumnModel().getColumn(0).setPreferredWidth(0); 
                  tabel.getColumnModel().getColumn(2).setPreferredWidth(10); 

                  rs.close();
                  ps.close();
                  conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
      }
      
      public void simpanDataKeDatabase(JTable table) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                  conn = new ConnectionDb().connect();

                  // Hapus semua data dari tabel sebelum menyimpan yang baru
                  String deleteQuery = "DELETE FROM tbl_penilaian";
                  ps = conn.prepareStatement(deleteQuery);
                  ps.executeUpdate();

                  // Siapkan pernyataan untuk menyimpan data baru
                  String insertQuery = "INSERT INTO tbl_penilaian (id_kurir, nama_kurir, presensi, kecepatan_pengiriman, pengiriman_berhasil, pengiriman_gagal) VALUES (?, ?, ?, ?, ?, ?)";
                  ps = conn.prepareStatement(insertQuery);

                  DefaultTableModel model = (DefaultTableModel) table.getModel();
                  int rowCount = model.getRowCount();

                  for (int i = 0; i < rowCount; i++) {
                      String idKurir = model.getValueAt(i, 0) != null ? model.getValueAt(i, 0).toString() : "";
                      String namaKurir = model.getValueAt(i, 1) != null ? model.getValueAt(i, 1).toString() : "";
                      String presensi = model.getValueAt(i, 2) != null ? model.getValueAt(i, 2).toString() : "";
                      String kecepatanPengiriman = model.getValueAt(i, 3) != null ? model.getValueAt(i, 3).toString() : "";
                      String pengirimanBerhasil = model.getValueAt(i, 4) != null ? model.getValueAt(i, 4).toString() : "";
                      String pengirimanGagal = model.getValueAt(i, 5) != null ? model.getValueAt(i, 5).toString() : "";

                        // Periksa apakah baris memiliki data yang lengkap
                        if (!idKurir.isEmpty() && !namaKurir.isEmpty() && !presensi.isEmpty() &&
                            !kecepatanPengiriman.isEmpty() && !pengirimanBerhasil.isEmpty() && !pengirimanGagal.isEmpty()) {

                            ps.setString(1, idKurir);
                            ps.setString(2, namaKurir);
                            ps.setString(3, presensi);
                            ps.setString(4, kecepatanPengiriman);
                            ps.setString(5, pengirimanBerhasil);
                            ps.setString(6, pengirimanGagal);

                            ps.addBatch();
                        }
                  }

                  ps.executeBatch();
                  JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke database!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                  e.printStackTrace();
                  JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke database!", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                  try {
                      if (ps != null) ps.close();
                      if (conn != null) conn.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
            }
      }


      
}


