package com.springboottodoapplication.config;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateConfig {
    //TODO: create methods to show the day and hours with the correct format from Brazil

    public static String getToday(){
        DayOfWeek dayOfWeek = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek();
        String dayOfWeekString = dayOfWeek.toString();
        return dayOfWeekString.substring(0, 1) + dayOfWeekString.substring(1).toLowerCase();
    }

    public static String getDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return now.format(formatter);
    }
}
