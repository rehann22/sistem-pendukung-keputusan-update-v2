/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admin.debug;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelImporter extends JFrame {

    private JTable table;

    public ExcelImporter() {
        initUI();
    }

    private void initUI() {
        JButton button = new JButton("Pilih File");
        button.addActionListener(e -> showFileChooser());

        table = new JTable();

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        setTitle("Import Excel ke JTable");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void showFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "\\Downloads"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setPreferredSize(new Dimension(800, 600));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                bacaExcelDanTampilkan(selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada file yang dipilih", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void bacaExcelDanTampilkan(File file) throws IOException {
        FileInputStream excelFile = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);

        // Membaca header
        if (rowIterator.hasNext()) {
            Row headerRow = rowIterator.next();
            Iterator<Cell> cellIterator = headerRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                model.addColumn(cell.getStringCellValue());
            }
        }

        // Membaca baris data
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            Object[] rowData = new Object[currentRow.getPhysicalNumberOfCells()];

            int i = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        rowData[i] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            rowData[i] = cell.getDateCellValue();
                        } else {
                            // Konversi ke int jika tidak ada desimal
                            double numericValue = cell.getNumericCellValue();
                            if (numericValue == (int) numericValue) {
                                rowData[i] = (int) numericValue;
                            } else {
                                rowData[i] = numericValue;
                            }
                        }
                        break;
                    case BOOLEAN:
                        rowData[i] = cell.getBooleanCellValue();
                        break;
                    case FORMULA:
                        rowData[i] = cell.getCellFormula();
                        break;
                    default:
                        rowData[i] = null;
                }
                i++;
            }
            model.addRow(rowData);
        }
        workbook.close();
        excelFile.close();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ExcelImporter ex = new ExcelImporter();
            ex.setVisible(true);
        });
    }
}
