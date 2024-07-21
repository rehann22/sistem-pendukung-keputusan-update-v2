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

public class DataKriteria {

      private DefaultTableModel tabMode;

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

      public void FormEditKriteria(JTable clickTable, JTextField kodeKrit, JTextField namaKrit, JTextField bobotKrit, JComboBox<String> jenisKrit) {
            try {
                  int selectedRow = clickTable.getSelectedRow();
                  if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a row to edit.");
                        return;
                  }

                  String index = clickTable.getValueAt(selectedRow, 0).toString();
                  System.out.println(index);

                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM tbl_kriteria WHERE kode_kriteria = ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, index);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                        String kode = rs.getString("kode_kriteria");
                        String nama = rs.getString("nama_kriteria");
                        String bobot = rs.getString("bobot");
                        String jenis = rs.getString("jenis");

                        kodeKrit.setText(kode);
                        namaKrit.setText(nama);
                        bobotKrit.setText(bobot);
                        jenisKrit.setSelectedItem(jenis);
                  }

                  rs.close();
                  ps.close();
                  conn.close();
            } catch (SQLException ex) {
                  ex.printStackTrace();
            }
      }

      public void TambahDataKriteria(JTextField kodeKrit, JTextField namaKrit, JTextField bobotKrit, JComboBox jenisKrit) {

            if (!kodeKrit.getText().isEmpty() && !namaKrit.getText().isEmpty() && !bobotKrit.getText().isEmpty()) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "INSERT INTO tbl_kriteria (kode_kriteria, nama_kriteria, bobot, jenis) VALUES (?, ?, ?, ?)";
                        PreparedStatement ps = conn.prepareStatement(query);

                        ps.setString(1, kodeKrit.getText());
                        ps.setString(2, namaKrit.getText());
                        ps.setString(3, bobotKrit.getText());
                        ps.setString(4, (String) jenisKrit.getSelectedItem());

                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Tersimpan");
                        ps.close();
                        conn.close();
                  } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                        System.out.println("Error TambahData: " + e.getMessage());
                  }
            } else {
                  JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            }
      }

      public void UbahDataKriteria(JTextField kodeKrit, JTextField namaKrit, JTextField bobotKrit, JComboBox<String> jenisKrit) {
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "UPDATE tbl_kriteria SET nama_kriteria = ?, bobot = ?, jenis = ? WHERE kode_kriteria = ?";
                  PreparedStatement ps = conn.prepareStatement(query);

                  ps.setString(1, namaKrit.getText());
                  ps.setString(2, bobotKrit.getText());
                  ps.setString(3, (String) jenisKrit.getSelectedItem());
                  ps.setString(4, kodeKrit.getText());

                  ps.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Data Berhasil Terubah");
                  ps.close();
                  conn.close();
            } catch (SQLException e) {
                  System.out.println("Error UbahDataKriteria: " + e.getMessage());
                  JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            }
      }

      public void HapusDataKriteria(JTable tabel) {
            int selectedRow = tabel.getSelectedRow();
            String index = tabel.getValueAt(selectedRow, 0).toString();
            System.out.println(index);

            int ok = JOptionPane.showConfirmDialog(null, "Hapus Data Kriteria??", "Message",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok == 0) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "DELETE FROM `tbl_kriteria` WHERE `kode_kriteria`= ?";
                        PreparedStatement st = conn.prepareStatement(query);

                        st.setString(1, index);

                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Terhapus");
                        TabelKriteria(tabel);

                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                  }
            }
      }

      public void SimpanAtauUbahDataKriteria(JTextField kodeKrit, JTextField namaKrit, JTextField bobotKrit, JComboBox<String> jenisKrit) {
            if (!kodeKrit.getText().isEmpty() && !namaKrit.getText().isEmpty() && !bobotKrit.getText().isEmpty()) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "SELECT COUNT(*) FROM tbl_kriteria WHERE kode_kriteria = ?";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setString(1, kodeKrit.getText());

                        ResultSet rs = ps.executeQuery();
                        rs.next();
                        int count = rs.getInt(1);
                        rs.close();
                        ps.close();
                        conn.close();

                        if (count > 0) {
                              // Kode kriteria sudah ada, panggil metode UbahDataKriteria
                              UbahDataKriteria(kodeKrit, namaKrit, bobotKrit, jenisKrit);
                        } else {
                              // Kode kriteria belum ada, panggil metode TambahDataKriteria
                              TambahDataKriteria(kodeKrit, namaKrit, bobotKrit, jenisKrit);
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
