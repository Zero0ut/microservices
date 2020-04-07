package com.example.springbootdemo.util;

import java.time.LocalDate;
import java.util.Calendar;

public class DateTimeHelper {

    public static Calendar convert(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
        return calendar;
    }
}
