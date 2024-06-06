package com.admin.controler;

import com.database.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Debug {
      
public int getTotalNilai() {
    int totalNilai = 0;
    try {
        Connection conn = new ConnectionDb().connect();
        String query = "SELECT SUM(nilai) AS total_nilai FROM tbl_kriteria";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
            totalNilai = rs.getInt("total_nilai");
            System.out.println(totalNilai);
        }
    } catch (SQLException ex) {
        System.out.println("Error calculating total nilai\n" + ex);
    }
    return totalNilai;
}

public void bagiNilaiDenganTotal() {
    int totalNilai = getTotalNilai();
    if (totalNilai == 0) {
        System.out.println("Total nilai is zero, division by zero is not possible.");
        return;
    }
    
    try {
        Connection conn = new ConnectionDb().connect();
        String query = "SELECT kode_kriteria, nilai FROM tbl_kriteria";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            String kodeKriteria = rs.getString("kode_kriteria");
            int nilai = rs.getInt("nilai");
            double hasilBagi = (double) nilai / totalNilai;
            
            // Menampilkan hasil pembagian atau bisa disimpan kembali ke database
            System.out.println("Kode Kriteria: " + kodeKriteria + ", Nilai: " + nilai + ", Hasil Bagi: " + hasilBagi);
            
            // Jika ingin menyimpan hasil pembagian ke dalam tabel lain atau kolom lain:
            // String updateQuery = "UPDATE tbl_kriteria SET hasil_bagi = ? WHERE id = ?";
            // PreparedStatement updateSt = conn.prepareStatement(updateQuery);
            // updateSt.setDouble(1, hasilBagi);
            // updateSt.setInt(2, id);
            // updateSt.executeUpdate();
        }
    } catch (SQLException ex) {
        System.out.println("Error calculating division\n" + ex);
    }
}

public static void main(String[] args) {
    // Misalnya kelas Anda bernama MainClass
    Debug mainClass = new Debug();
    mainClass.getTotalNilai();
    mainClass.bagiNilaiDenganTotal();
}


}
