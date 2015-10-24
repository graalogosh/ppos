package tk.graalogosh.ppos.utils;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by graal on 11.10.2015.
 */
public class Dates {
    //Minimum and maximum DATE, which MySQL can operate
    public static LocalDate MINDATE = LocalDate.of(1000, 1, 1);
    public static LocalDate MAXDATE = LocalDate.of(9999, 12, 31);

    public static LocalDate getTermStartDate(LocalDate date) {
        switch (date.getMonth()) {
            case JANUARY:
                //TODO check: term starts in July
                return LocalDate.of(LocalDate.now().getYear() - 1, Month.JULY, 1);
            case FEBRUARY:
            case MARCH:
            case APRIL:
            case MAY:
            case JUNE:
                return LocalDate.of(LocalDate.now().getYear(), Month.FEBRUARY, 1);
            case JULY:
            case AUGUST:
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
            case DECEMBER:
                return LocalDate.of(LocalDate.now().getYear(), Month.JULY, 1);
        }
        throw new RuntimeException("LocalDate.getMonth returned value not between Jan and Dec");
    }

    public static LocalDate getTermFinishDate(LocalDate date) {
        switch (date.getMonth()) {
            case JANUARY:
                return LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 31);
            case FEBRUARY:
            case MARCH:
            case APRIL:
            case MAY:
            case JUNE:
                return LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 30);
            case JULY:
            case AUGUST:
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
            case DECEMBER:
                return LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 31);
        }
        throw new RuntimeException("LocalDate.getMonth returned value not between Jan and Dec");
    }
}
