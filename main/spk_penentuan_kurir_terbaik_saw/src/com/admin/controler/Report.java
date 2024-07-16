package com.admin.controler;

import java.io.InputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

      public void ReportPeringkat(JTable table) {
            InputStream reportStream = null;
            try {
                  // Menggunakan path relatif untuk file .jrxml
                  reportStream = getClass().getResourceAsStream("/com/laporan/ReportPeringkat.jrxml");
                  if (reportStream == null) {
                        throw new RuntimeException("File .jrxml tidak ditemukan.");
                  }

                  // Compile file .jrxml menjadi .jasper
                  JasperPrint jp = JasperFillManager.fillReport(
                          JasperCompileManager.compileReport(reportStream), new HashMap<>(), new CetakTabelPeringkat(table));

                  // Menampilkan laporan
                  JasperViewer.viewReport(jp, false); // false untuk menutup aplikasi tanpa menutup laporan

            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
                  e.printStackTrace();
            } finally {
                  if (reportStream != null) {
                        try {
                              reportStream.close();
                        } catch (Exception e) {
                              e.printStackTrace();
                        }
                  }
            }
      }
}
