package com.admin.debug;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SAWNormalizationFromDatabase {
      public static void main(String[] args) {
          // Tipe kriteria (benefit atau cost)
          String[] criteriaType = {"benefit", "benefit", "benefit", "benefit", "benefit", "benefit", "benefit", "cost"};

          Connection conn = null;
          PreparedStatement ps = null;
          ResultSet rs = null;

          try {
              conn = new ConnectionDb().connect();
              if (conn == null) {
                  System.out.println("Failed to make connection!");
                  return;
              }

              String query = "SELECT kecepatan_pengiriman, keandalan, kepuasan_pelanggan, jml_pengiriman_perbulan, " +
                         "komunikasi_dengan_pelanggan, disiplin_kehadiran, pemahaman_rute, tingkat_pengembalian_perbulan " +
                         "FROM tbl_penilaian";

              // Membuat PreparedStatement dengan ResultSet yang dapat digulir
              ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              rs = ps.executeQuery();

              // Menghitung jumlah baris data
              rs.last();
              int rows = rs.getRow();
              rs.beforeFirst();

              // Mengambil data dari ResultSet
              double[][] data = new double[rows][8];
              int row = 0;
              while (rs.next()) {
                  data[row][0] = rs.getDouble("kecepatan_pengiriman");
                  data[row][1] = rs.getDouble("keandalan");
                  data[row][2] = rs.getDouble("kepuasan_pelanggan");
                  data[row][3] = rs.getDouble("jml_pengiriman_perbulan");
                  data[row][4] = rs.getDouble("komunikasi_dengan_pelanggan");
                  data[row][5] = rs.getDouble("disiplin_kehadiran");
                  data[row][6] = rs.getDouble("pemahaman_rute");
                  data[row][7] = rs.getDouble("tingkat_pengembalian_perbulan");
                  row++;
              }

              // Menutup koneksi database
              rs.close();
              ps.close();
              conn.close();

              // Normalisasi data
              double[][] normalizedData = normalizeData(data, criteriaType);

              // Cetak data yang sudah dinormalisasi
              System.out.println("Data yang sudah dinormalisasi:");
              for (double[] normalizedRow : normalizedData) {
                  for (double value : normalizedRow) {
                      System.out.printf("%.3f\t", value);
                  }
                  System.out.println();
              }

          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              try {
                  if (rs != null) rs.close();
                  if (ps != null) ps.close();
                  if (conn != null) conn.close();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      }

      // Metode untuk melakukan normalisasi data
      public static double[][] normalizeData(double[][] data, String[] criteriaType) {
          int rows = data.length;
          int cols = data[0].length;
          double[][] normalizedData = new double[rows][cols];

          for (int j = 0; j < cols; j++) {
              double max = Double.NEGATIVE_INFINITY;
              double min = Double.POSITIVE_INFINITY;

              for (int i = 0; i < rows; i++) {
                  if (data[i][j] > max) max = data[i][j];
                  if (data[i][j] < min) min = data[i][j];
              }

              for (int i = 0; i < rows; i++) {
                  if (criteriaType[j].equalsIgnoreCase("benefit")) {
                      normalizedData[i][j] = data[i][j] / max;
                  } else if (criteriaType[j].equalsIgnoreCase("cost")) {
                      normalizedData[i][j] = min / data[i][j];
                  }
              }
          }

          return normalizedData;
      }
}


