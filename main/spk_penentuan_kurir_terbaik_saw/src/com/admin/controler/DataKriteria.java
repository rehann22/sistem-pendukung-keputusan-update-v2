package com.admin.controler;

import com.database.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataKriteria {
      private DefaultTableModel tabMode;
      
      static {
        // Atur locale default ke Locale.US
        Locale.setDefault(Locale.US);
      }
      
      public void bersihkanForm (JTextField kodeK, JTextField namaK, JTextField nilai, JComboBox jenis) {
            kodeK.setText("");
            namaK.setText("");
            nilai.setText("");
            jenis.setSelectedIndex(0);
      }

      public void TabelKriteria(JTable tabel) {
            
      }            
}
