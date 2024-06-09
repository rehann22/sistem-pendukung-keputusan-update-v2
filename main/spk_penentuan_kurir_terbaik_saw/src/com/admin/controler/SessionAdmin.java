package com.admin.controler;


public class SessionAdmin {
    private static String log_idAdmin;
    private static String log_nama;
    private static String log_passWord;
    
    public static void setLoggedInAdmin(String idAdmin, String nama, String passWord) {
        log_idAdmin = idAdmin;
        log_nama = nama;
        log_passWord = passWord;
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

