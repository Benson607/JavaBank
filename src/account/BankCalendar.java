package account;

import java.time.LocalDate;

public class BankCalendar {
    private static LocalDate date;

    static {
        date = LocalDate.now();
    }
    public static String now() {
        return date.toString();
    }

    public static void fast_forward_by_day(int day) {
        date = date.plusDays(day);
    }
    
    public static void fast_forward_by_month(int month) {
        date = date.plusMonths(month);
    }

    public static void fast_forward_by_year(int year) {
        date = date.plusYears(year);
    }

    public static LocalDate get_date_object() {
        return date;
    }
}
