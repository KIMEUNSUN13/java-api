package api.utils;


import api.comm.CommConst;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static api.comm.CommConst.Date.yyyyMMdd;

/**
 * JDK 1.7 이하
 * java.util.Date, java.util.Calendar 클래스 사용
 */
public class DateUtil7 {
    private static final String format = yyyyMMdd;

    public static String getToday() {
        return getToDay(format);
    }

    public static String getToDay(String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(calendar.getTime());
    }

    /** ##################################################################### **/

    public static String getOffsetDate(String strDate, int offset) {
        return getOffsetDate(strDate, offset, format);
    }

    public static String getOffsetDate(String strDate, int offset, String format) {
        return getOffsetDate(strDate, offset, format, true);
    }

    public static String getOffsetDate(String strDate, int offset, String format, boolean debug) {
        String offsetDate = "";

        try {
            SimpleDateFormat fmt = new SimpleDateFormat(format);
            Date date = fmt.parse(strDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, offset);

            offsetDate = fmt.format(calendar.getTime());

        } catch (ParseException e) {
            if(debug) {
                System.out.println("DateUtil.getOffsetDate() strDate= " + strDate + ", format= " + format);
            }
        }

        return offsetDate;
    }

    /** ##################################################################### **/

    public static int getDayDiff(String yyyyMMdd1, String yyyyMMdd2) {
        int diff = -1;

        if(yyyyMMdd1.equals(yyyyMMdd2)) {
            return 0;
        }

        int year1 = Integer.parseInt(yyyyMMdd1.substring(0, 4));
        int month1 = Integer.parseInt(yyyyMMdd1.substring(4, 6)) -1;
        int day1 = Integer.parseInt(yyyyMMdd1.substring(6, 8));

        int year2 = Integer.parseInt(yyyyMMdd2.substring(0, 4));
        int month2 = Integer.parseInt(yyyyMMdd2.substring(4, 6)) -1;
        int day2 = Integer.parseInt(yyyyMMdd2.substring(6, 8));

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.clear();
        date2.clear();

        date1.set(year1, month1, day1);
        date2.set(year2, month2, day2);

        diff = (int) ((date2.getTimeInMillis() - date1.getTimeInMillis()) / (24 * 60 * 60 * 1000));

        return Math.abs(diff);
    }
}
