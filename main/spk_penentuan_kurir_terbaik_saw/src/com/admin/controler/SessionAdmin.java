package com.admin.controler;

public class SessionAdmin {

      private static String log_idAdmin;
      private static String log_nama;
      private static String log_email;
      private static String log_passWord;

      public static void setLoggedInAdmin(String idAdmin, String namaAdmin, String emailAdmin, String passwodAdmin) {
            log_idAdmin = idAdmin;
            log_nama = namaAdmin;
            log_email = emailAdmin;
            log_passWord = passwodAdmin;
      }

      public static String log_idAdmin() {
            return log_idAdmin;
      }

      public static String log_nama() {
            return log_nama;
      }

      public static String log_passWord() {
            return log_passWord;
      }
}
