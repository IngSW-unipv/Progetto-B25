package Model.Util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataConverter {


    public static String dateconverter(LocalDate date) {
        DateTimeFormatter itaformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(itaformat);
    }

    public static String timeconverter(LocalTime time) {
        DateTimeFormatter itaformat = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(itaformat);
    }
}
