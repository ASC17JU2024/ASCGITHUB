package datetime;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static void main(String[] args) {
        // Define the formatter to print the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        // Current date and time in IST
        ZonedDateTime istDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current time in IST: " + istDateTime.format(formatter));

        // Convert to EST
        ZonedDateTime estDateTime = istDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Converted time in EST: " + estDateTime.format(formatter));
    }
}