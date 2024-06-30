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

public class DataSubKriteria {
      private DefaultTableModel tabMode;
      
      public void TblSubKriteria(JTable tabel, String kode_kriteria) {
            Object[] rows = {"Kode Kriteria", "Kriteria", "Keterangan", "Nilai", "Jenis"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT tbl_sub_kriteria.kode_kriteria, tbl_kriteria.nama_kriteria, tbl_sub_kriteria.keterangan, tbl_sub_kriteria.bobot, tbl_kriteria.jenis\n" +
                                 "FROM tbl_sub_kriteria\n" +
                                 "INNER JOIN tbl_kriteria ON tbl_sub_kriteria.kode_kriteria = tbl_kriteria.kode_kriteria\n" +
                                 "WHERE tbl_sub_kriteria.kode_kriteria = ?\n" +
                                 "ORDER BY tbl_sub_kriteria.bobot ASC";

                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, kode_kriteria);
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

      
      public void KodeSubK(JComboBox<String> kode_sub_k) {
            try {
                kode_sub_k.removeAllItems(); // Hapus semua item sebelum menambahkan yang baru
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM tbl_kriteria";
                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();

                kode_sub_k.addItem(" "); // Item kosong jika diperlukan

                  while (rs.next()) {
                      String sub_k = rs.getString("kode_kriteria");
                      kode_sub_k.addItem(sub_k);
                  }

                rs.close();
                st.close();
                conn.close();

                  if (kode_sub_k.getItemCount() > 1) {
                      kode_sub_k.setSelectedIndex(1); // Set ComboBox ke indeks ke-1 (setelah item kosong)
                  }
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Eror tampil kode kurir");
            }
      }
      
      public void TambahData(JComboBox<String> kode_sub_k, JTextField keterangan, JTextField nilai) {
            
            if (!keterangan.getText().isEmpty() && !nilai.getText().isEmpty()) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "INSERT INTO tbl_sub_kriteria (kode_kriteria, keterangan, bobot) VALUES (?, ?, ?)";
                        PreparedStatement st = conn.prepareStatement(query);

                        st.setString(1, (String) kode_sub_k.getSelectedItem());
                        st.setString(2, keterangan.getText());
                        st.setString(3, nilai.getText());

                        st.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                        st.close();
                        conn.close();
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Masukan Angka Di Field Nilai");
                        e.printStackTrace();
                  }
            }else {
                  JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            }
      }

      public void HapusData(JTable tabel){
            int selectedRow = tabel.getSelectedRow();
            String index = tabel.getValueAt(selectedRow, 2).toString();
            System.out.println(index);
            
            int ok = JOptionPane.showConfirmDialog(null, "Hapus Sub Kriteria", "Konfirmasi dialog",
                  JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "DELETE FROM `tbl_sub_kriteria` WHERE `keterangan`= ?";
                        PreparedStatement st = conn.prepareStatement(query);
                        
                        st.setString(1, index);
                        
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Terhapus");
 
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                  }
            }
      }
}
