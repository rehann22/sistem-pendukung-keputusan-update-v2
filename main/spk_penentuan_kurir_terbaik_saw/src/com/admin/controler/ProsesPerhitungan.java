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

      public DefaultTableModel modelTabelBobotSubCriteria;
      public DefaultTableModel modelTabelNormalisasi;
      public DefaultTableModel modelTabelPreferensi;
      public DefaultTableModel modelTabelPerankingan;

      static {
            // Atur locale default ke Locale.US
            Locale.setDefault(Locale.US);
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

      private double getDoubleValue(Object value) {
            if (value instanceof Number) {
                  return ((Number) value).doubleValue();
            }
            return 0;
      }

      private double getBobotPresensi(double presensi) {
            if (presensi <= 15) {
                  return 1;
            }
            if (presensi <= 25) {
                  return 2;
            }
            if (presensi >= 26) {
                  return 3;
            }
            return 0;
      }

      private double getBobotKecepatanPengiriman(double kecepatanPengiriman) {
            if (kecepatanPengiriman > 3) {
                  return 1;
            }
            if (kecepatanPengiriman < 4) {
                  return 2;
            }
            return 0;
      }

      private double getBobotPengirimanBerhasil(double pengirimanBerhasil) {
            if (pengirimanBerhasil >= 500 && pengirimanBerhasil <= 1000) {
                  return 1;
            }
            if (pengirimanBerhasil > 1000 && pengirimanBerhasil <= 1500) {
                  return 2;
            }
            if (pengirimanBerhasil > 1500 && pengirimanBerhasil <= 2000) {
                  return 3;
            }
            if (pengirimanBerhasil > 2000 && pengirimanBerhasil <= 2500) {
                  return 4;
            }
            return 0;
      }

      private double getBobotPengirimanGagal(double pengirimanGagal) {
            if (pengirimanGagal >= 10 && pengirimanGagal <= 60) {
                  return 1;
            }
            if (pengirimanGagal > 60 && pengirimanGagal <= 110) {
                  return 2;
            }
            if (pengirimanGagal > 110 && pengirimanGagal <= 160) {
                  return 3;
            }
            if (pengirimanGagal > 160 && pengirimanGagal <= 220) {
                  return 4;
            }
            return 0;
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

      public void BobotPenilaianAlternatif(DefaultTableModel tableModelUpload, JTable tabel) {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Presensi", "Waktu Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal"};
            modelTabelBobotSubCriteria = new DefaultTableModel(null, rows);
            tabel.setModel(modelTabelBobotSubCriteria);

            try {
                  double[] maxValues = new double[4];
                  double[] minValues = new double[4];
                  for (int i = 0; i < 4; i++) {
                        maxValues[i] = Double.NEGATIVE_INFINITY;
                        minValues[i] = Double.POSITIVE_INFINITY;
                  }

                  if (tableModelUpload == null) {
                        System.out.println("modelTabelUploadData is null");
                        return;
                  }

                  // looping dari tab.tblDataUpload dimulai dari kolom ke 2 dan cek setiap nilainya jika nilai sesuai
                  for (int row = 0; row < tableModelUpload.getRowCount(); row++) {
                        String idKurir = (String) tableModelUpload.getValueAt(row, 0);
                        String namaKurir = (String) tableModelUpload.getValueAt(row, 1);
                        double presensi = getDoubleValue(tableModelUpload.getValueAt(row, 2));
                        double kecepatanPengiriman = getDoubleValue(tableModelUpload.getValueAt(row, 3));
                        double pengirimanBerhasil = getDoubleValue(tableModelUpload.getValueAt(row, 4));
                        double pengirimanGagal = getDoubleValue(tableModelUpload.getValueAt(row, 5));

                        double bobotPresensi = getBobotPresensi(presensi);
                        double bobotKecepatanPengiriman = getBobotKecepatanPengiriman(kecepatanPengiriman);
                        double bobotPengirimanBerhasil = getBobotPengirimanBerhasil(pengirimanBerhasil);
                        double bobotPengirimanGagal = getBobotPengirimanGagal(pengirimanGagal);

                        updateMinMaxValues(maxValues, minValues, bobotPresensi, bobotKecepatanPengiriman, bobotPengirimanBerhasil, bobotPengirimanGagal);

                        Object[] data = {idKurir, namaKurir, bobotPresensi, bobotKecepatanPengiriman, bobotPengirimanBerhasil, bobotPengirimanGagal};
                        modelTabelBobotSubCriteria.addRow(data);
                  }

                  Object[] maxFooter = {"", "NILAI MAX", maxValues[0], maxValues[1], maxValues[2], maxValues[3]};
                  modelTabelBobotSubCriteria.addRow(maxFooter);

                  Object[] minFooter = {"", "NILAI MIN", minValues[0], minValues[1], minValues[2], minValues[3]};
                  modelTabelBobotSubCriteria.addRow(minFooter);

            } catch (Exception e) {
                  System.out.println("Eror Method DataPenilaianAlternatif");
                  e.printStackTrace();
            }
      }

      public void HitungNormalisasi(JTable tabel) {
            Object[] rows2 = {"Id Kurir", "Nama Kurir", "Presensi", "Waktu Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal"};
            modelTabelNormalisasi = new DefaultTableModel(null, rows2);
            tabel.setModel(modelTabelNormalisasi);

            String[] criteriaType = getCriteriaTypesFromDatabase();
            double[] maxValues = new double[4];
            double[] minValues = new double[4];
            for (int i = 0; i < 4; i++) {
                  maxValues[i] = Double.NEGATIVE_INFINITY;
                  minValues[i] = Double.POSITIVE_INFINITY;
            }

            if (modelTabelBobotSubCriteria == null) {
                  System.out.println("tabel kosong");
                  return;
            }

            // Print isi dari modelTabelBobotSubCriteria
            System.out.println("\nData Penilaian Alternatif");
            for (int row = 0; row < modelTabelBobotSubCriteria.getRowCount() - 2; row++) {
                  for (int col = 2; col < modelTabelBobotSubCriteria.getColumnCount(); col++) {
                        Object value = modelTabelBobotSubCriteria.getValueAt(row, col);
                        System.out.print(value + "\t");
                  }
                  System.out.println();
            }

            // Mencari nilai maksimal dan minimal untuk setiap kriteria
            for (int row = 0; row < modelTabelBobotSubCriteria.getRowCount(); row++) {
                  for (int col = 2; col < 6; col++) {
                        Object cellValue = modelTabelBobotSubCriteria.getValueAt(row, col);
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
            for (int row = 0; row < modelTabelBobotSubCriteria.getRowCount() - 2; row++) {
                  double[] normalizedValues = new double[4];
                  String idKurir = modelTabelBobotSubCriteria.getValueAt(row, 0).toString();
                  String namaKurir = modelTabelBobotSubCriteria.getValueAt(row, 1).toString();

                  for (int col = 2; col < 6; col++) {
                        Object cellValue = modelTabelBobotSubCriteria.getValueAt(row, col);
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
            footer[1] = "BOBOT";

            PageDataKriteria data = new PageDataKriteria();
            for (int i = 0; i < data.tblKriteria.getRowCount(); i++) {
                  footer[i + 2] = data.tblKriteria.getValueAt(i, 2).toString();
            }
            modelTabelNormalisasi.addRow(footer);

            // Print Hasil normalisasi
            System.out.println("\nHasil Normalisasi:");
            for (int row = 0; row < modelTabelNormalisasi.getRowCount() - 2; row++) {
                  for (int col = 2; col < modelTabelNormalisasi.getColumnCount(); col++) {
                        Object value = modelTabelNormalisasi.getValueAt(row, col);
                        System.out.print(value + "\t");
                  }
                  System.out.println();
            }
      }

      public void HitungNilaiPreferensi(JTable tblHasilPembobotan, JTable tblHasilPerankingan) {

            // Model untuk tabel pembobotan
            Object[] hasilPembobotan = {"Id Kurir", "Nama Kurir", "Presensi", "Waktu Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal", "Total"};
            modelTabelPreferensi = new DefaultTableModel(null, hasilPembobotan);
            tblHasilPembobotan.setModel(modelTabelPreferensi);

            // Model untuk tabel peringkat
            Object[] rankingRows = {"Id Kurir", "Nama", "Nilai", "Peringkat"};
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
                                    BigDecimal weight = BigDecimal.valueOf(bobot[col - 2]);
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

                        modelTabelPreferensi.addRow(weightedValuesRow); // Tambahkan baris ke tabel pembobotan

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
