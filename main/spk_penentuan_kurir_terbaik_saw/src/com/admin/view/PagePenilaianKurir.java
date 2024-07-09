package com.admin.view;

import com.admin.controler.PenilaianKurir;
import com.swing.ScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PagePenilaianKurir extends javax.swing.JPanel {
      public DefaultTableModel tableModel;
      public PagePenilaianKurir() {
            initComponents();
            PenilaianKurir pnl = new PenilaianKurir();
            pnl.TabelPenilaian(tblPenilaianKurir);

            spTable.setVerticalScrollBar(new ScrollBar());
            spTable.getVerticalScrollBar().setBackground(Color.WHITE);
            spTable.getViewport().setBackground(Color.WHITE);
            JPanel p = new JPanel();
            p.setBackground(Color.WHITE);
            spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
            
            tblPenilaianKurir.getColumnModel().getColumn(0).setPreferredWidth(0); 
            tblPenilaianKurir.getColumnModel().getColumn(2).setPreferredWidth(10); 
      }
      
      private void bacaExcelDanTampilkan(File file) {
            Object[] rows = {};
            DefaultTableModel tableModel = new DefaultTableModel(null, rows);
            tblPenilaianKurir.setModel(tableModel);

            try (FileInputStream fis = new FileInputStream(file);
                  XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

                  XSSFSheet sheet = workbook.getSheetAt(0);

                  // Pastikan sheet tidak null
                  if (sheet == null) {
                      JOptionPane.showMessageDialog(this, "Lembar kerja tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                  }

                  tableModel.setRowCount(0);   // Bersihkan semua baris
                  tableModel.setColumnCount(0); // Bersihkan semua kolom

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
                      tableModel.addColumn(cell.toString()); // Tambahkan nama kolom ke tableModel
                  }

                  // Tambahkan data baris ke tableModel
                  for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                      Row row = sheet.getRow(rowIndex);

                    // Pastikan row tidak null
                    if (row != null) {
                        Object[] rowData = new Object[row.getLastCellNum()];
                        for (int cellIndex = 1; cellIndex < row.getLastCellNum(); cellIndex++) {
                              Cell cell = row.getCell(cellIndex);
                              if (cell == null) {
                                  rowData[cellIndex - 1] = "";
                              } else {
                                    switch (cell.getCellType()) {
                                          case STRING:
                                              rowData[cellIndex -1] = cell.getStringCellValue();
                                              break;
                                          case NUMERIC:
                                            if (DateUtil.isCellDateFormatted(cell)) {
                                              rowData[cellIndex -1] = cell.getDateCellValue();
                                          } else {
                                              double numericValue = cell.getNumericCellValue();
                                                if (numericValue == (int) numericValue) {
                                                    rowData[cellIndex -1] = (int) numericValue;
                                                } else {
                                                    rowData[ -1] = numericValue;
                                                }
                                          }
                                        break;
                                    case BOOLEAN:
                                        rowData[cellIndex -1] = cell.getBooleanCellValue();
                                        break;
                                    case FORMULA:
                                        rowData[cellIndex -1] = cell.getCellFormula();
                                        break;
                                    default:
                                        rowData[cellIndex -1] = "";
                                    }
                              }
                        }
                        tableModel.addRow(rowData);
                  }
            }
                  tblPenilaianKurir.getColumnModel().getColumn(0).setPreferredWidth(0); 
                  tblPenilaianKurir.getColumnModel().getColumn(2).setPreferredWidth(10);
                  JOptionPane.showMessageDialog(this, "Import Data Berhasil", "Succes", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                  e.printStackTrace();
                  JOptionPane.showMessageDialog(this, "Gagal membaca file Excel!", "Error", JOptionPane.ERROR_MESSAGE);
            }
      }

    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.swing.PanelBorder();
            refresh = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tblPenilaianKurir = new com.swing.Table();
            btn_upload = new swing.ButtonGradient();
            txt_cari = new textfield.TextField();
            btn_simpan = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            refresh.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            refresh.setForeground(new java.awt.Color(97, 103, 122));
            refresh.setText("Penilaian Alternatif");
            refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            refresh.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        refreshMouseClicked(evt);
                  }
            });
            panelBorder.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, -1));

            spTable.setBorder(null);

            tblPenilaianKurir.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "", "", "", "", "", ""
                  }
            ));
            spTable.setViewportView(tblPenilaianKurir);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 480));

            btn_upload.setText("Upload Excel");
            btn_upload.setColor1(new java.awt.Color(35, 20, 226));
            btn_upload.setColor2(new java.awt.Color(209, 18, 235));
            btn_upload.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_uploadActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 110, 30));

            txt_cari.setBackground(new java.awt.Color(255, 255, 255));
            txt_cari.setForeground(new java.awt.Color(97, 103, 122));
            txt_cari.setLabelText("Cari");
            txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyPressed(java.awt.event.KeyEvent evt) {
                        txt_cariKeyPressed(evt);
                  }
            });
            panelBorder.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 140, -1));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
            btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 110, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "\\Downloads"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            // Set preferred size
            fileChooser.setPreferredSize(new Dimension(700, 400));

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                bacaExcelDanTampilkan(selectedFile);
            } else {
                JOptionPane.showMessageDialog(this, "Tidak ada file yang dipilih", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
      }//GEN-LAST:event_btn_uploadActionPerformed

      private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
            PenilaianKurir method = new PenilaianKurir();
            method.TabelPenilaian(tblPenilaianKurir);
            txt_cari.setText("");
      }//GEN-LAST:event_refreshMouseClicked

      private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
            PenilaianKurir pnl = new PenilaianKurir();
            pnl.CariData(txt_cari, tblPenilaianKurir);
      }//GEN-LAST:event_txt_cariKeyPressed

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
            PenilaianKurir pnl = new PenilaianKurir();
            pnl.simpanDataKeDatabase(tblPenilaianKurir);
      }//GEN-LAST:event_btn_simpanActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private swing.ButtonGradient btn_upload;
      private com.swing.PanelBorder panelBorder;
      private javax.swing.JLabel refresh;
      private javax.swing.JScrollPane spTable;
      public com.swing.Table tblPenilaianKurir;
      private textfield.TextField txt_cari;
      // End of variables declaration//GEN-END:variables
}
