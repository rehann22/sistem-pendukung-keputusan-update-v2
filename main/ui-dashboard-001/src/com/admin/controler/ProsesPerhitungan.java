package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ProsesPerhitungan {
      
      private DefaultTableModel tabMode;

//      public void TabelPenilaianKurir(JTable tabel) {
//            Object[] rows = {"Id Kurir", "Nama Kurir", "Kecepatan Pengiriman", "Keandalan", "Kepuasan Pelanggan",
//                             "Jumlah Pengiriman Perbulan", "Komunikasi dengan pelanggan", "Disiplin & kehadiran",
//                             "Pemahaman rute", "Tingkat Pengembalian Perbulan"};
//            tabMode = new DefaultTableModel(null, rows);
//            tabel.setModel(tabMode);
//
//            String[] criteriaType = {"benefit", "benefit", "benefit", "benefit", "benefit", "benefit", "benefit", "cost"};
//
//            try {
//                Connection conn = new ConnectionDb().connect();
//                String query = "SELECT * FROM tbl_penilaian";
//                PreparedStatement ps = conn.prepareStatement(query);
//                ResultSet rs = ps.executeQuery();
//
//                double[] maxValues = new double[8];
//                double[] minValues = new double[8];
//                for (int i = 0; i < 8; i++) {
//                    maxValues[i] = Double.NEGATIVE_INFINITY;
//                    minValues[i] = Double.POSITIVE_INFINITY;
//                }
//
//                while (rs.next()) {
//                    String a = rs.getString("id_kurir");
//                    String b = rs.getString("nama_kurir");
//                    double[] values = new double[8];
//                    values[0] = rs.getDouble("kecepatan_pengiriman");
//                    values[1] = rs.getDouble("keandalan");
//                    values[2] = rs.getDouble("kepuasan_pelanggan");
//                    values[3] = rs.getDouble("jml_pengiriman_perbulan");
//                    values[4] = rs.getDouble("komunikasi_dengan_pelanggan");
//                    values[5] = rs.getDouble("disiplin_kehadiran");
//                    values[6] = rs.getDouble("pemahaman_rute");
//                    values[7] = rs.getDouble("tingkat_pengembalian_perbulan");
//
//                    String[] data = {a, b, String.valueOf(values[0]),
//                          String.valueOf(values[1]), 
//                          String.valueOf(values[2]),
//                          String.valueOf(values[3]),
//                          String.valueOf(values[4]),
//                          String.valueOf(values[5]),
//                          String.valueOf(values[6]),
//                          String.valueOf(values[7])};
//                    tabMode.addRow(data);
//
//                    // Update max and min values for normalization
//                    for (int i = 0; i < values.length; i++) {
//                        if (values[i] > maxValues[i]) {
//                            maxValues[i] = values[i];
//                        }
//                        if (values[i] < minValues[i]) {
//                            minValues[i] = values[i];
//                        }
//                    }
//                }
//
//                // Create the footer row with divider values
//                String[] footer = new String[12];
//                footer[0] = "";
//                footer[1] = "Pembagi";
//                for (int i = 0; i < maxValues.length; i++) {
//                    if (criteriaType[i].equalsIgnoreCase("cost")) {
//                        footer[i + 2] = String.valueOf(minValues[i]);
//                    } else {
//                        footer[i + 2] = String.valueOf(maxValues[i]);
//                    }
//                }
//                tabMode.addRow(footer);
//
//                conn.close();
//
//            } catch (SQLException e) {
//                System.out.println("Error dataTabel: " + e.getMessage());
//            }
//      }
      
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
        System.out.println("Error dataTabel: " + e.getMessage());
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



      public void HitungNormalisasi (JTable tabel) {
          Object[] rows = {"Id Kurir", "Nama Kurir", "Kecepatan Pengiriman", "Keandalan", "Kepuasan Pelanggan", 
                           "Jumlah Pengiriman Perbulan", "Komunikasi dengan pelanggan", "Disiplin & kehadiran", 
                           "Pemahaman rute", "Tingkat Pengembalian Perbulan"};
          tabMode = new DefaultTableModel(null, rows);
          tabel.setModel(tabMode);

          String[] criteriaType = {"benefit", "benefit", "benefit", "benefit", "benefit", "benefit", "benefit", "cost"};

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
              conn.close();

          } catch (SQLException e) {
              System.out.println("tabel normalisasi " + e.getMessage());
          }
      }
}
