package com.admin.debug;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class MyClass {

    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Contoh Header Tabel dengan Baris Ganda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        // Data dan kolom
        Object[] columns = {
                "Id Kurir", 
                "Nama Kurir", 
                "Lama Bekerja", 
                "Kecepatan Pengiriman", 
                "<html>Pengiriman Berhasil<br>Perbulan</html>", 
                "<html>Pengiriman Gagal<br>Perbulan</html>"
        };

        // Membuat tabel model dan tabel
        DefaultTableModel tabMode = new DefaultTableModel(null, columns);
        JTable table = new JTable(tabMode);
        
        // Menambahkan beberapa baris contoh
        tabMode.addRow(new Object[]{"1", "Kurir A", "5 Tahun", "Cepat", "100", "5"});
        tabMode.addRow(new Object[]{"2", "Kurir B", "3 Tahun", "Sedang", "80", "10"});
        tabMode.addRow(new Object[]{"3", "Kurir C", "1 Tahun", "Lambat", "60", "20"});

        // Mengatur header renderer
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new MultiLineHeaderRenderer());

        // Menambahkan tabel ke scroll pane dan menambahkannya ke frame
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Menampilkan frame
        frame.setVisible(true);
    }

    // Renderer kustom untuk header dengan baris ganda
    static class MultiLineHeaderRenderer extends JComponent implements TableCellRenderer {

        JLabel label;

        public MultiLineHeaderRenderer() {
            label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            this.setLayout(new BorderLayout());
            this.add(label, BorderLayout.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            label.setText(value != null ? value.toString() : "");
            return this;
        }
    }
}

