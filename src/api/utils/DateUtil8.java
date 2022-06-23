package api.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * JDK 1.8 이상
 * java.util.time 패키지 사용
 */
public class DateUtil8 {
    // private static final String format = DateTimeFormatter.BASIC_ISO_DATE.toString();
    private static final String format = "yyyyMMdd";

    public static String getToDay() {
        return getToDay(format, false);
    }

    public static String getToDay(String format, boolean zoneFlag) {
        if(zoneFlag) {
            ZoneId zoneId = ZoneId.systemDefault();
            return getToDay(format, zoneId);
        }

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.now();
        return localDate.format(fmt);
    }

    public static String getToDay(String format, ZoneId zoneId) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        return zonedDateTime.format(fmt);
    }

    /** ##################################################################### **/

    public static String getOffsetDate(int year, int month, int day, int offset) {
        return getOffsetDate(year, month, day, offset, format);
    }

    public static String getOffsetDate(int year, int month, int day, int offset, String format) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.of(year, month, day).plusDays(offset);
        return localDate.format(fmt);
    }
}
