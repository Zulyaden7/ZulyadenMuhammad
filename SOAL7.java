import java.util.Scanner;

class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private boolean tersedia;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = true;
    }

    public void tampilkanInfoBuku() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Status: " + (tersedia ? "Tersedia" : "Dipinjam"));
        System.out.println();
    }

    public void pinjamBuku() {
        if (tersedia) {
            System.out.println("Buku berhasil dipinjam.");
            tersedia = false;
        } else {
            System.out.println("Maaf, buku sedang tidak tersedia.");
        }
    }

    public boolean cekJudul(String judulCek) {
        return this.judul.equalsIgnoreCase(judulCek);
    }

    public boolean isTersedia() {
        return tersedia;
    }
}

public class SOAL7 {
    public static void main(String[] args) {
        // Daftar buku
        Buku[] daftarBuku = {
            new Buku("Berjuta Rasanya", "Tere Liye", 2018),
            new Buku("Seni Mengajar Dengan Hati", "Dani Romlie", 2009),
            new Buku("Filosofi Teras", "Henry Ramandopi", 2021)
        };

        // Menampilkan daftar buku yang tersedia
        System.out.println("Daftar Buku yang Tersedia:");
        for (Buku buku : daftarBuku) {
            buku.tampilkanInfoBuku();
        }

        // Meminta input judul buku yang ingin dipinjam
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul buku yang ingin dipinjam: ");
        String judulBuku = scanner.nextLine();

        boolean bukuDitemukan = false;
        for (Buku buku : daftarBuku) {
            if (buku.cekJudul(judulBuku) && buku.isTersedia()) {
                buku.pinjamBuku();
                bukuDitemukan = true;
                break;
            } else if (buku.cekJudul(judulBuku) && !buku.isTersedia()) {
                System.out.println("Maaf, buku sudah tidak tersedia.");
                bukuDitemukan = true;
                break;
            }
        }

        if (!bukuDitemukan) {
            System.out.println("Buku tidak ditemukan dalam daftar atau tidak tersedia.");
        }
    }
}
