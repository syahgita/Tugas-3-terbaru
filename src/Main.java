import java.util.InputMismatchException;
import java.util.Scanner;

//Dinar


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DaftarBelanjaa daftar = new DaftarBelanjaa();
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n=== MENU DAFTAR BELANJA ===");
            System.out.println("1. Tambah Item Biasa");
            System.out.println("2. Tambah Item Prioritas");
            System.out.println("3. Tampilkan Semua Item");
            System.out.println("4. Hapus Item");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = input.nextInt();
                input.nextLine(); // konsumsi newline
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine(); // bersihkan buffer
                continue;
            }

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Nama Item: ");
                    String nama = input.nextLine();
                    System.out.print("Jumlah: ");
                    int jumlah = getValidInt(input);
                    daftar.tambahItem(new ItemBelanja(nama, jumlah));
                }
                case 2 -> {
                    System.out.print("Nama Item: ");
                    String nama = input.nextLine();
                    System.out.print("Jumlah: ");
                    int jumlah = getValidInt(input);
                    input.nextLine(); // konsumsi newline
                    System.out.print("Prioritas (TINGGI/SEDANG/RENDAH): ");
                    String prioritas = input.nextLine().trim().toUpperCase();
                    try {
                        daftar.tambahItem(new ItemPrioritas(nama, jumlah, prioritas));
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                }
                case 3 -> daftar.tampilkanSemuaItem();
                case 4 -> {
                    System.out.print("Masukkan index item yang ingin dihapus: ");
                    int index = getValidInt(input);
                    daftar.hapusItem(index);
                }
                case 0 -> System.out.println("Terima kasih telah menggunakan aplikasi 😊");
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        input.close();
    }

    private static int getValidInt(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka. Coba lagi: ");
                input.nextLine(); // bersihkan buffer
            }
        }
    }
}
