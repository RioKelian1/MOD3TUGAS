// Main.java
import java.util.Scanner;

/**
 * Kelas Main berfungsi sebagai titik masuk untuk menjalankan aplikasi kalender sederhana.
 * Kelas ini mengumpulkan input dari pengguna untuk bulan dan tahun,
 * kemudian menampilkan kalender untuk bulan dan tahun tersebut.
 */
public class Main {
    /**
     * Metode utama yang menjalankan aplikasi kalender.
     *
     * @param args Argumen yang diterima dari baris perintah (tidak digunakan dalam aplikasi ini)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mendapatkan input bulan dan tahun dari pengguna
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // Membuat objek SimpleCalendar dan menampilkan kalender
        SimpleCalendar calendar = new SimpleCalendar(month, year);
        calendar.displayCalendar();

        scanner.close();
    }
}
