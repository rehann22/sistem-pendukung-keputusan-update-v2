
package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PenilaianKurir {
      private DefaultTableModel tabMode;

      
      public void TabelPenilaian(JTable tabel) {
          Object[] rows = {"Id Kurir", "Nama Kurir", "Kecepatan Pengiriman", "Keandalan", "Kepuasan Pelanggan", "Jumlah Pengiriman Perbulan", "Komunikasi dengan pelanggan", "Disiplin & kehadiran", "Pemahaman rute", "Tingkat Pengembalian Perbulan"};
          tabMode = new DefaultTableModel(null, rows);
          tabel.setModel(tabMode);

            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM tbl_penilaian";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                      String a = rs.getString("id_kurir");
                      String b = rs.getString("nama_kurir");
                      String c = rs.getString("kecepatan_pengiriman");
                      String d = rs.getString("keandalan");
                      String e = rs.getString("kepuasan_pelanggan");
                      String f = rs.getString("jml_pengiriman_perbulan");
                      String g = rs.getString("komunikasi_dengan_pelanggan");
                      String h = rs.getString("disiplin_kehadiran");
                      String i = rs.getString("pemahaman_rute");
                      String j = rs.getString("tingkat_pengembalian_perbulan");

                      String[] data = {a,b,c,d,e,f,g,h,i,j};
                      tabMode.addRow(data);
                  }
                  conn.close();

            } catch (SQLException e) {
                System.out.println("Error dataTabel: " + e.getMessage());
            }
      }
}


