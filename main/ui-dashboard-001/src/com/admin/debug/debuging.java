package com.admin.debug;

import com.admin.view.PageDataKriteria;

public class debuging {
    public static void main(String[] args) {
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
    }
}

