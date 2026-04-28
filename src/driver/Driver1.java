package driver;

import java.util.Scanner;
import java.util.ArrayList;
import model.Model1;

public class Driver1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Model1> daftarPengiriman = new ArrayList<>();

        while (true) {
            if (!input.hasNext()) break;
            
            String kode = input.next();
            
            if (kode.equalsIgnoreCase("END")) {
                break;
            }

            if (input.hasNextDouble()) {
                double berat = input.nextDouble();
                daftarPengiriman.add(new Model1(kode, berat));
            }
        }

        // Output hanya keluar setelah semua input selesai dan mengetik END
        for (Model1 item : daftarPengiriman) {
            item.tampilkanStruk();
        }

        input.close();
    }
}