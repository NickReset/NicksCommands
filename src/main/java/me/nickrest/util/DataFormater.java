package me.nickrest.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@UtilityClass
public class DataFormater {
    public static Date format(String time) {
        String[] split = time.split("[^0-9]+");
        int number = Integer.parseInt(split[0]);
        String letter = split[1];
        LocalDateTime date = LocalDateTime.now();
        switch (letter) {
            case "s":
                date = date.plusSeconds(number);
                break;
            case "m":
                date = date.plusMinutes(number);
                break;
            case "h":
                date = date.plusHours(number);
                break;
            case "d":
                date = date.plusDays(number);
                break;
            case "w":
                date = date.plusWeeks(number);
                break;
            case "M":
                date = date.plusMonths(number);
                break;
            case "y":
                date = date.plusYears(number);
                break;
        }
        return new Date(date.toInstant(ZoneOffset.UTC).toEpochMilli());
    }
}
