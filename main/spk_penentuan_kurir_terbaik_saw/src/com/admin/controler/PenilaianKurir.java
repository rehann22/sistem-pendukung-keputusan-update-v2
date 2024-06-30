
package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PenilaianKurir {
      private DefaultTableModel tabMode;

      
      public void TabelPenilaian(JTable tabel) {
          Object[] rows = {"Id Kurir", "Nama Kurir", "Lama Bekerja", "Kecepatan Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal"};
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
                      String c = rs.getString("lama_bekerja");
                      String d = rs.getString("kecepatan_pengiriman");
                      String e = rs.getString("pengiriman_berhasil");
                      String f = rs.getString("pengiriman_gagal");
                      String[] data = {a,b,c,d,e,f};
                      tabMode.addRow(data);
                  }
                  tabel.getColumnModel().getColumn(0).setPreferredWidth(0); 
                  tabel.getColumnModel().getColumn(2).setPreferredWidth(10); 
                  conn.close();

            } catch (SQLException e) {
                System.out.println("Error dataTabel: " + e.getMessage());
            }
      }
      
      public void IdKurir(JComboBox<String> idKurir) {
            try {
                idKurir.removeAllItems(); // Hapus semua item sebelum menambahkan yang baru
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT id_kurir, nama FROM tbl_data_kurir";
                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();

                idKurir.addItem(" "); // Item kosong jika diperlukan

                  while (rs.next()) {
                      String idKurirStr = rs.getString("id_kurir");
                      String namaKurir = rs.getString("nama");
                      idKurir.addItem(idKurirStr + " - " + namaKurir);
                  }

                rs.close();
                st.close();
                conn.close();

                  if (idKurir.getItemCount() > 1) {
                      idKurir.setSelectedIndex(1); // Set ComboBox ke indeks ke-1 (setelah item kosong)
                  }
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Eror tampil kode kurir");
            }
      }
      
      public void PenilaianKurir(JComboBox<String> Kriteria, String kodeKriteria) {
            try {
                Kriteria.removeAllItems(); // Hapus semua item sebelum menambahkan yang baru
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT keterangan FROM tbl_sub_kriteria WHERE kode_kriteria = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, kodeKriteria);
                ResultSet rs = st.executeQuery();

                Kriteria.addItem(" "); // Item kosong jika diperlukan

                  while (rs.next()) {
                      String kriteriaStr = rs.getString("keterangan");
                      Kriteria.addItem(kriteriaStr);
                  }

                rs.close();
                st.close();
                conn.close();

                  if (Kriteria.getItemCount() > 1) {
                      Kriteria.setSelectedIndex(1); // Set ComboBox ke indeks ke-1 (setelah item kosong)
                  }
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Eror tampil kode kurir");
            }
      }
      
      public void TampilFormEditPenilaian(JTable clickTable, JComboBox<String> idKurirComboBox, JComboBox<String> lamaKerja, JComboBox<String> kecepatanK, JComboBox<String> paketSukses, JComboBox<String> paketGagal) {
            try {
                  int selectedRow = clickTable.getSelectedRow();
                  if (selectedRow == -1) {
                      System.out.println("Tidak ada baris yang dipilih.");
                      return;
                  }

                  String idKurir = clickTable.getValueAt(selectedRow, 0).toString();

                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM tbl_penilaian WHERE id_kurir = ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, idKurir);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                        String lamaBekerja = rs.getString("lama_bekerja");
                        String kecepatanPengiriman = rs.getString("kecepatan_pengiriman");
                        String pengirimanBerhasil = rs.getString("pengiriman_berhasil");
                        String pengirimanGagal = rs.getString("pengiriman_gagal");

                        // Ambil nama kurir berdasarkan id_kurir jika diperlukan
                        String queryKurir = "SELECT nama FROM tbl_data_kurir WHERE id_kurir = ?";
                        PreparedStatement psKurir = conn.prepareStatement(queryKurir);
                        psKurir.setString(1, idKurir);
                        ResultSet rsKurir = psKurir.executeQuery();
                        String namaKurir = "";
                        if (rsKurir.next()) {
                            namaKurir = rsKurir.getString("nama");
                  }

                  idKurirComboBox.removeAllItems();
                  idKurirComboBox.addItem(idKurir + " - " + namaKurir);

                  lamaKerja.setSelectedItem(lamaBekerja);
                  kecepatanK.setSelectedItem(kecepatanPengiriman);
                  paketSukses.setSelectedItem(pengirimanBerhasil);
                  paketGagal.setSelectedItem(pengirimanGagal);

                  rsKurir.close();
                  psKurir.close();
              }

                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Error di tampilFormEditPenilaian");
            }
     }


      
      public void btnSimpan(JComboBox<String> idKurirComboBox, JComboBox<String> lamaKerja, JComboBox<String> kecepatanK, JComboBox<String> paketSukses, JComboBox<String> paketGagal) {
            try {
                  Connection conn = new ConnectionDb().connect();

                  // Ambil nilai yang dipilih dari JComboBox idKurirComboBox
                  String selectedItem = (String) idKurirComboBox.getSelectedItem();
                  if (selectedItem == null || selectedItem.trim().isEmpty()) {
                      System.out.println("Id Kurir tidak boleh kosong.");
                      return;
                  }

                  // Pisahkan idKurir dan namaKurir dari item yang digabungkan
                  String[] parts = selectedItem.split(" - ");
                  if (parts.length < 2) {
                      System.out.println("Format idKurir dan namaKurir tidak valid.");
                      return;
                  }
                  String idKurir = parts[0];
                  String namaKurir = parts[1];

                  String query = "INSERT INTO tbl_penilaian (id_kurir, nama_kurir, lama_bekerja, kecepatan_pengiriman, pengiriman_berhasil, pengiriman_gagal) VALUES (?, ?, ?, ?, ?, ?)";
                  PreparedStatement ps = conn.prepareStatement(query);

                  // Set nilai ke PreparedStatement
                  ps.setString(1, idKurir);
                  ps.setString(2, namaKurir);
                  ps.setString(3, (String) lamaKerja.getSelectedItem());
                  ps.setString(4, (String) kecepatanK.getSelectedItem());
                  ps.setString(5, (String) paketSukses.getSelectedItem());
                  ps.setString(6, (String) paketGagal.getSelectedItem());

                  // Eksekusi query
                  ps.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Data Penilaian Tersimpan");

                  // Tutup resources
                  ps.close();
                  conn.close();

                  System.out.println("Data berhasil disimpan.");
            } catch (SQLException e) {
                  JOptionPane.showMessageDialog(null, "Data Sudah Tersedia");
                  System.out.println("Error btnSimpan: " + e.getMessage());
                  e.printStackTrace();
            }
      }
      
      public void btnUbah(JComboBox<String> idKurirComboBox, JComboBox<String> lamaKerja, JComboBox<String> kecepatanK, JComboBox<String> paketSukses, JComboBox<String> paketGagal) {
            try {
                  Connection conn = new ConnectionDb().connect();

                  // Ambil nilai yang dipilih dari JComboBox idKurirComboBox
                  String selectedItem = (String) idKurirComboBox.getSelectedItem();
                  if (selectedItem == null || selectedItem.trim().isEmpty()) {
                      System.out.println("Id Kurir tidak boleh kosong.");
                      return;
                  }

                  // Pisahkan idKurir dan namaKurir dari item yang digabungkan
                  String[] parts = selectedItem.split(" - ");
                  if (parts.length < 2) {
                      System.out.println("Format idKurir dan namaKurir tidak valid.");
                      return;
                  }
                  String idKurir = parts[0];

                  String query = "UPDATE tbl_penilaian SET lama_bekerja = ?, kecepatan_pengiriman = ?, pengiriman_berhasil = ?, pengiriman_gagal = ? WHERE id_kurir = ?";
                  PreparedStatement ps = conn.prepareStatement(query);

                  // Set nilai ke PreparedStatement
                  ps.setString(1, (String) lamaKerja.getSelectedItem());
                  ps.setString(2, (String) kecepatanK.getSelectedItem());
                  ps.setString(3, (String) paketSukses.getSelectedItem());
                  ps.setString(4, (String) paketGagal.getSelectedItem());
                  ps.setString(5, idKurir);

                  // Eksekusi query
                  ps.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");

                  // Tutup resources
                  ps.close();
                  conn.close();

                  System.out.println("Data berhasil diperbarui.");
            } catch (SQLException e) {
                  System.out.println("Error btnUbah: " + e.getMessage());
                  e.printStackTrace();
            }
      }

      
      public void btnHapus(JTable clickTable) {
            try {
                  // Mengambil baris yang dipilih di JTable
                  int selectedRow = clickTable.getSelectedRow();
                  if (selectedRow == -1) {
                      System.out.println("Tidak ada baris yang dipilih.");
                      return;
                  }

                  // Mendapatkan nilai id_kurir dari baris yang dipilih
                  String idKurir = clickTable.getValueAt(selectedRow, 0).toString();

                  // Konfirmasi penghapusan
                  int response = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan ID Kurir: " + idKurir + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
                  if (response != JOptionPane.YES_OPTION) {
                      return;
                  }

                  // Koneksi ke database dan menjalankan query delete
                  Connection conn = new ConnectionDb().connect();
                  String query = "DELETE FROM tbl_penilaian WHERE id_kurir = ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, idKurir);

                  // Eksekusi query
                  int rowsDeleted = ps.executeUpdate();
                  if (rowsDeleted > 0) {
                      System.out.println("Data berhasil dihapus.");
                      JOptionPane.showMessageDialog(null, "Data Terhapus");
                  } else {
                      System.out.println("Tidak ada data yang dihapus.");
                  }

                  // Menutup resources
                  ps.close();
                  conn.close();
            } catch (SQLException ex) {
                  System.out.println("Error btnHapus: " + ex.getMessage());
                  ex.printStackTrace();
            }
      }
      
      public void CariData(JTextField namaKurir, JTable tabel) {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Lama Bekerja", "Kecepatan Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT id_kurir, nama_kurir, lama_bekerja, kecepatan_pengiriman, pengiriman_berhasil, pengiriman_gagal " +
                                 "FROM tbl_penilaian " +
                                 "WHERE nama_kurir LIKE ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, "%" + namaKurir.getText() + "%");
                  ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                      String idKurir = rs.getString("id_kurir");
                      String nama = rs.getString("nama_kurir");
                      String lamaBekerja = rs.getString("lama_bekerja");
                      String kecepatanPengiriman = rs.getString("kecepatan_pengiriman");
                      String pengirimanBerhasil = rs.getString("pengiriman_berhasil");
                      String pengirimanGagal = rs.getString("pengiriman_gagal");
                      String[] data = {idKurir, nama, lamaBekerja, kecepatanPengiriman, pengirimanBerhasil, pengirimanGagal};
                      tabMode.addRow(data);
                  }

                  rs.close();
                  ps.close();
                  conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
      }

}


