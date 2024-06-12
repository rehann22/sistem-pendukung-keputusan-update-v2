package com.admin.controler;

import com.admin.view.PageDataKriteria;
import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProsesPerhitungan {

      private DefaultTableModel tabMode;
      private DefaultTableModel tabelNormalisasi;

      static {
          // Atur locale default ke Locale.US
          Locale.setDefault(Locale.US);
      }
      
      // Method untuk memperbarui nilai maksimum dan minimum untuk setiap kriteria
      private static void updateMinMaxValues(double[] maxValues, double[] minValues, double... values) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] > maxValues[i]) {
                    maxValues[i] = values[i];
                }
                if (values[i] < minValues[i]) {
                    minValues[i] = values[i];
                }
            }
      }

      public void DataPenilaianAlternatif(JTable tabel) {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();

                  // Query untuk mengambil data dari tbl_penilaian
                  String query = "SELECT * FROM tbl_penilaian";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ResultSet rs = ps.executeQuery();

                  // Menyimpan nilai maksimum dan minimum untuk setiap kriteria
                  double[] maxValues = new double[5];
                  double[] minValues = new double[5];
                  for (int i = 0; i < 5; i++) {
                      maxValues[i] = Double.NEGATIVE_INFINITY;
                      minValues[i] = Double.POSITIVE_INFINITY;
                  }

                // Memproses hasil query
                  while (rs.next()) {
                        String idKurir = rs.getString("id_kurir");
                        String namaKurir = rs.getString("nama_kurir");
                        String kesalahanPengiriman = rs.getString("kesalahan_pengiriman");
                        String lamaBekerja = rs.getString("lama_bekerja");
                        String kecepatanPengiriman = rs.getString("kecepatan_pengiriman");
                        String paketDikirimPerbulan = rs.getString("paket_dikirim_perbulan");

                        // Mendapatkan bobot untuk setiap kriteria
                        double bobotKesalahanPengiriman = getBobot(kesalahanPengiriman);
                        double bobotLamaBekerja = getBobot(lamaBekerja);
                        double bobotKecepatanPengiriman = getBobot(kecepatanPengiriman);
                        double bobotPaketDikirimPerbulan = getBobot(paketDikirimPerbulan);

                        // Memperbarui nilai maksimum dan minimum untuk setiap kriteria
                        updateMinMaxValues(maxValues, minValues, bobotKesalahanPengiriman, bobotLamaBekerja, bobotKecepatanPengiriman, bobotPaketDikirimPerbulan);

                        // Menambahkan data ke dalam tabel
                        Object[] data = {idKurir, namaKurir, bobotKesalahanPengiriman, bobotLamaBekerja, bobotKecepatanPengiriman, bobotPaketDikirimPerbulan};
                        tabMode.addRow(data);

                  }

            // Menambahkan footer untuk nilai maksimum ("Benefit") dan nilai minimum ("Cost")
            Object[] maxFooter = {"", "Nilai Max", maxValues[0], maxValues[1], maxValues[2], maxValues[3], maxValues[4]};
            tabMode.addRow(maxFooter);

            Object[] minFooter = {"", "Nilai Min", minValues[0], minValues[1], minValues[2], minValues[3], minValues[4]};
            tabMode.addRow(minFooter);            
            conn.close();
            rs.close();
            ps.close();
            } catch (Exception e) {
                System.out.println("Eror Method DataPenilaianAlternatif");
                e.printStackTrace();
            }
      }
      public void DataPenilaianAlternatif_2(JTable tabel) {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan"};
            DefaultTableModel tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                  Connection conn = new ConnectionDb().connect();

                  // Query untuk mengambil data dari tbl_penilaian
                  String query = "SELECT * FROM tbl_penilaian";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ResultSet rs = ps.executeQuery();

                  // Menyimpan nilai maksimum dan minimum untuk setiap kriteria
                  double[] maxValues = new double[5];
                  double[] minValues = new double[5];
                  for (int i = 0; i < 5; i++) {
                      maxValues[i] = Double.NEGATIVE_INFINITY;
                      minValues[i] = Double.POSITIVE_INFINITY;
                  }

                // Memproses hasil query
                  while (rs.next()) {
                        String idKurir = rs.getString("id_kurir");
                        String namaKurir = rs.getString("nama_kurir");
                        String kesalahanPengiriman = rs.getString("kesalahan_pengiriman");
                        String lamaBekerja = rs.getString("lama_bekerja");
                        String kecepatanPengiriman = rs.getString("kecepatan_pengiriman");
                        String paketDikirimPerbulan = rs.getString("paket_dikirim_perbulan");

                        // Mendapatkan bobot untuk setiap kriteria
                        double bobotKesalahanPengiriman = getBobot(kesalahanPengiriman);
                        double bobotLamaBekerja = getBobot(lamaBekerja);
                        double bobotKecepatanPengiriman = getBobot(kecepatanPengiriman);
                        double bobotPaketDikirimPerbulan = getBobot(paketDikirimPerbulan);

                        // Memperbarui nilai maksimum dan minimum untuk setiap kriteria
                        updateMinMaxValues(maxValues, minValues, bobotKesalahanPengiriman, bobotLamaBekerja, bobotKecepatanPengiriman, bobotPaketDikirimPerbulan);

                        // Menambahkan data ke dalam tabel
                        Object[] data = {idKurir, namaKurir, bobotKesalahanPengiriman, bobotLamaBekerja, bobotKecepatanPengiriman, bobotPaketDikirimPerbulan};
                        tabMode.addRow(data);

            }
            
            conn.close();
            rs.close();
            ps.close();
            } catch (Exception e) {
                System.out.println("Eror Method DataPenilaianAlternatif");
                e.printStackTrace();
            }
            HitungPenilaianAlternatif(tabel, tabMode);
      }

      // Method untuk mendapatkan bobot berdasarkan keterangan
      private static double getBobot(String keterangan) {
            double bobot = 0; // Default value jika tidak ditemukan
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT bobot FROM tbl_sub_kriteria WHERE keterangan = ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, keterangan);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                      bobot = rs.getDouble("bobot");
                  }

                  conn.close();
                  rs.close();
                  ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
          return bobot;
      }

      // Metode untuk mengambil tipe kriteria dari database
      private String[] getCriteriaTypesFromDatabase() {
            String[] criteriaType = new String[4];
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT jenis FROM tbl_kriteria";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ResultSet rs = ps.executeQuery();
                  int index = 0;
                  while (rs.next()) {
                      criteriaType[index] = rs.getString("jenis");
                      System.out.println("Kriteria " + (index + 1) + ": " + criteriaType[index]);
                      index++;
                  }
                  conn.close();
                  rs.close();
                  ps.close();
            } catch (SQLException e) {
                  System.out.println("Error getting criteria types: " + e.getMessage());
            }
            return criteriaType;
      }

      public void HitungPenilaianAlternatif(JTable tabel, DefaultTableModel tab) {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan"};
            tabelNormalisasi = new DefaultTableModel(null, rows);
            tabel.setModel(tabelNormalisasi);

            String[] criteriaType = getCriteriaTypesFromDatabase();
            double[] maxValues = new double[4];
            double[] minValues = new double[4];
            for (int i = 0; i < 4; i++) {
                maxValues[i] = Double.NEGATIVE_INFINITY;
                minValues[i] = Double.POSITIVE_INFINITY;
            }
          
            //print isi dari tabmode
            for (int row = 0; row < tab.getRowCount(); row++) {
              for (int col = 0; col < tab.getColumnCount(); col++) {
                  Object value = tab.getValueAt(row, col);
                  System.out.print(value + "\t");
            }
            System.out.println();
            }

            // Hitung max dan min
            for (int row = 0; row < tab.getRowCount(); row++) {
                  for (int col = 2; col < 6; col++) {
                        Object cellValue = tab.getValueAt(row, col);
                        if (cellValue != null && isNumeric(cellValue.toString())) {
                            double value = Double.parseDouble(cellValue.toString());
                            int criteriaIndex = col - 2;
                            if (value > maxValues[criteriaIndex]) {
                                maxValues[criteriaIndex] = value;
                            }
                            if (value < minValues[criteriaIndex]) {
                                minValues[criteriaIndex] = value;
                            }
                        } else {
                            System.err.println("Non-numeric value in row " + row + ", col " + col + ": " + cellValue);
                        }
                  }
            }

            // Normalisasi dan tambahkan ke tabel normalizedTabMode
            for (int row = 0; row < tab.getRowCount(); row++) {
                double[] normalizedValues = new double[4];
                String idKurir = tab.getValueAt(row, 0).toString();
                String namaKurir = tab.getValueAt(row, 1).toString();

                  for (int col = 2; col < 6; col++) {
                        Object cellValue = tab.getValueAt(row, col);
                        if (cellValue != null && isNumeric(cellValue.toString())) {
                            double value = Double.parseDouble(cellValue.toString());
                            int criteriaIndex = col - 2;

                            if (criteriaType[criteriaIndex].equalsIgnoreCase("Cost")) {
                                normalizedValues[criteriaIndex] = minValues[criteriaIndex] / value;
                            } else {
                                normalizedValues[criteriaIndex] = value / maxValues[criteriaIndex];
                            }

                            // Format nilai ke dua angka di belakang koma
                            String formattedValue = String.format("%.2f", normalizedValues[criteriaIndex]);
                            normalizedValues[criteriaIndex] = Double.parseDouble(formattedValue);
                        } else {
                            normalizedValues[col - 2] = 0; // or handle appropriately for non-numeric values
                            System.err.println("Non-numeric value in row " + row + ", col " + col + ": " + cellValue);
                        }
                  }

                  Object[] dataNormalisasi = {idKurir, namaKurir, String.format("%.2f", normalizedValues[0]), String.format("%.2f", normalizedValues[1]), String.format("%.2f", normalizedValues[2]), String.format("%.2f", normalizedValues[3])};
                  tabelNormalisasi.addRow(dataNormalisasi);
            }


            // Create the footer row with divider values
            String[] footer = new String[6];
            footer[0] = "";
            footer[1] = "Pembobotan";

            PageDataKriteria data = new PageDataKriteria();
            for (int i = 0; i < data.tblKriteria.getRowCount(); i++) {
                footer[i + 2] = data.tblKriteria.getValueAt(i, 2).toString(); // Kolom ke-4 (indeks 3)
            }
            tabelNormalisasi.addRow(footer);
      }     
      // Helper method to check if a string is numeric
      private boolean isNumeric(String str) {
          try {
              Double.parseDouble(str);
              return true;
          } catch (NumberFormatException e) {
              return false;
          }
      }

}

