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

    public static String joinstring(String... string) { //varargs
        StringBuilder rs = new StringBuilder();
        //string.length è il numero di stringhe, restituisce il numero totale di elementi contenuti nell'array di stringhe string
        for (int i = 0; i < string.length; i++) { // aggiunge ogni stringa passata come parametro
            rs.append(string[i]);
            if (i < string.length - 1) {
                rs.append(" ");  // aggiunge spazio solo se non è l’ultima stringa
            }
        }

        return rs.toString();
    }
}
