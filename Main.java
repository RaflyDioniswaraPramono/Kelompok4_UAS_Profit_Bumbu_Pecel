package com.company;

public class Main {

    public static void main(String[] args) {
        Absen absen = new Absen();

        if (args.length > 0) {
            for (String argumen : args) {
                if (argumen.toUpperCase().equals("CONSOLE")) {
                    new KonsolAbsen(absen);
                }
                if (argumen.toUpperCase().equals("GUI")) {
                    new GUI(absen);
                }
            }
        }
        else {
            new GUI(absen);
        }
    }
}
