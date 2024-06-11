package com.admin.controler;

import com.admin.view.PageDataKriteria;
import com.admin.view.PageProsesPerhitungan;
import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class ProsesPerhitungan {
      
      private DefaultTableModel tabMode;
      private DefaultTableModel normalizedTabMode;
      
      static {
        // Atur locale default ke Locale.US
        Locale.setDefault(Locale.US);
       }
      
      public void TabelPenilaianKurir(JTable tabel) {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Kecepatan Pengiriman", "Keandalan", "Kepuasan Pelanggan",
                             "Jumlah Pengiriman Perbulan", "Komunikasi dengan pelanggan", "Disiplin & kehadiran",
                             "Pemahaman rute", "Tingkat Pengembalian Perbulan"};
            tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            // Query untuk mengambil tipe kriteria dari database
            String[] criteriaType = getCriteriaTypesFromDatabase();

            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM tbl_penilaian";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                double[] maxValues = new double[8];
                double[] minValues = new double[8];
                for (int i = 0; i < 8; i++) {
                    maxValues[i] = Double.NEGATIVE_INFINITY;
                    minValues[i] = Double.POSITIVE_INFINITY;
                }

                while (rs.next()) {
                  String a = rs.getString("id_kurir");
                  String b = rs.getString("nama_kurir");
                  double[] values = new double[8];
                  values[0] = rs.getDouble("kecepatan_pengiriman");
                  values[1] = rs.getDouble("keandalan");
                  values[2] = rs.getDouble("kepuasan_pelanggan");
                  values[3] = rs.getDouble("jml_pengiriman_perbulan");
                  values[4] = rs.getDouble("komunikasi_dengan_pelanggan");
                  values[5] = rs.getDouble("disiplin_kehadiran");
                  values[6] = rs.getDouble("pemahaman_rute");
                  values[7] = rs.getDouble("tingkat_pengembalian_perbulan");

                  String[] data = {a, b, String.valueOf(values[0]), String.valueOf(values[1]), String.valueOf(values[2]),
                                   String.valueOf(values[3]), String.valueOf(values[4]), String.valueOf(values[5]),
                                   String.valueOf(values[6]), String.valueOf(values[7])};
                  tabMode.addRow(data);

                  // Update max and min values for normalization
                  for (int i = 0; i < values.length; i++) {
                      if (values[i] > maxValues[i]) {
                          maxValues[i] = values[i];
                      }
                      if (values[i] < minValues[i]) {
                          minValues[i] = values[i];
                      }
                  }
              }

                  // Create the footer row with divider values
                  String[] footer = new String[12];
                  footer[0] = "";
                  footer[1] = "Pembagi";
                  for (int i = 0; i < maxValues.length; i++) {
                      if (criteriaType[i].equalsIgnoreCase("cost")) {
                          footer[i + 2] = String.valueOf(minValues[i]);
                      } else {
                          footer[i + 2] = String.valueOf(maxValues[i]);
                      }
                  }
                  tabMode.addRow(footer);

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
      }

      // Metode untuk mengambil tipe kriteria dari database
      private String[] getCriteriaTypesFromDatabase() {
            String[] criteriaType = new String[8];
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT jenis FROM tbl_kriteria";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                int index = 0;
                while (rs.next()) {
                    criteriaType[index++] = rs.getString("jenis");
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error getting criteria types: " + e.getMessage());
            }
            return criteriaType;
      }



      public void HitungNormalisasi(JTable normalizedTabel) {
            Object[] normalizedRows = {"Id Kurir", "Nama Kurir", "Kecepatan Pengiriman", "Keandalan", "Kepuasan Pelanggan",
                                       "Jumlah Pengiriman Perbulan", "Komunikasi dengan pelanggan", "Disiplin & kehadiran",
                                       "Pemahaman rute", "Tingkat Pengembalian Perbulan"};
            normalizedTabMode = new DefaultTableModel(null, normalizedRows);
            normalizedTabel.setModel(normalizedTabMode);

            String[] criteriaType = getCriteriaTypesFromDatabase();
            double[] maxValues = new double[8];
            double[] minValues = new double[8];
            for (int i = 0; i < 8; i++) {
                maxValues[i] = Double.NEGATIVE_INFINITY;
                minValues[i] = Double.POSITIVE_INFINITY;
            }

            // Hitung max dan min
            for (int row = 0; row < tabMode.getRowCount(); row++) {
                  for (int col = 2; col < 10; col++) {
                      double value = Double.parseDouble(tabMode.getValueAt(row, col).toString());
                      int criteriaIndex = col - 2;
                      if (value > maxValues[criteriaIndex]) {
                          maxValues[criteriaIndex] = value;
                      }
                      if (value < minValues[criteriaIndex]) {
                          minValues[criteriaIndex] = value;
                      }
                }
            }

            // Normalisasi dan tambahkan ke tabel normalizedTabMode
            for (int row = 0; row < tabMode.getRowCount(); row++) {
                double[] normalizedValues = new double[8];
                String idKurir = tabMode.getValueAt(row, 0).toString();
                String namaKurir = tabMode.getValueAt(row, 1).toString();

             for (int col = 2; col < 10; col++) {
                 double value = Double.parseDouble(tabMode.getValueAt(row, col).toString());
                 int criteriaIndex = col - 2;

                  if (criteriaType[criteriaIndex].equalsIgnoreCase("cost")) {
                      normalizedValues[criteriaIndex] = minValues[criteriaIndex] / value;
                  } else {
                      normalizedValues[criteriaIndex] = value / maxValues[criteriaIndex];
                  }
             }

                  String[] normalizedData = {idKurir, namaKurir, 
                                             String.format("%.2f", normalizedValues[0]), 
                                             String.format("%.2f", normalizedValues[1]),
                                             String.format("%.2f", normalizedValues[2]), 
                                             String.format("%.2f", normalizedValues[3]),
                                             String.format("%.2f", normalizedValues[4]), 
                                             String.format("%.2f", normalizedValues[5]),
                                             String.format("%.2f", normalizedValues[6]), 
                                             String.format("%.2f", normalizedValues[7])};
                  normalizedTabMode.addRow(normalizedData);

            }
            
            // Hapus baris terakhir (footer) dari model normalizedTabMode
            if (normalizedTabMode.getRowCount() > 0) {
                normalizedTabMode.removeRow(normalizedTabMode.getRowCount() - 1);

                  // Create the footer row with divider values
                  String[] footer = new String[12];
                  footer[0] = "";
                  footer[1] = "Pembobotan";

                  PageDataKriteria data = new PageDataKriteria();
                  for (int i = 0; i < data.tblKriteria.getRowCount(); i++) {
                         footer[i + 2] = data.tblKriteria.getValueAt(i, 4).toString(); // Kolom ke-4 (indeks 3)
                  }
                  normalizedTabMode.addRow(footer);  
            }  
      }
      
   public void HasilTotalNormalisasi (JTable tabelPerankingan) {
      Object[] rankingRows = {"Id Kurir", "Nama", "Hasil Perhitungan"};
      DefaultTableModel rankingTabMode = new DefaultTableModel(null, rankingRows);
      tabelPerankingan.setModel(rankingTabMode);

      String[] criteriaType = getCriteriaTypesFromDatabase();
      PageDataKriteria data = new PageDataKriteria();
      int rowCount = data.tblKriteria.getRowCount();
      double[] bobot = new double[rowCount - 1]; // Mengurangi 1 untuk mengabaikan baris terakhir

      for (int i = 0; i < rowCount - 1; i++) { // Mengubah batas iterasi
          bobot[i] = Double.parseDouble(data.tblKriteria.getValueAt(i, 4).toString());
      }

      // Print array bobot
      for (int i = 0; i < rowCount - 1; i++) {
          System.out.println("Bobot[" + i + "]: " + bobot[i]);
      }

      // Hitung nilai total preferensi
      int rowCount2 = normalizedTabMode.getRowCount();
      double[] nilaiPreferensiTotal = new double[rowCount2 - 1]; // Inisialisasi array untuk menyimpan nilai total preferensi untuk setiap baris
      for (int row = 0; row < rowCount2 - 1; row++) { 
            double nilaiPreferensi = 0;
            for (int col = 2; col < 10; col++) { // Loop melalui kolom nilai normalisasi
                double value = Double.parseDouble(normalizedTabMode.getValueAt(row, col).toString());
                nilaiPreferensi += bobot[col - 2] * value; // Perkalian bobot dengan nilai normalisasi
            }
            nilaiPreferensiTotal[row] = nilaiPreferensi; // Simpan nilai preferensi total untuk baris saat ini
            String idKurir = normalizedTabMode.getValueAt(row, 0).toString();
            String namaKurir = normalizedTabMode.getValueAt(row, 1).toString();

            // Membulatkan nilai preferensi menjadi dua angka di belakang koma
            double scaledValue = nilaiPreferensi * 100; // Memindahkan dua angka di belakang koma ke digit pertama
            double roundedValue;
                  if ((scaledValue % 10) > 5) { // Jika digit ketiga > 5, bulatkan ke atas
                      roundedValue = Math.ceil(scaledValue / 10); // Bulatkan ke atas
                  } else {
                      roundedValue = Math.floor(scaledValue / 10); // Biarkan saja
                        }
                // Kembalikan ke dua angka desimal
                double roundedValueInDecimal = roundedValue / 100;

            // Tambahkan data ke tabel dengan nilai nilaiPreferensiTotal
            String[] rankingData = {idKurir, namaKurir, String.format("%.2f", nilaiPreferensiTotal[row])};
            rankingTabMode.addRow(rankingData);
      }

      // Cetak nilai total preferensi untuk setiap baris
      System.out.println("Nilai Preferensi Total untuk Setiap Baris:");
      for (int row = 0; row < rowCount2 - 1; row++) { // Iterasi hingga baris sebelum baris terakhir
          System.out.println("Baris " + row + ": " + String.format("%.2f", nilaiPreferensiTotal[row]));
      }
      
      // Atur lebar kolom
    TableColumnModel columnModel = tabelPerankingan.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(70); // Id Kurir
    columnModel.getColumn(1).setPreferredWidth(150); // Nama
    columnModel.getColumn(2).setPreferredWidth(100); // Hasil Perhitungan

   }
   
 public void HasilPerankingan(JTable tabelPerankingan) {
    Object[] rankingRows = {"Ranking", "Id Kurir", "Nama", "Skor"};
    DefaultTableModel rankingTabMode = new DefaultTableModel(null, rankingRows);
    tabelPerankingan.setModel(rankingTabMode);

    PageDataKriteria data = new PageDataKriteria();
    int rowCount = data.tblKriteria.getRowCount();
    double[] bobot = new double[rowCount - 1]; // Mengurangi 1 untuk mengabaikan baris terakhir

    for (int i = 0; i < rowCount - 1; i++) { // Mengubah batas iterasi
        bobot[i] = Double.parseDouble(data.tblKriteria.getValueAt(i, 4).toString());
    }

    int rowCount2 = normalizedTabMode.getRowCount();
    List<String[]> dataList = new ArrayList<>(); // List untuk menyimpan data sementara

    for (int row = 0; row < rowCount2 - 1; row++) {
        double nilaiPreferensi = 0;
        for (int col = 2; col < 10; col++) { // Loop melalui kolom nilai normalisasi
            double value = Double.parseDouble(normalizedTabMode.getValueAt(row, col).toString());
            nilaiPreferensi += bobot[col - 2] * value; // Perkalian bobot dengan nilai normalisasi
        }

        String idKurir = normalizedTabMode.getValueAt(row, 0).toString();
        String namaKurir = normalizedTabMode.getValueAt(row, 1).toString();

        // Membulatkan nilai preferensi menjadi dua angka di belakang koma
        double scaledValue = nilaiPreferensi * 100; // Memindahkan dua angka di belakang koma ke digit pertama
        double roundedValue;
        if (scaledValue % 1 >= 0.5) { // Jika digit ketiga > 5, bulatkan ke atas
            roundedValue = Math.ceil(scaledValue); // Bulatkan ke atas
        } else {
            roundedValue = Math.floor(scaledValue); // Biarkan saja
        }
        // Kembalikan ke dua angka desimal
        double roundedValueInDecimal = roundedValue / 100;

        // Simpan data dalam list dengan nilai preferensi yang sudah dibulatkan
        String[] rankingData = {idKurir, namaKurir, String.format("%.2f", roundedValueInDecimal)};
        dataList.add(rankingData);
    }

    // Urutkan dataList berdasarkan nilai preferensi secara menurun
    dataList.sort((a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2])));

    // Tambahkan data yang diurutkan ke tabel dengan kolom Ranking
    int ranking = 1;
    for (String[] rowData : dataList) {
        String[] rowWithRanking = {String.valueOf(ranking), rowData[0], rowData[1], rowData[2]};
        rankingTabMode.addRow(rowWithRanking);
        ranking++;
    }

    // Atur lebar kolom
    TableColumnModel columnModel = tabelPerankingan.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(40);  // Ranking
    columnModel.getColumn(1).setPreferredWidth(50); // Id Kurir
    columnModel.getColumn(2).setPreferredWidth(150); // Nama
    columnModel.getColumn(3).setPreferredWidth(50); // skor

    // Cetak nilai total preferensi untuk setiap baris (optional)
    System.out.println("Nilai Preferensi Total untuk Setiap Baris:");
    for (int row = 0; row < rowCount2 - 1; row++) { // Iterasi hingga baris sebelum baris terakhir
        System.out.println("Baris " + row + ": " + String.format("%.2f", Double.parseDouble(dataList.get(row)[2])));
    }
}
}






