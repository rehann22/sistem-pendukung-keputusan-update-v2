package com.admin.controler;

import com.admin.view.PageDataKriteria;
import com.admin.view.PageProsesPerhitungan;
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

      public DefaultTableModel tabMode;
      public DefaultTableModel tabelNormalisasi;
      public DefaultTableModel tabelPembobotan;

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

      public void HitungPenilaianAlternatif (JTable tabel) {
            //Tabel Data Penilaian Alternatif
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
            } catch (Exception e) {
                System.out.println("Eror Method DataPenilaianAlternatif");
                e.printStackTrace();
            }
            
            
            //Tabel Normalisasi
            Object[] rows2 = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan"};
            tabelNormalisasi = new DefaultTableModel(null, rows2);
            tabel.setModel(tabelNormalisasi);

            String[] criteriaType = getCriteriaTypesFromDatabase();
            double[] maxValues = new double[4];
            double[] minValues = new double[4];
            for (int i = 0; i < 4; i++) {
                maxValues[i] = Double.NEGATIVE_INFINITY;
                minValues[i] = Double.POSITIVE_INFINITY;
            }
          
            //print isi dari tabmode
            System.out.println("\n"+"Data Penilaian Alternatif");
            for (int row = 0; row < tabMode.getRowCount(); row++) {
              for (int col = 2; col < tabMode.getColumnCount(); col++) {
                  Object value = tabMode.getValueAt(row, col);
                  System.out.print(value + "\t");
            }
            System.out.println();
            }

            // Hitung max dan min
            for (int row = 0; row < tabMode.getRowCount(); row++) {
                  for (int col = 2; col < 6; col++) {
                        Object cellValue = tabMode.getValueAt(row, col);
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
            for (int row = 0; row < tabMode.getRowCount(); row++) {
                double[] normalizedValues = new double[4];
                String idKurir = tabMode.getValueAt(row, 0).toString();
                String namaKurir = tabMode.getValueAt(row, 1).toString();

                  for (int col = 2; col < 6; col++) {
                        Object cellValue = tabMode.getValueAt(row, col);
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
                footer[i + 2] = data.tblKriteria.getValueAt(i, 2).toString(); 
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
      
//      public void HasilNormalisasi(JTable tabel) {
//            Object[] totalPembotan = {"Id Kurir", "Nama", "Hasil Perhitungan"};
//            DefaultTableModel rankingTabMode = new DefaultTableModel(null, totalPembotan);
//            tabel.setModel(rankingTabMode);
//            
//            PageDataKriteria data = new PageDataKriteria();
//            int rowCount = data.tblKriteria.getRowCount();
//            double[] bobot = new double[rowCount];
//
//            for (int i = 0; i < rowCount; i++) {
//                bobot[i] = Double.parseDouble(data.tblKriteria.getValueAt(i, 2).toString());
//            }
//
//            // Print array bobot
//            System.out.println("\n" + "Bobot");
//            for (int i = 0; i < rowCount; i++) {
//                System.out.println("Bobot[" + i + "]: " + bobot[i]);
//            }
//
//            // Hitung nilai total preferensi
//            System.out.println("\n" + "Tabel Normalisasi");
//            int rowCount2 = tabelNormalisasi.getRowCount() - 1; // Mengurangi 1 karena baris terakhir adalah footer
//            BigDecimal[] nilaiPreferensiTotal = new BigDecimal[rowCount2]; // Inisialisasi array untuk menyimpan nilai total preferensi untuk setiap baris
//
//            for (int row = 0; row < rowCount2; row++) {
//                  BigDecimal nilaiPreferensi = BigDecimal.ZERO;
//                  for (int col = 2; col <= 5; col++) { // Loop melalui kolom nilai normalisasi
//                      Object cellValue = tabelNormalisasi.getValueAt(row, col);
//                      if (cellValue != null && isNumeric(cellValue.toString())) {
//                        BigDecimal value = new BigDecimal(cellValue.toString());
//                        BigDecimal weight = BigDecimal.valueOf(bobot[col - 2]);
////                          nilaiPreferensi = nilaiPreferensi.add(value.multiply(weight)); // Perkalian bobot dengan nilai normalisasi
////                          System.out.print(value + "\t");
//                        BigDecimal weightedValue = value.multiply(weight); // Perkalian bobot dengan nilai normalisasi
//                        nilaiPreferensi = nilaiPreferensi.add(weightedValue);
//                        System.out.print(value + "*" + weight + " = " + weightedValue + "\t");
//                          
//                      } else {
//                          System.err.println("Non-numeric value in row " + row + ", col " + col + ": " + cellValue);
//                      }
//                  }
//                  System.out.println("");
//                  nilaiPreferensi = nilaiPreferensi.setScale(2, RoundingMode.HALF_UP); // Membulatkan nilai preferensi ke dua angka di belakang koma
//                  nilaiPreferensiTotal[row] = nilaiPreferensi; // Simpan nilai preferensi total untuk baris saat ini
//                  String idKurir = tabelNormalisasi.getValueAt(row, 0).toString();
//                  String namaKurir = tabelNormalisasi.getValueAt(row, 1).toString();
//
//                  // Tambahkan data ke tabel dengan nilai nilaiPreferensiTotal
//                  String[] rankingData = {idKurir, namaKurir, nilaiPreferensi.toString()};
//                  rankingTabMode.addRow(rankingData);
//            }
//            
//            // Cetak nilai total preferensi untuk setiap baris
//            System.out.println("\n" + "Nilai Preferensi Total untuk Setiap Baris:");
//            for (int row = 0; row < rowCount2; row++) {
//                System.out.println("Baris " + row + " " + nilaiPreferensiTotal[row]);
//            }
//      }
      
//      public void HasilNormalisasi(JTable tabel, JTable tabelPembobotan) {
//
//            // Model untuk tabel pembobotan
//            Object[] hasilPembobotan = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan", "Total"};
//            DefaultTableModel pembobotanTabmode = new DefaultTableModel(null, hasilPembobotan);
//            tabelPembobotan.setModel(pembobotanTabmode);
//            
//            Object[] rankingRows = {"Id Kurir", "Nama", "Hasil Perhitungan", "Peringkat"};
//            DefaultTableModel rankingTabMode = new DefaultTableModel(null, rankingRows);
//            tabel.setModel(rankingTabMode);
//            
//            //nomor peringkat
//            PageProsesPerhitungan tab= new PageProsesPerhitungan();
//            int peringkat = 1;
//            for (peringkat; peringkat <= tab.tabelPerankingan.getRowCount(); peringkat ++) {
//                  System.out.println(peringkat);
//            }
//
//            PageDataKriteria data = new PageDataKriteria();
//            int rowCount = data.tblKriteria.getRowCount();
//            double[] bobot = new double[rowCount];
//
//            for (int i = 0; i < rowCount; i++) {
//                bobot[i] = Double.parseDouble(data.tblKriteria.getValueAt(i, 2).toString());
//            }
//
//            // Print array bobot
//            System.out.println("\n" + "Bobot");
//            for (int i = 0; i < rowCount; i++) {
//                System.out.println("Bobot[" + i + "]: " + bobot[i]);
//            }
//
//            // Hitung nilai total preferensi
//            System.out.println("\n" + "Tabel Normalisasi");
//            int rowCount2 = tabelNormalisasi.getRowCount(); // Menggunakan rowCount langsung tanpa mengurangi
//            if (rowCount2 > 1) { // Pastikan ada baris untuk dihitung
//                BigDecimal[] nilaiPreferensiTotal = new BigDecimal[rowCount2 - 1]; // Mengurangi 1 karena baris terakhir adalah footer
//
//                  for (int row = 0; row < rowCount2 - 1; row++) {
//                      BigDecimal nilaiPreferensi = BigDecimal.ZERO;
//                      String idKurir = tabelNormalisasi.getValueAt(row, 0).toString();
//                      String namaKurir = tabelNormalisasi.getValueAt(row, 1).toString();
//                      Object[] weightedValuesRow = new Object[6];
//                      weightedValuesRow[0] = idKurir;
//                      weightedValuesRow[1] = namaKurir;
//
//                      System.out.println("Baris " + row + ":");
//
//                        for (int col = 2; col <= 5; col++) { // Loop melalui kolom nilai normalisasi
//                            Object cellValue = tabelNormalisasi.getValueAt(row, col);
//                            if (cellValue != null && isNumeric(cellValue.toString())) {
//                                BigDecimal value = new BigDecimal(cellValue.toString());
//                                BigDecimal weight = BigDecimal.valueOf(bobot[col-2]);
//                                BigDecimal weightedValue = value.multiply(weight); // Perkalian bobot dengan nilai normalisasi
//                                weightedValue = weightedValue.setScale(2, RoundingMode.HALF_UP);
//                                weightedValuesRow[col] = weightedValue; // Simpan weightedValue ke array baris
//                                nilaiPreferensi = nilaiPreferensi.add(weightedValue);
//                                System.out.println("    Nilai: " + value + ", Bobot: " + weight + ", Setelah Perkalian: " + weightedValue);
//                            } else {
//                                System.err.println("Non-numeric value in row " + row + ", col " + col + ": " + cellValue);
//                            }
//                        }
//                      System.out.println("");
//
//                      pembobotanTabmode.addRow(weightedValuesRow); // Tambahkan baris ke tabel pembobotan
//
//                      nilaiPreferensi = nilaiPreferensi.setScale(2, RoundingMode.HALF_UP); // Membulatkan nilai preferensi ke dua angka di belakang koma
//                      nilaiPreferensiTotal[row] = nilaiPreferensi; // Simpan nilai preferensi total untuk baris saat ini
//
//                      // Tambahkan data ke tabel dengan nilai nilaiPreferensiTotal
//                      String[] rankingData = {idKurir, namaKurir, nilaiPreferensi.toString(), String.valueOf(peringkat)};
//                      rankingTabMode.addRow(rankingData);
//                  }
//
//                  // Cetak nilai total preferensi untuk setiap baris
//                  System.out.println("\n" + "Nilai Preferensi Total untuk Setiap Baris:");
//                  for (int row = 0; row < rowCount2 - 1; row++) {
//                  System.out.println("Baris " + row + " " + nilaiPreferensiTotal[row]);
//                }
//            } else {
//                System.err.println("Tidak ada data yang tersedia untuk dihitung.");
//            }
//      }
      
   

    public void HasilNormalisasi(JTable tblHasilPembobotan, JTable tabelPerankingan) {

        // Model untuk tabel pembobotan
        Object[] hasilPembobotan = {"Id Kurir", "Nama Kurir", "Kesalahan Pengiriman", "Lama Bekerja", "Kecepatan Pengiriman", "Paket Dikirim / Bulan", "Total"};
        DefaultTableModel pembobotanTabmode = new DefaultTableModel(null, hasilPembobotan);
        tblHasilPembobotan.setModel(pembobotanTabmode);
        
        // Model untuk tabel peringkat
        Object[] rankingRows = {"Id Kurir", "Nama", "Hasil Perhitungan", "Peringkat"};
        DefaultTableModel rankingTabMode = new DefaultTableModel(null, rankingRows);
        tabelPerankingan.setModel(rankingTabMode);
        
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
        int rowCount2 = tabelNormalisasi.getRowCount(); // Menggunakan rowCount langsung tanpa mengurangi
        if (rowCount2 > 1) { // Pastikan ada baris untuk dihitung
            //BigDecimal[] nilaiPreferensiTotal = new BigDecimal[rowCount2 - 1]; // Mengurangi 1 karena baris terakhir adalah footer
            List<Object[]> nilaiPreferensiTotal = new ArrayList<>();
            
            for (int row = 0; row < rowCount2 - 1; row++) {
                BigDecimal nilaiPreferensi = BigDecimal.ZERO;
                String idKurir = tabelNormalisasi.getValueAt(row, 0).toString();
                String namaKurir = tabelNormalisasi.getValueAt(row, 1).toString();
                Object[] weightedValuesRow = new Object[7]; // Menambah kolom untuk Total
                weightedValuesRow[0] = idKurir;
                weightedValuesRow[1] = namaKurir;

                System.out.println("Baris " + row + ":");

                for (int col = 2; col <= 5; col++) { // Loop melalui kolom nilai normalisasi
                    Object cellValue = tabelNormalisasi.getValueAt(row, col);
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

                // Tambahkan total preferensi ke kolom Total
               // Tambahkan total preferensi ke kolom Total
                nilaiPreferensi = nilaiPreferensi.setScale(2, RoundingMode.HALF_UP); // Membulatkan nilai preferensi ke dua angka di belakang koma
                weightedValuesRow[6] = nilaiPreferensi; // Tambahkan total preferensi ke array baris
                nilaiPreferensiTotal.add(weightedValuesRow); // Simpan nilai preferensi total untuk baris saat ini

                pembobotanTabmode.addRow(weightedValuesRow); // Tambahkan baris ke tabel pembobotan
            }

            // Mengurutkan nilai preferensi total dari yang terbesar ke terkecil
            nilaiPreferensiTotal.sort((row1, row2) -> ((BigDecimal) row2[6]).compareTo((BigDecimal) row1[6]));

            // Menambahkan peringkat ke tabel
            for (int i = 0; i < nilaiPreferensiTotal.size(); i++) {
                Object[] row = nilaiPreferensiTotal.get(i);
                String[] rankingData = {row[0].toString(), row[1].toString(), row[6].toString(), String.valueOf(i + 1)};
                rankingTabMode.addRow(rankingData);
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


