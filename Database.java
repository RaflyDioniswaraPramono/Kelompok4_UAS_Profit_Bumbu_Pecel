package com.company;

import java.sql.*;

public class Database {
    Pengunjung pengunjung;

    public Database(Pengunjung pengunjung) {
        this.pengunjung = pengunjung;

         try {
             Connection koneksi = DriverManager.getConnection(
                     "jdbc:mysql://localhost/daftar_pengunjung?user=root");
             Statement statement = koneksi.createStatement();

             statement.execute("INSERT INTO pengunjung VALUES('" + pengunjung.namaLengkap + "','" + pengunjung.asalKota +
                     "','" + pengunjung.nomorPonsel + "','" + pengunjung.email + "')");

             System.out.println("Penyimpanan ke Database daftar_pengunjung Berhasil!");
             }
         catch (SQLException e) {
             System.out.println(e.getMessage());
         }
    }
}
