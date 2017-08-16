package com.analytics.dau;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by avetisyan on 8/14/2017.
 */
public class Util {

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String getStrFromDate(Date date) {
        return format.format(date);
    }

    public static Date getDate(String date) throws ParseException {
        return format.parse(date);
    }
}
