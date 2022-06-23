package api.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * JDK 1.8 이상
 * java.util.time 패키지 사용
 */
public class DateUtil8 {
    private static final String format = DateTimeFormatter.BASIC_ISO_DATE.toString();

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

}
