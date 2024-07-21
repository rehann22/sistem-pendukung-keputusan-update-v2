package com.admin.view;

import com.admin.controler.ProsesPerhitungan;
import com.admin.controler.Report;
import com.swing.ScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PageProsesPerhitungan extends javax.swing.JPanel {

      public DefaultTableModel modelTabelUploadData;

      public PageProsesPerhitungan() {
            initComponents();
            TabelUpload();
            ProsesPerhitungan data = new ProsesPerhitungan();
            data.BobotPenilaianAlternatif(modelTabelUploadData, tblBobotSubKriteria);
            data.AlgortimaSaw(tblDataNormalisasi, tblDataPreferensi, tblPerankingan);

            TScrolPane(spTable1);
            TScrolPane(spTable2);
            TScrolPane(spTable4);
            TScrolPane(spTable5);
            TScrolPane(spTable6);
      }

      public void TabelUpload() {
            Object[] rows = {"Id Kurir", "Nama Kurir", "Presensi", "Waktu Pengiriman", "Pengiriman Berhasil", "Pengiriman Gagal"};
            modelTabelUploadData = new DefaultTableModel(null, rows);
            tblDataUpload.setModel(modelTabelUploadData);
      }

      private void TabelWidth() {
            tblDataUpload.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDataUpload.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblBobotSubKriteria.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblBobotSubKriteria.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblDataNormalisasi.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDataNormalisasi.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblDataPreferensi.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDataPreferensi.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblDataPreferensi.getColumnModel().getColumn(6).setPreferredWidth(10);
            tblPerankingan.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblPerankingan.getColumnModel().getColumn(2).setPreferredWidth(10);
      }

      private void TScrolPane(JScrollPane scroll) {
            scroll.setVerticalScrollBar(new ScrollBar());
            scroll.getVerticalScrollBar().setBackground(Color.WHITE);
            scroll.getViewport().setBackground(Color.WHITE);
            JPanel p = new JPanel();
            p.setBackground(Color.WHITE);
            scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
      }

      private void bacaExcelDanTampilkan(File file) {

            try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

                  XSSFSheet sheet = workbook.getSheetAt(0);

                  // Pastikan sheet tidak null
                  if (sheet == null) {
                        JOptionPane.showMessageDialog(this, "Lembar kerja tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                  }

                  modelTabelUploadData.setRowCount(0);   // Bersihkan semua baris
                  modelTabelUploadData.setColumnCount(0); // Bersihkan semua kolom

                  // Ambil baris pertama (header)
                  Row headerRow = sheet.getRow(0);

                  // Pastikan headerRow tidak null
                  if (headerRow == null) {
                        JOptionPane.showMessageDialog(this, "Baris header tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                  }

                  // Mulai dari cell index 1 untuk mengabaikan kolom pertama
                  for (int cellIndex = 1; cellIndex < headerRow.getLastCellNum(); cellIndex++) {
                        Cell cell = headerRow.getCell(cellIndex);
                        modelTabelUploadData.addColumn(cell.toString()); // Tambahkan nama kolom ke tableModel
                  }

                  // Tambahkan data baris ke tableModel
                  for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                        Row row = sheet.getRow(rowIndex);

                        // Pastikan row tidak null
                        if (row != null) {
                              boolean isEmptyRow = true;
                              Object[] rowData = new Object[row.getLastCellNum() - 1];
                              for (int cellIndex = 1; cellIndex < row.getLastCellNum(); cellIndex++) {
                                    Cell cell = row.getCell(cellIndex);
                                    if (cell == null) {
                                          rowData[cellIndex - 1] = "";
                                    } else {
                                          switch (cell.getCellType()) {
                                                case STRING:
                                                      rowData[cellIndex - 1] = cell.getStringCellValue();
                                                      isEmptyRow = isEmptyRow && cell.getStringCellValue().isEmpty();
                                                      break;
                                                case NUMERIC:
                                                      if (DateUtil.isCellDateFormatted(cell)) {
                                                            rowData[cellIndex - 1] = cell.getDateCellValue();
                                                      } else {
                                                            double numericValue = cell.getNumericCellValue();
                                                            if (numericValue == (int) numericValue) {
                                                                  rowData[cellIndex - 1] = (int) numericValue;
                                                            } else {
                                                                  rowData[cellIndex - 1] = numericValue;
                                                            }
                                                      }
                                                      isEmptyRow = false;
                                                      break;
                                                case BOOLEAN:
                                                      rowData[cellIndex - 1] = cell.getBooleanCellValue();
                                                      isEmptyRow = false;
                                                      break;
                                                case FORMULA:
                                                      rowData[cellIndex - 1] = cell.getCellFormula();
                                                      isEmptyRow = false;
                                                      break;
                                                default:
                                                      rowData[cellIndex - 1] = "";
                                          }
                                    }
                              }

                              // Hanya tambahkan baris jika tidak kosong
                              if (!isEmptyRow) {
                                    modelTabelUploadData.addRow(rowData);
                              }
                        }
                  }

                  tblDataUpload.getColumnModel().getColumn(0).setPreferredWidth(0);
                  tblDataUpload.getColumnModel().getColumn(2).setPreferredWidth(10);
                  JOptionPane.showMessageDialog(null, "Import Data Berhasil", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                  e.printStackTrace();
                  JOptionPane.showMessageDialog(null, "Gagal membaca file Excel!", "Error", JOptionPane.ERROR_MESSAGE);
            }
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.swing.PanelBorder();
            spTable1 = new javax.swing.JScrollPane();
            tblDataUpload = new com.swing.Table();
            jLabel2 = new javax.swing.JLabel();
            btn_hitung = new swing.ButtonGradient();
            btn_upload = new swing.ButtonGradient();
            btn_print = new swing.ButtonGradient();
            panelBorder3 = new com.swing.PanelBorder();
            spTable4 = new javax.swing.JScrollPane();
            tblPerankingan = new com.swing.Table();
            jLabel5 = new javax.swing.JLabel();
            panelBorder2 = new com.swing.PanelBorder();
            spTable2 = new javax.swing.JScrollPane();
            tblBobotSubKriteria = new com.swing.Table();
            jLabel3 = new javax.swing.JLabel();
            panelBorder5 = new com.swing.PanelBorder();
            spTable6 = new javax.swing.JScrollPane();
            tblDataPreferensi = new com.swing.Table();
            jLabel7 = new javax.swing.JLabel();
            panelBorder4 = new com.swing.PanelBorder();
            spTable5 = new javax.swing.JScrollPane();
            tblDataNormalisasi = new com.swing.Table();
            jLabel6 = new javax.swing.JLabel();

            setBackground(new java.awt.Color(242, 242, 242));
            setPreferredSize(new java.awt.Dimension(900, 2325));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setPreferredSize(new java.awt.Dimension(870, 460));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable1.setBorder(null);

            tblDataUpload.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable1.setViewportView(tblDataUpload);

            panelBorder.add(spTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setText("Data Alternatif");
            panelBorder.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, -1));

            btn_hitung.setText("Hitung SAW");
            btn_hitung.setColor1(new java.awt.Color(35, 20, 226));
            btn_hitung.setColor2(new java.awt.Color(209, 18, 235));
            btn_hitung.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hitungActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 120, 30));

            btn_upload.setText("Upload Data");
            btn_upload.setColor1(new java.awt.Color(35, 20, 226));
            btn_upload.setColor2(new java.awt.Color(209, 18, 235));
            btn_upload.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_uploadActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 120, 30));

            btn_print.setText("Cetak Ranking");
            btn_print.setColor1(new java.awt.Color(35, 20, 226));
            btn_print.setColor2(new java.awt.Color(209, 18, 235));
            btn_print.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_printActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 120, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 900, 460));

            panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable4.setBorder(null);

            tblPerankingan.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable4.setViewportView(tblPerankingan);

            panelBorder3.add(spTable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 280));

            jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(97, 103, 122));
            jLabel5.setText("Ranking Alternatif");
            panelBorder3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, -1));

            add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1930, 900, 370));

            panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable2.setBorder(null);

            tblBobotSubKriteria.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable2.setViewportView(tblBobotSubKriteria);

            panelBorder2.add(spTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(97, 103, 122));
            jLabel3.setText("Rating Kecocokan Alternatif");
            panelBorder2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

            add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 900, 460));

            panelBorder5.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable6.setBorder(null);

            tblDataPreferensi.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable6.setViewportView(tblDataPreferensi);

            panelBorder5.add(spTable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(97, 103, 122));
            jLabel7.setText("Data Preferensi");
            panelBorder5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 370, -1));

            add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1450, 900, 460));

            panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            spTable5.setBorder(null);

            tblDataNormalisasi.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable5.setViewportView(tblDataNormalisasi);

            panelBorder4.add(spTable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 860, 370));

            jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(97, 103, 122));
            jLabel6.setText("Data Ternormalisasi");
            panelBorder4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

            add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 970, 900, 460));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
            ProsesPerhitungan data = new ProsesPerhitungan();
            data.BobotPenilaianAlternatif(modelTabelUploadData, tblBobotSubKriteria);
            data.AlgortimaSaw(tblDataNormalisasi, tblDataPreferensi, tblPerankingan);
            TabelWidth();
      }//GEN-LAST:event_btn_hitungActionPerformed

      private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "\\Downloads"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            // Set preferred size
            fileChooser.setPreferredSize(new Dimension(700, 400));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                  File selectedFile = fileChooser.getSelectedFile();
                  bacaExcelDanTampilkan(selectedFile);
            } else {
                  JOptionPane.showMessageDialog(null, "Tidak ada file yang dipilih", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
      }//GEN-LAST:event_btn_uploadActionPerformed

      private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
            Report reportGenerator = new Report();
            reportGenerator.ReportPeringkat(tblPerankingan);
      }//GEN-LAST:event_btn_printActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_hitung;
      private swing.ButtonGradient btn_print;
      private swing.ButtonGradient btn_upload;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel5;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JLabel jLabel7;
      private com.swing.PanelBorder panelBorder;
      private com.swing.PanelBorder panelBorder2;
      private com.swing.PanelBorder panelBorder3;
      private com.swing.PanelBorder panelBorder4;
      private com.swing.PanelBorder panelBorder5;
      private javax.swing.JScrollPane spTable1;
      private javax.swing.JScrollPane spTable2;
      private javax.swing.JScrollPane spTable4;
      private javax.swing.JScrollPane spTable5;
      private javax.swing.JScrollPane spTable6;
      public com.swing.Table tblBobotSubKriteria;
      public com.swing.Table tblDataNormalisasi;
      public com.swing.Table tblDataPreferensi;
      public com.swing.Table tblDataUpload;
      public com.swing.Table tblPerankingan;
      // End of variables declaration//GEN-END:variables
}
