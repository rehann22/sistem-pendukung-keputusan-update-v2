package com.admin.controler;

import com.database.ConnectionDb;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataKurir {
      private DefaultTableModel tabMode;

      private void BersihkanForm (JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JDateChooser tglBergabung) {
          idKurir.setText("");
          namaKurir.setText("");
          alamat.setText("");
          email.setText("");
          noTelp.setText("");
          tglBergabung.setDate(null); // Mengatur tanggal menjadi null untuk membersihkan JDateChooser
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
                  tabel.getColumnModel().getColumn(0).setPreferredWidth(0); 
                  conn.close();

            } catch (SQLException e) {
                System.out.println("Error dataTabel: " + e.getMessage());
            }
       }

      public void simpanDataKurir(JTable tabel, JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JDateChooser tglBergabung) {

          if (!idKurir.getText().isEmpty() && !namaKurir.getText().isEmpty() && !alamat.getText().isEmpty() && !email.getText().isEmpty() && !noTelp.getText().isEmpty() && tglBergabung.getDate() != null) {
              try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "INSERT INTO tbl_data_kurir (id_kurir, nama, alamat, email, no_telp, tgl_bergabung) VALUES (?, ?, ?, ?, ?, ?)";
                  PreparedStatement st = conn.prepareStatement(query);

                  st.setString(1, idKurir.getText());
                  st.setString(2, namaKurir.getText());
                  st.setString(3, alamat.getText());
                  st.setString(4, email.getText());
                  st.setString(5, noTelp.getText());

                  // Format the date before setting it in the PreparedStatement
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                  String formattedDate = sdf.format(tglBergabung.getDate());
                  st.setString(6, formattedDate);

                  st.executeUpdate();

                  JOptionPane.showMessageDialog(null, "Data Tersimpan");
                  TabelKurir(tabel);
                  BersihkanForm(idKurir, namaKurir, alamat, email, noTelp, tglBergabung);
                  idKurir.requestFocus();

                  st.close();
                  conn.close();

              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data");
                  e.printStackTrace();
              }
          } else {
              JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
          }
      }


      public void EditDataKurir(JTable tabel, JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JDateChooser tglBergabung) {
          try {
              Connection conn = new ConnectionDb().connect();
              String query = "UPDATE `tbl_data_kurir` SET `nama`=?, `alamat`=?, `email`=?, `no_telp`=?, `tgl_bergabung`=? WHERE `id_kurir`=?";
              PreparedStatement st = conn.prepareStatement(query);

              st.setString(1, namaKurir.getText());
              st.setString(2, alamat.getText());
              st.setString(3, email.getText());
              st.setString(4, noTelp.getText());

              // Format the date before setting it in the PreparedStatement
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
              String formattedDate = sdf.format(tglBergabung.getDate());
              st.setString(5, formattedDate);

              st.setString(6, idKurir.getText());

              st.executeUpdate();

              JOptionPane.showMessageDialog(null, "Data Pengguna Berhasil Diubah");

              BersihkanForm(idKurir, namaKurir, alamat, email, noTelp, tglBergabung);

              TabelKurir(tabel);
          } catch (SQLException ex) {
              System.out.println("Error edit data user\n" + ex);
          }
      }

      public void HapusDataKurir(JTable tabel){
            int selectedRow = tabel.getSelectedRow();
            String index = tabel.getValueAt(selectedRow, 0).toString();
            System.out.println(index);
            
            int ok = JOptionPane.showConfirmDialog(null, "Hapus Data Kurir??", "Konfirmasi dialog",
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


      public void tampilFormEditKurir(JTable clickTable, JTextField idKurir, JTextField namaKurir, JTextArea alamat, JTextField email, JTextField noTelp, JDateChooser tglBergabung) {
          try {
              int selectedRow = clickTable.getSelectedRow();
              String index = clickTable.getValueAt(selectedRow, 0).toString();
              System.out.println(index);

              Connection conn = new ConnectionDb().connect();
              String query = "SELECT * FROM `tbl_data_kurir` WHERE `id_kurir` = ?";
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setString(1, index);
              ResultSet rs = ps.executeQuery();

              if (rs.next()) {
                  idKurir.setText(rs.getString("id_kurir"));
                  namaKurir.setText(rs.getString("nama"));
                  alamat.setText(rs.getString("alamat"));
                  email.setText(rs.getString("email"));
                  noTelp.setText(rs.getString("no_telp"));

                  // Mengonversi string tanggal ke objek Date dan mengatur pada JDateChooser
                  String tanggalString = rs.getString("tgl_bergabung");
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                  try {
                      Date tanggal = sdf.parse(tanggalString);
                      tglBergabung.setDate(tanggal);
                  } catch (ParseException e) {
                      e.printStackTrace();
                      JOptionPane.showMessageDialog(null, "Format tanggal salah: " + tanggalString);
                  }
              }

              conn.close();
              rs.close();
              ps.close();
          } catch (SQLException ex) {
              System.out.println(ex);
              System.out.println("Error di displayDataOnLabel");
          }
      }
      
}
