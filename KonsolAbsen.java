package com.company;

import java.util.Scanner;

public class KonsolAbsen {
    Absen absen;

    public KonsolAbsen(Absen absen) {
        this.absen = new Absen();

        mainloop: while(true) {
            System.out.println("Nama Lengkap:");
            Scanner input = new Scanner(System.in);
            String namaLengkap = input.nextLine();
            if (namaLengkap.isEmpty()) {
                System.out.println("Error: Tidak boleh kosong!");
                continue;
            }
            if (absen.cekDuplikat(namaLengkap)) {
                System.out.println("Error: Nama " + namaLengkap + " sudah absen!");
                this.absen.cekDuplikat(namaLengkap);
                continue;
            }
            System.out.println("Asal Kota:");
            String asalKota = input.nextLine();
            if (asalKota.isEmpty()) {
                System.out.println("Error: Tidak boleh kosong!");
                continue;
            }
            if (!absen.cekAsalKota(asalKota)) {
                System.out.println("Warning: Asal kota harus dari Jawa Timur");
                continue;
            }

            System.out.println("Nomor Ponsel:");
            String nomorPonsel = input.nextLine();
            if (!absen.cekNomorPonsel(nomorPonsel)) {
                System.out.println("Error: Format nomor ponsel salah!");
                continue;
            }

            System.out.println("Email:");
            String email = input.nextLine();
            if (!absen.cekEmail(email)) {
                System.out.println("Error: Format email salah!");
                continue;
            }

            this.absen.cekDuplikat(namaLengkap);
            this.absen.cekAsalKota(asalKota);
            this.absen.cekNomorPonsel(nomorPonsel);
            this.absen.cekEmail(email);
            this.absen.listPengunjung.add(new Pengunjung(namaLengkap, asalKota, nomorPonsel, email));
            cetakDaftarPengunjung();

            System.out.println("\n");
        }
    }

    public void cetakDaftarPengunjung() {
        String garis = "+----------------------+------------------------+-------------------+------------------------+%n";
        String format = "| %-20s | %-22s | %-17s | %-22S |%n";
        System.out.format(garis);
        System.out.format(format, "NAMA LENGKAP", "ASAL KOTA", "NOMOR PONSEL", "ALAMAT EMAIL");
        System.out.format(garis);
        for (Pengunjung p : absen.listPengunjung) {
            System.out.format(format, p.namaLengkap, p.asalKota, p.nomorPonsel, p.email);
        }
        System.out.format(garis);
    }
}
