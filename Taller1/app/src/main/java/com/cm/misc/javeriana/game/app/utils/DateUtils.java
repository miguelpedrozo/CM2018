package com.cm.misc.javeriana.game.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that defines date-related utilities
 */
public class DateUtils {

    public static final String DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";

    /**
     * Format a <code>date</code> using the <code>format</code>
     *
     * @param date   the given date
     * @param format the format defined by the user
     * @return the formatted date
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
