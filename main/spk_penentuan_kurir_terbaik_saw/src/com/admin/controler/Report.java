package com.admin.controler;

import com.database.ConnectionDb;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.design.JRCompiler;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

      public void ReportKurir() {
            InputStream reportStream = null;
            Connection conn = null;

            try {
                  // Mendapatkan path menuju file .jasper
                  reportStream = getClass().getResourceAsStream("/com/laporan/ReportAlternatif.jasper");
                  if (reportStream == null) {
                      throw new RuntimeException("File .jasper tidak ditemukan.");
                  }

                  // Mendapatkan koneksi ke database
                  conn = new ConnectionDb().connect();
                  HashMap<String, Object> param = new HashMap<>();

                  // Mengisi laporan dengan data dari database
                  JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);
                  
                  // Menampilkan laporan
                  JasperViewer.viewReport(jp, false); // false untuk menutup aplikasi tanpa menutup laporan

            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
                  e.printStackTrace();
            } finally {
                  // Menutup InputStream dan koneksi database
                  if (reportStream != null) {
                        try {
                            reportStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                  }
                  if (conn != null) {
                        try {
                            conn.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                  }
            }
      }
      
      
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
    
      public void ReportPenilaianKurir() {
             InputStream reportStream = null;
             Connection conn = null;

             try {
                  // Mendapatkan path menuju file .jasper
                  reportStream = getClass().getResourceAsStream("/com/laporan/ReportPenilaianAlternatif.jasper");
                  if (reportStream == null) {
                      throw new RuntimeException("File .jasper tidak ditemukan.");
                  }

                  // Mendapatkan koneksi ke database
                  conn = new ConnectionDb().connect();
                  HashMap<String, Object> param = new HashMap<>();

                  // Mengisi laporan dengan data dari database
                  JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);

                  // Menampilkan laporan
                  JasperViewer.viewReport(jp, false); // false untuk menutup aplikasi tanpa menutup laporan

             } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
                  e.printStackTrace();
             } finally {
                  // Menutup InputStream dan koneksi database
                  if (reportStream != null) {
                        try {
                            reportStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                  }
                  if (conn != null) {
                        try {
                            conn.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                  }
            }
      }
}
