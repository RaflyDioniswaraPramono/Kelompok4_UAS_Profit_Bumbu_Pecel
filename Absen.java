package com.company;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Absen {

    ArrayList<Pengunjung> listPengunjung;

    public Absen() {
        this.listPengunjung = new ArrayList<>();
    }

    /**
     * Cek apakah nama yang diberikan sudah ada di list pengunjung.
     * @param nama Nama yang akan dicek
     * @return     Bernilai true apabila ada nama yang sama di list.
     */
    boolean cekDuplikat(String nama) {
        for (Pengunjung pengunjung : listPengunjung) {
            if (pengunjung.namaLengkap.equals(nama)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cek apakah asal kota ada di Jawa Timur
     * @param kota Nama kota yang akan dicek
     * @return     Bernilai true apabila kota ada di Jawa Timur
     */
    boolean cekAsalKota(String kota) {
        String[] kotaJatim = {
                "Kabupaten Bangkalan",
                "Kabupaten Banyuwangi",
                "Kabupaten Blitar",
                "Kabupaten Bojonegoro",
                "Kabupaten Bondowoso",
                "Kabupaten Gresik",
                "Kabupaten Jember",
                "Kabupaten Jombang",
                "Kabupaten Kediri",
                "Kabupaten Lamongan",
                "Kabupaten Lumajang",
                "Kabupaten Madiun",
                "Kabupaten Magetan",
                "Kabupaten Malang",
                "Kabupaten Mojokerto",
                "Kabupaten Nganjuk",
                "Kabupaten Ngawi",
                "Kabupaten Pacitan",
                "Kabupaten Pamekasan",
                "Kabupaten Pasuruan",
                "Kabupaten Ponorogo",
                "Kabupaten Probolinggo",
                "Kabupaten Sampang",
                "Kabupaten Sidoarjo",
                "Kabupaten Situbondo",
                "Kabupaten Sumenep",
                "Kabupaten Trenggalek",
                "Kabupaten Tuban",
                "Kabupaten Tulungagung",
                "Kota Batu",
                "Kota Blitar",
                "Kota Kediri",
                "Kota Madiun",
                "Kota Malang",
                "Kota Mojokerto",
                "Kota Pasuruan",
                "Kota Probolinggo",
                "Kota Surabaya"};
        for (int i = 0; i < kotaJatim.length; i++) {
            if (kotaJatim[i].toUpperCase().equals(kota.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mengecek format nomor ponsel
     * @param s Nomor ponsel yang akan dicek
     * @return  Nilai true apabila format benar dan false apabila salah
     */
    boolean cekNomorPonsel(String s) {
        return Pattern.matches("[+]?[0-9]{6,19}", s);
    }

    /**
     * Mengecek format email
     * @param email Email yang akan dicek
     * @return      Nilai true apabila format benar
     */
    boolean cekEmail(String email) {
        return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\" +
                "x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[" +
                "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]" +
                "*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\" +
                "x0e-\\x7f])+)\\])");
    }
}
