package com.admin.debug;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class debuging {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/spk_saw"; // Ganti dengan nama database Anda
        String username = "root"; // Ganti dengan username database Anda
        String password = ""; // Ganti dengan password database Anda

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Membuat koneksi ke database
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Membuat statement
            statement = connection.createStatement();

            // Query untuk mengambil data dari tbl_penilaian
            String query = "SELECT * FROM tbl_penilaian";

            // Mengeksekusi query
            resultSet = statement.executeQuery(query);

            // Memproses hasil query
            while (resultSet.next()) {
                String idKurir = resultSet.getString("id_kurir");
                String namaKurir = resultSet.getString("nama_kurir");
                String kesalahanPengiriman = resultSet.getString("kesalahan_pengiriman");
                String lamaBekerja = resultSet.getString("lama_bekerja");
                String kecepatanPengiriman = resultSet.getString("kecepatan_pengiriman");
                String paketDikirimPerbulan = resultSet.getString("paket_dikirim_perbulan");

                // Mendapatkan bobot untuk setiap kriteria
                int bobotKesalahanPengiriman = getBobot(connection, kesalahanPengiriman);
                int bobotLamaBekerja = getBobot(connection, lamaBekerja);
                int bobotKecepatanPengiriman = getBobot(connection, kecepatanPengiriman);
                int bobotPaketDikirimPerbulan = getBobot(connection, paketDikirimPerbulan);

                // Mencetak hasil
                System.out.println("ID Kurir: " + idKurir);
                System.out.println("Nama Kurir: " + namaKurir);
                System.out.println("Kesalahan Pengiriman: " + kesalahanPengiriman + " (Bobot: " + bobotKesalahanPengiriman + ")");
                System.out.println("Lama Bekerja: " + lamaBekerja + " (Bobot: " + bobotLamaBekerja + ")");
                System.out.println("Kecepatan Pengiriman: " + kecepatanPengiriman + " (Bobot: " + bobotKecepatanPengiriman + ")");
                System.out.println("Paket Dikirim Perbulan: " + paketDikirimPerbulan + " (Bobot: " + bobotPaketDikirimPerbulan + ")");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Menutup resultSet, statement, dan connection
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (statement != null) statement.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    // Method untuk mendapatkan bobot berdasarkan kode kriteria dan keterangan
    private static int getBobot(Connection connection, String keterangan) {
        Statement stmt = null;
        ResultSet rs = null;
        int bobot = 0; // Default value jika tidak ditemukan

        try {
            stmt = connection.createStatement();
            String query = "SELECT bobot FROM tbl_sub_kriteria WHERE keterangan = '" + keterangan + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                bobot = rs.getInt("bobot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (Exception e) { e.printStackTrace(); }
        }

        return bobot;
    }
}
