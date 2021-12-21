package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    Absen absen;

    private final JPanel panelUtama;
    private JTextField fieldNamaLengkap;
    private JTextField fieldAsalKota;
    private JTextField fieldNomorTlpn;
    private JTextField alamatEmail;
    private DefaultTableModel modelTabel;

    public GUI (Absen absen) {
        this.absen = absen;

        JFrame frame = new JFrame("Daftar Pengunjug");
        frame.setSize(1100,400);

        panelUtama = new JPanel();
        frame.add(panelUtama);

        JPanel panel1 = new JPanel();
        panelUtama.add(panel1);

        JPanel panel2 = new JPanel();
        panelUtama.add(panel2);

        JPanel panel3 = new JPanel();
        panelUtama.add(panel3);

        JPanel panel4 = new JPanel();
        panelUtama.add(panel4);

        JScrollPane pane5 = new JScrollPane();
        panelUtama.add(pane5);

        JButton button1 = new JButton("Absen");
        panelUtama.add(button1);

        panelUtama.setLayout(new FlowLayout(FlowLayout.LEFT));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException
                | InstantiationException | IllegalAccessException ignored) { }

        setLokasiFrame(frame);
        fieldNama(panel1);
        fieldAsalKota(panel2);
        fieldNomor(panel3);
        fieldEmail(panel4);
        buttonAbsen(button1);
        buatTableDaftarPengunjung(pane5);

        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void setLokasiFrame(JFrame frame) {
        Dimension pc = Toolkit.getDefaultToolkit().getScreenSize();
        int x = pc.width/2 - frame.getWidth()/2;
        int y = pc.height/2 - frame.getHeight()/2;
        frame.setLocation(x,y);
    }

    public void fieldNama(JPanel panel1) {
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));

        JLabel labelNamaLengkap = new JLabel("Nama Lengkap ");
        labelNamaLengkap.setFont(new Font(Font.SERIF, Font.BOLD, 12));

        fieldNamaLengkap = new JTextField(20);
        fieldNamaLengkap.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panel1.add(labelNamaLengkap);
        panel1.add(fieldNamaLengkap);
    }

    public void fieldAsalKota(JPanel panel2) {
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel2.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));

        JLabel labelAsalKota = new JLabel("Asal Kota           ");
        labelAsalKota.setFont(new Font(Font.SERIF, Font.BOLD, 12));

        fieldAsalKota = new JTextField(20);
        fieldAsalKota.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panel2.add(labelAsalKota);
        panel2.add(fieldAsalKota);
    }

    public void fieldNomor(JPanel panel3) {
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel3.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));

        JLabel labelNomorTlpn = new JLabel("Nomor Ponsel ");
        labelNomorTlpn.setFont(new Font(Font.SERIF, Font.BOLD, 12));

        fieldNomorTlpn = new JTextField(20);
        fieldNomorTlpn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panel3.add(labelNomorTlpn);
        panel3.add(fieldNomorTlpn);
    }

    public void fieldEmail(JPanel panel4) {
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel4.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));

        JLabel labelAlamatEmail = new JLabel("Alamat E-Mail   ");
        labelAlamatEmail.setFont(new Font(Font.SERIF, Font.BOLD, 12));

        alamatEmail = new JTextField(20);
        alamatEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        panel4.add(labelAlamatEmail);
        panel4.add(alamatEmail);
    }

    public void buttonAbsen(JButton button1) {
        button1.setLayout(new FlowLayout(FlowLayout.LEFT));

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String namaLengkap = fieldNamaLengkap.getText();
                String asalKota = fieldAsalKota.getText();
                String nomorPonsel = fieldNomorTlpn.getText();
                String email = alamatEmail.getText();

                if (fieldNamaLengkap.getText().isEmpty() || fieldAsalKota.getText().isEmpty() ||
                        fieldNomorTlpn.getText().isEmpty() || alamatEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelUtama, "Perhatikan!, Semua Data Harus Ter Isi!");
                    return;
                }
                if (absen.cekDuplikat(namaLengkap)) {
                    JOptionPane.showMessageDialog(panelUtama, "Nama " + namaLengkap + " Sudah Absen!");
                    fieldNamaLengkap.requestFocus();
                    return;
                }

                if (!absen.cekAsalKota(asalKota)) {
                    JOptionPane.showMessageDialog(panelUtama, "Kota Harus Berada Di Jawa Timur!");
                    fieldAsalKota.requestFocus();
                    return;
                }
                if (!absen.cekNomorPonsel(nomorPonsel)) {
                    JOptionPane.showMessageDialog(panelUtama, "Nomor Ponsel Tidak Valid!");
                    fieldNomorTlpn.requestFocus();
                    return;
                }
                if (!absen.cekEmail(email)) {
                    JOptionPane.showMessageDialog(panelUtama, "Alamat E-Mail Tidak Valid!");
                    alamatEmail.requestFocus();
                    return;
                }

                absen.listPengunjung.add(new Pengunjung(namaLengkap, asalKota, nomorPonsel, email));

                updateIsiTabel();

                Pengunjung pengunjung = new Pengunjung(namaLengkap, asalKota, nomorPonsel, email);
                new Database(pengunjung);

                fieldNamaLengkap.setText("");
                fieldAsalKota.setText("");
                fieldNomorTlpn.setText("");
                alamatEmail.setText("");
                fieldNamaLengkap.requestFocus();
            }
        });
    }

    private void buatTableDaftarPengunjung(JScrollPane pane5) {
        pane5.setBorder(BorderFactory.createTitledBorder("Daftar Pengunjung"));

        String[] kolom = {"Nama Lengkap", "Asal Kota", "Nomor Ponsel", "Alamat E-Mail"};
        String[][] isi = {};

        modelTabel = new DefaultTableModel(isi, kolom);
        JTable tabelKosong = new JTable(modelTabel);
        tabelKosong.setEnabled(false);
        tabelKosong.setPreferredScrollableViewportSize(new Dimension(1000, 230));

        pane5.setViewportView(tabelKosong);
    }

    private void updateIsiTabel() {
        modelTabel.setRowCount(0);
        for (Pengunjung pengunjung : absen.listPengunjung) {
            String[] baris = { pengunjung.namaLengkap, pengunjung.asalKota, pengunjung.nomorPonsel, pengunjung.email};
            modelTabel.addRow(baris);
        }
    }
}

