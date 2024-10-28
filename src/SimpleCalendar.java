// SimpleCalendar.java
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Kelas SimpleCalendar digunakan untuk menampilkan kalender sederhana
 * berdasarkan bulan dan tahun yang diberikan.
 */
public class SimpleCalendar {
    private int month; // Variable untuk menyimpan bulan
    private int year;  // Variable untuk menyimpan tahun

    /**
     * Constructor untuk menginisialisasi bulan dan tahun.
     *
     * @param month Bulan yang akan ditampilkan (1-12)
     * @param year Tahun yang akan ditampilkan
     */
    public SimpleCalendar(int month, int year) {
        this.month = month;
        this.year = year;
    }

    /**
     * Menampilkan kalender untuk bulan dan tahun yang ditentukan.
     */
    public void displayCalendar() {
        YearMonth yearMonth = YearMonth.of(year, month);
        String monthName = getmounth(yearMonth);
        int daysInMonth = yearMonth.lengthOfMonth();
        int dayOfWeek = getFirstDayOfWeek(yearMonth); // Extract Method: Mendapatkan hari pertama dalam minggu

        printHeader(monthName); // Extract Method: Mencetak header
        printDays(dayOfWeek, daysInMonth); // Extract Method: Mencetak hari-hari dalam bulan
    }

    /**
     * Mendapatkan nama bulan dari YearMonth.
     *
     * @param yearMonth Objek YearMonth yang merepresentasikan bulan dan tahun
     * @return Nama bulan dalam format teks
     */
    private String getmounth(YearMonth yearMonth) {
        String monthName = getMonthName(yearMonth); // Extract Method: Mendapatkan nama bulan
        return monthName;
    }

    /**
     * Mengambil nama bulan.
     *
     * @param yearMonth Objek YearMonth yang merepresentasikan bulan dan tahun
     * @return Nama bulan dalam format teks
     */
    private String getMonthName(YearMonth yearMonth) { // Extract Method: Memisahkan logika nama bulan
        return yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    /**
     * Mendapatkan hari pertama dalam minggu untuk bulan dan tahun yang ditentukan.
     *
     * @param yearMonth Objek YearMonth yang merepresentasikan bulan dan tahun
     * @return Indeks hari pertama dalam minggu (0 = Minggu, 6 = Sabtu)
     */
    private int getFirstDayOfWeek(YearMonth yearMonth) { // Extract Method: Memisahkan logika hari pertama
        int dayOfWeek = yearMonth.atDay(1).getDayOfWeek().getValue();
        return dayOfWeek % 7;  // Mengubah agar Minggu = 0, Sabtu = 6
    }

    /**
     * Menampilkan header kalender dengan nama bulan dan tahun.
     *
     * @param monthName Nama bulan yang akan ditampilkan
     */
    private void printHeader(String monthName) { // Extract Method: Memisahkan logika header
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * Menampilkan hari-hari dalam bulan.
     *
     * @param firstDayOfWeek Indeks hari pertama dalam minggu (0 = Minggu, 6 = Sabtu)
     * @param daysInMonth Jumlah hari dalam bulan
     */
    private void printDays(int firstDayOfWeek, int daysInMonth) { // Extract Method: Memisahkan logika hari
        // Spasi untuk hari pertama
        for (int i = 0; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }

        // Menampilkan hari-hari dalam bulan
        int dayOfWeek = firstDayOfWeek;
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            dayOfWeek++;
            if (dayOfWeek == 7) { // Ganti baris setelah Sabtu
                System.out.println();
                dayOfWeek = 0;
            }
        }
        System.out.println();
    }
}

