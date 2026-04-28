package model;

public class Model1 {
    private String kodeKota;
    private double beratButet;
    private double beratUcok;
    private String namaKota;
    private int hargaPerKg;
    private boolean isLuarPulau;

    public Model1(String kodeKota, double beratButet) {
        this.kodeKota = kodeKota;
        this.beratButet = beratButet;
        this.beratUcok = 1.5 * beratButet;
        tentukanDataKota();
    }

    private void tentukanDataKota() {
        switch (kodeKota.toUpperCase()) {
            case "MDN":
                namaKota = "Medan";
                hargaPerKg = 8000;
                isLuarPulau = false;
                break;
            case "BLG":
                namaKota = "Balige";
                hargaPerKg = 5000;
                isLuarPulau = false;
                break;
            case "JKT":
                namaKota = "Jakarta";
                hargaPerKg = 12000;
                isLuarPulau = true;
                break;
            case "SBY":
                namaKota = "Surabaya";
                hargaPerKg = 13000;
                isLuarPulau = true;
                break;
            default:
                namaKota = "Kota Tidak Diketahui";
                hargaPerKg = 0;
        }
    }

    public double getTotalBerat() {
        return beratButet + beratUcok;
    }

    public double getTotalOngkos() {
        double total = getTotalBerat() * hargaPerKg;
        if (getTotalBerat() > 10) {
            total = total * 0.9;
        }
        return total;
    }

    public String getInformasiPromo() {
        String promo = "";
        if (getTotalBerat() > 10) {
            promo += "Diskon 10%";
        }
        if (isLuarPulau) {
            if (!promo.isEmpty()) promo += " dan ";
            promo += "Gratis Asuransi";
        }
        return promo.isEmpty() ? "Tidak ada promo" : promo;
    }

    public void tampilkanStruk() {
        System.out.println("Struk Pembayaran");
        System.out.println("Kota tujuan: " + namaKota);
        System.out.println("Berat paket Butet: " + beratButet + " kg");
        System.out.println("Berat paket Ucok: " + beratUcok + " kg");
        System.out.println("Total berat: " + getTotalBerat() + " kg");
        System.out.println("Total ongkos kirim: Rp " + (int)getTotalOngkos());
        System.out.println("Informasi promo yang diperoleh: " + getInformasiPromo());
        System.out.println();
    }
}