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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ProsesPerhitungan {

      public DefaultTableModel modelTabelNilaiAlternatif;
      public DefaultTableModel modelTabelNormalisasi;
      public DefaultTableModel modelTabelPembobotan;
      public DefaultTableModel modelTabelPerankingan;

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
            modelTabelNilaiAlternatif = new DefaultTableModel(null, rows);
            tabel.setModel(modelTabelNilaiAlternatif);

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
                        modelTabelNilaiAlternatif.addRow(data);

                  }

            // Menambahkan footer untuk nilai maksimum ("Benefit") dan nilai minimum ("Cost")
            Object[] maxFooter = {"", "Nilai Max", maxValues[0], maxValues[1], maxValues[2], maxValues[3], maxValues[4]};
            modelTabelNilaiAlternatif.addRow(maxFooter);

            Object[] minFooter = {"", "Nilai Min", minValues[0], minValues[1], minValues[2], minValues[3], minValues[4]};
            modelTabelNilaiAlternatif.addRow(minFooter);
            
            conn.close();
            rs.close();
            ps.close();
            } catch (Exception e) {
                System.out.println("Eror Method DataPenilaianAlternatif");
                e.printStackTrace();
            }
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

      public void HitungNormalisasi (JTable tabel) {
            Object[] rows2 = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan"};
            modelTabelNormalisasi = new DefaultTableModel(null, rows2);
            tabel.setModel(modelTabelNormalisasi);

            String[] criteriaType = getCriteriaTypesFromDatabase();
            double[] maxValues = new double[4];
            double[] minValues = new double[4];
            for (int i = 0; i < 4; i++) {
                maxValues[i] = Double.NEGATIVE_INFINITY;
                minValues[i] = Double.POSITIVE_INFINITY;
            }

            // Print isi dari modelTabelNilaiAlternatif
            System.out.println("\nData Penilaian Alternatif");
            for (int row = 0; row < modelTabelNilaiAlternatif.getRowCount() -2 ; row++) {
                for (int col = 2; col < modelTabelNilaiAlternatif.getColumnCount(); col++) {
                    Object value = modelTabelNilaiAlternatif.getValueAt(row, col);
                    System.out.print(value + "\t");
                }
                System.out.println();
            }

            // Mencari nilai maksimal dan minimal untuk setiap kriteria
            for (int row = 0; row < modelTabelNilaiAlternatif.getRowCount(); row++) {
                for (int col = 2; col < 6; col++) {
                    Object cellValue = modelTabelNilaiAlternatif.getValueAt(row, col);
                    if (cellValue != null && isNumeric(cellValue.toString())) {
                        double value = Double.parseDouble(cellValue.toString());
                        int criteriaIndex = col - 2;

                        if (value > maxValues[criteriaIndex]) {
                            maxValues[criteriaIndex] = value;
                        }
                        if (value < minValues[criteriaIndex]) {
                            minValues[criteriaIndex] = value;
                        }
                    }
                }
            }

            // Print nilai maksimal dan minimal untuk setiap kriteria
            System.out.println("\nNilai Maksimal dan Minimal untuk Setiap Kriteria:");
            for (int i = 0; i < 4; i++) {
                System.out.println("Kriteria " + i + ": Max = " + maxValues[i] + ", Min = " + minValues[i]);
            }

            // Normalisasi dan tambahkan ke tabel modelTabelNormalisasi
            for (int row = 0; row < modelTabelNilaiAlternatif.getRowCount() -2 ; row++) {
                  double[] normalizedValues = new double[4];
                  String idKurir = modelTabelNilaiAlternatif.getValueAt(row, 0).toString();
                  String namaKurir = modelTabelNilaiAlternatif.getValueAt(row, 1).toString();

                  for (int col = 2; col < 6; col++) {
                        Object cellValue = modelTabelNilaiAlternatif.getValueAt(row, col);
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
                              normalizedValues[col - 2] = 0; // atau tangani sesuai untuk nilai non-numeric
                              System.err.println("Non-numeric value in row " + row + ", col " + col + ": " + cellValue);
                        }
                  }

                  Object[] dataNormalisasi = {idKurir, namaKurir, String.format("%.2f", normalizedValues[0]), String.format("%.2f", normalizedValues[1]), String.format("%.2f", normalizedValues[2]), String.format("%.2f", normalizedValues[3])};
                  modelTabelNormalisasi.addRow(dataNormalisasi);
            }

            // Buat baris footer dengan nilai pembobotan
            String[] footer = new String[6];
            footer[0] = "";
            footer[1] = "Pembobotan";

            PageDataKriteria data = new PageDataKriteria();
            for (int i = 0; i < data.tblKriteria.getRowCount(); i++) {
                footer[i + 2] = data.tblKriteria.getValueAt(i, 2).toString();
            }
            modelTabelNormalisasi.addRow(footer);

            // Print Hasil normalisasi
            System.out.println("\nHasil Normalisasi:");
            for (int row = 0; row < modelTabelNormalisasi.getRowCount() -2 ; row++) {
                  for (int col = 2; col < modelTabelNormalisasi.getColumnCount(); col++) {
                      Object value = modelTabelNormalisasi.getValueAt(row, col);
                      System.out.print(value + "\t");
                  }
                  System.out.println();
            }
      } 
      
      // Helper method to check if a string is numeric
      private boolean isNumeric(String str) {
            try {
                  Double.parseDouble(str);
                  return true;
            } catch (NumberFormatException e) {
                  System.out.println("not numeric");
                   return false;
            }
      }   

      public void HitungPembobotan (JTable tblHasilPembobotan, JTable tblHasilPerankingan) {
            
            // Model untuk tabel pembobotan
            Object[] hasilPembobotan = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan", "Total"};
            modelTabelPembobotan = new DefaultTableModel(null, hasilPembobotan);
            tblHasilPembobotan.setModel(modelTabelPembobotan);

            // Model untuk tabel peringkat
            Object[] rankingRows = {"Id Kurir", "Nama", "Hasil Perhitungan", "Peringkat"};
            modelTabelPerankingan = new DefaultTableModel(null, rankingRows);
            tblHasilPerankingan.setModel(modelTabelPerankingan);

            // Mendapatkan bobot kriteria
            PageDataKriteria data = new PageDataKriteria();
            int rowCount = data.tblKriteria.getRowCount();
            double[] bobot = new double[rowCount];

            for (int i = 0; i < rowCount; i++) {
                bobot[i] = Double.parseDouble(data.tblKriteria.getValueAt(i, 2).toString());
            }

            // Print array bobot
            System.out.println("\n" + "Bobot");
            for (int i = 0; i < rowCount; i++) {
                System.out.println("Bobot[" + i + "]: " + bobot[i]);
            }

            // Hitung nilai total preferensi
            System.out.println("\n" + "Tabel Normalisasi");
            int rowCount2 = modelTabelNormalisasi.getRowCount(); // Menggunakan rowCount langsung tanpa mengurangi
            if (rowCount2 > 1) { // Pastikan ada baris untuk dihitung
                  List<Object[]> nilaiPreferensiTotal = new ArrayList<>();

                  for (int row = 0; row < rowCount2 - 1; row++) {
                        BigDecimal nilaiPreferensi = BigDecimal.ZERO;
                        String idKurir = modelTabelNormalisasi.getValueAt(row, 0).toString();
                        String namaKurir = modelTabelNormalisasi.getValueAt(row, 1).toString();
                        Object[] weightedValuesRow = new Object[7]; // Menambah kolom untuk Total
                        weightedValuesRow[0] = idKurir;
                        weightedValuesRow[1] = namaKurir;

                        System.out.println("Baris " + row + ":");

                        for (int col = 2; col < 6; col++) { // Loop melalui kolom nilai normalisasi
                              Object cellValue = modelTabelNormalisasi.getValueAt(row, col);
                              if (cellValue != null && isNumeric(cellValue.toString())) {
                                  BigDecimal value = new BigDecimal(cellValue.toString());
                                  BigDecimal weight = BigDecimal.valueOf(bobot[col-2]);
                                  BigDecimal weightedValue = value.multiply(weight); // Perkalian bobot dengan nilai normalisasi
                                  weightedValue = weightedValue.setScale(2, RoundingMode.HALF_UP);
                                  weightedValuesRow[col] = weightedValue; // Simpan weightedValue ke array baris
                                  nilaiPreferensi = nilaiPreferensi.add(weightedValue);
                                  System.out.println("    Nilai: " + value + ", Bobot: " + weight + ", Setelah Perkalian: " + weightedValue);
                              } else {
                                  System.err.println("Non-numeric value in row " + row + ", col " + col + ": " + cellValue);
                              }
                        }
                      
                        //Tambahkan total preferensi ke kolom Total
                        nilaiPreferensi = nilaiPreferensi.setScale(2, RoundingMode.HALF_UP); // Membulatkan nilai preferensi ke dua angka di belakang koma
                        weightedValuesRow[6] = nilaiPreferensi; // Tambahkan total preferensi ke array baris
                        nilaiPreferensiTotal.add(weightedValuesRow); // Simpan nilai preferensi total untuk baris saat ini

                        modelTabelPembobotan.addRow(weightedValuesRow); // Tambahkan baris ke tabel pembobotan

                  }

                  // Mengurutkan nilai preferensi total dari yang terbesar ke terkecil
                  nilaiPreferensiTotal.sort((row1, row2) -> ((BigDecimal) row2[6]).compareTo((BigDecimal) row1[6]));

                  // Menambahkan peringkat ke tabel
                  for (int i = 0; i < nilaiPreferensiTotal.size(); i++) {
                      Object[] row = nilaiPreferensiTotal.get(i);
                      String[] rankingData = {row[0].toString(), row[1].toString(), row[6].toString(), String.valueOf(i + 1)};
                      modelTabelPerankingan.addRow(rankingData);
                  }

                  // Cetak nilai total preferensi untuk setiap baris
                  System.out.println("\n" + "Nilai Preferensi Total untuk Setiap Baris:");
                  for (int row = 0; row < nilaiPreferensiTotal.size(); row++) {
                      System.out.println("Baris " + row + " " + nilaiPreferensiTotal.get(row)[6]);
                  }

            } else {
                System.err.println("Tidak ada data yang tersedia untuk dihitung.");
            }
      }

}


