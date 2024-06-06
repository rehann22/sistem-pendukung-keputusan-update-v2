package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataKurir {
private DefaultTableModel tabMode;

private void bersihkanForm (JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JTextField tglBergabung) {
    idKurir.setText("");
    namaKurir.setText("");
    alamat.setText("");
    email.setText("");
    noTelp.setText("");
    tglBergabung.setText("");
}

public void TabelKurir(JTable tabel) {
    Object[] rows = {"Id Kurir", "Nama Kurir", "Alamat", "Email", "No Telp", "Tanggal Bergabung"};
    tabMode = new DefaultTableModel(null, rows);
    tabel.setModel(tabMode);

      try {
          Connection conn = new ConnectionDb().connect();
          String query = "SELECT * FROM tbl_data_kurir";
          PreparedStatement ps = conn.prepareStatement(query);
          ResultSet rs = ps.executeQuery();

          while (rs.next()) {
              String a = rs.getString("id_kurir");
              String b = rs.getString("nama");
              String c = rs.getString("alamat");
              String d = rs.getString("email");
              String e = rs.getString("no_telp");
              String f = rs.getString("tgl_bergabung");

              String[] data = {a, b, c, d, e, f};
              tabMode.addRow(data);
          }
          conn.close();

      } catch (SQLException e) {
          System.out.println("Error dataTabel: " + e.getMessage());
      }
 }

public void simpanDataKurir(JTable tabel, JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JTextField tglBergabung) {

if (!idKurir.getText().isEmpty() && !namaKurir.getText().isEmpty() && !alamat.getText().isEmpty() && !email.getText().isEmpty() && !noTelp.getText().isEmpty() && !tglBergabung.getText().isEmpty()) {
      try {
            Connection conn = new ConnectionDb().connect();
            String query = "INSERT INTO tbl_data_kurir values (?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, idKurir.getText());
            st.setString(2, namaKurir.getText());
            st.setString(3, alamat.getText());
            st.setString(4, email.getText());
            st.setString(5,noTelp.getText());
            st.setString(6, tglBergabung.getText());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            TabelKurir(tabel);
            bersihkanForm(idKurir, namaKurir, alamat, email, noTelp, tglBergabung);
            idKurir.requestFocus();
            conn.close();
            st.close();

      }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data");
            e.printStackTrace();
      }
}else {
      JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
}
}

public void EditDataKurir (JTable tabel, JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JTextField tglBergabung) {
    try {
        Connection conn = new ConnectionDb().connect();
        String query = "UPDATE `tbl_data_kurir` SET `nama`=?, `alamat`=?, `email`=?, `no_telp`=?, `tgl_bergabung`=? WHERE `id_kurir`=?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, namaKurir.getText());
        st.setString(2, alamat.getText());
        st.setString(3, email.getText());
        st.setString(4, noTelp.getText());
        st.setString(5, tglBergabung.getText());
        st.setString(6, idKurir.getText());

        st.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data Pengguna Berhasil Diubah");
        namaKurir.setText("");
        alamat.setText("");
        email.setText("");
        noTelp.setText("");
        tglBergabung.setText("");

        TabelKurir(tabel);
    } catch (SQLException ex) {
        System.out.println("Error edit data user\n" + ex);
    }
}

public void HapusDataKurir(JTable tabel){
            int selectedRow = tabel.getSelectedRow();
            String index = tabel.getValueAt(selectedRow, 0).toString();
            System.out.println(index);
            
            int ok = JOptionPane.showConfirmDialog(null, "Hapus Data Penyakit", "Konfirmasi dialog",
                  JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "DELETE FROM `tbl_data_kurir` WHERE `id_kurir`= ?";
                        PreparedStatement st = conn.prepareStatement(query);
                        
                        st.setString(1, index);
                        
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Terhapus");
                        TabelKurir(tabel);
 
                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data gagal dihapus");
                  }
            }
      }


      public void tampilFormEditKurir (JTable clickTable, JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JTextField tglBergabung ) {
            try {
              int selectedRow = clickTable.getSelectedRow();
              String index = clickTable.getValueAt(selectedRow, 0).toString();
              System.out.println(index);
              
              Connection conn = new ConnectionDb().connect();
              String query = "SELECT * FROM `tbl_data_kurir` WHERE `id_kurir` = ? ";
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setString(1, index);
              ResultSet rs = ps.executeQuery();

              String[] data = new String[6];
              if (rs.next()) {
                  data[0] = rs.getString("id_kurir");
                  data[1] = rs.getString("nama");
                  data[2] = rs.getString("alamat");
                  data[3] = rs.getString("email");
                  data[4] = rs.getString("no_telp");
                  data[5] = rs.getString("tgl_bergabung");
              }
              
              idKurir.setText(data[0]);
              namaKurir.setText(data[1]);
              alamat.setText((data[2]));
              email.setText((data[3]));
              noTelp.setText((data[4]));
              tglBergabung.setText(data[5]);
              
              //tabPane.setSelectedIndex(6);
              conn.close();
              rs.close();

          } catch (SQLException ex) {
              System.out.println(ex);
              System.out.println("Error di displayDataOnLabel");
          }
      }
      
}
