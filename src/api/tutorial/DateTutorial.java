package api.tutorial;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static api.comm.CommConst.Date.yyyyMMdd;

public class DateTutorial {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("[date] " + date);

        Calendar calendar = Calendar.getInstance();
        System.out.println("[calendar] " + calendarToString(calendar));

        // UTC 기준
        Instant instant = Instant.now();
        System.out.println("[instant] " + instant);

        // 날짜 정보만
        LocalDate localDate = LocalDate.now();
        System.out.println("[localDate] " + localDate);

        // 시간 정보만
        LocalTime localTime = LocalTime.now();
        System.out.println("[localTime] " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("[localDateTime] " + localDateTime);

        /*ZoneId.getAvailableZoneIds()
                .stream()
                .filter(s -> s.startsWith("Asia"))
                .sorted()
                .forEach(System.out::println);*/

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("[zonedDateTime] " + zonedDateTime);

        // 출력 포멧 지정
        SimpleDateFormat legacyFmt = new SimpleDateFormat(yyyyMMdd);
        System.out.println(legacyFmt.format(date));

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(yyyyMMdd);
        System.out.println(zonedDateTime.format(fmt));
    }

    public static String calendarToString(Calendar calendar) {
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE);
    }
}
