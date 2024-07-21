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

      public void TblSubKriteria(JTable tabel) {
            Object[] rows = {"Kode Kriteria", "Kode Sub Kriteria", "Sub Kriteria", "Keterangan", "Bobot", "Jenis"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT \n"
                          + "    tbl_sub_kriteria.kode_kriteria, \n"
                          + "    tbl_sub_kriteria.kode_sub_kriteria, \n"
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
                        String b = rs.getString("kode_sub_kriteria");
                        String c = rs.getString("nama_kriteria");
                        String d = rs.getString("keterangan");
                        String e = rs.getString("bobot");
                        String f = rs.getString("jenis");

                        String[] data = {a, b, c, d, e, f};
                        tabMode.addRow(data);
                  }

                  rs.close();
                  ps.close();
                  conn.close();
                  
                  tabel.getColumnModel().getColumn(1).setMaxWidth(0);
                  tabel.getColumnModel().getColumn(1).setMinWidth(0);
                  tabel.getColumnModel().getColumn(1).setWidth(0);
                  tabel.getColumnModel().getColumn(1).setPreferredWidth(0);
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

      public void FormEditSubKriteria(JTable clickTable, JComboBox<String> kodeKrit, JTextField keterangan, JTextField nilai, JTextField kodeSubK) {
            try {
                  int selectedRow = clickTable.getSelectedRow();
                  if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a row to edit.");
                        return;
                  }
                  String index;
                  index = clickTable.getValueAt(selectedRow, 1).toString();
                  System.out.println(index);

                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM tbl_sub_kriteria WHERE kode_sub_kriteria = ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, index);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                        String kode = rs.getString("kode_kriteria");
                        String ket = rs.getString("keterangan");
                        String nil = rs.getString("bobot");
                        String kodeSub = rs.getString("kode_sub_kriteria");

                        // Assuming kodeKrit is a JComboBox<String>
                        kodeKrit.setSelectedItem(kode);
                        keterangan.setText(ket);
                        nilai.setText(nil);
                        kodeSubK.setText(kodeSub);
                  } else {
                        JOptionPane.showMessageDialog(null, "Data not found for the selected row.");
                  }

                  rs.close();
                  ps.close();
                  conn.close();
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  JOptionPane.showMessageDialog(null, "An error occurred while trying to fetch the data.");
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
            } else {
                  JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            }
      }

      public void UbahData(JComboBox<String> kode_kriteria, JTextField keterangan, JTextField nilai, JTextField kode_subkrit) {
            if (!keterangan.getText().isEmpty() && !nilai.getText().isEmpty()) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "UPDATE tbl_sub_kriteria SET kode_kriteria = ?, keterangan = ?, bobot = ? WHERE kode_sub_kriteria = ?";
                        PreparedStatement st = conn.prepareStatement(query);

                        st.setString(1, (String) kode_kriteria.getSelectedItem());
                        st.setString(2, keterangan.getText());
                        st.setString(3, nilai.getText());
                        st.setString(4, kode_subkrit.getText());

                        st.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                        st.close();
                        conn.close();
                  } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Masukan Angka Di Field Nilai");
                        e.printStackTrace();
                  }
            } else {
                  JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            }
      }

      public void HapusData(JTable tabel) {
            int selectedRow = tabel.getSelectedRow();
            String index = tabel.getValueAt(selectedRow, 1).toString();
            System.out.println(index);

            int ok = JOptionPane.showConfirmDialog(null, "Hapus Sub Kriteria", "Konfirmasi dialog",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok == 0) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "DELETE FROM `tbl_sub_kriteria` WHERE `kode_sub_kriteria`= ?";
                        PreparedStatement st = conn.prepareStatement(query);

                        st.setString(1, index);

                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Terhapus");
                        DataSubKriteria dsk = new DataSubKriteria();
                        dsk.TblSubKriteria(tabel);

                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                  }
            }
      }

      public void SimpanAtauUbahDataKriteria(JComboBox<String> kode_kriteria, JTextField keterangan, JTextField nilai, JTextField kodeSub) {
            if (kode_kriteria.getSelectedItem() != null && !keterangan.getText().isEmpty() && !nilai.getText().isEmpty()) {

                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "SELECT COUNT(*) FROM tbl_sub_kriteria WHERE kode_sub_kriteria = ?";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setString(1, kodeSub.getText());

                        ResultSet rs = ps.executeQuery();
                        rs.next();
                        int count = rs.getInt(1);
                        rs.close();
                        ps.close();
                        conn.close();

                        if (count > 0) {
                              // Kode kriteria sudah ada, panggil metode UbahData
                              UbahData(kode_kriteria, keterangan, nilai, kodeSub);
                        } else {
                              // Kode kriteria belum ada, panggil metode TambahData
                              TambahData(kode_kriteria, keterangan, nilai);
                        }
                  } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                        System.out.println("Error SimpanAtauUbahDataKriteria: " + e.getMessage());
                  }
            } else {
                  JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            }
      }

}
