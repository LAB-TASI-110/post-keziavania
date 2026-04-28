package driver;

import java.util.Scanner;
import model.Model2;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input Jumlah Total Data (N)
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // 2. Input Deret Stok (s1, s2, ..., sN)
        int[] stok = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                stok[i] = scanner.nextInt();
            }
        }

        // Konsumsi sisa newline agar tidak mengganggu input string
        scanner.nextLine();

        // 3. Input Kode Kategori Barang
        if (scanner.hasNextLine()) {
            String kategoriRequested = scanner.nextLine();

            // Inisialisasi Model
            Model2 gudang = new Model2(n, stok);

            // Hitung Total
            int hasilTotal = gudang.hitungTotalPerKategori(kategoriRequested);

            // Output Sesuai Permintaan
            System.out.println(hasilTotal);
        }

        scanner.close();
    }
}