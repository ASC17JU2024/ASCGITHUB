package datetime;

import java.time.Duration;

public class DurationFormatted {

    // This method is already compatible with Java 8.
    public static Duration ofDays(long days) {
        long SECONDS_PER_DAY = 86400L;
        return Duration.ofSeconds(days * SECONDS_PER_DAY);
    }

    // Example method to format a Duration in HH:MM:SS format in Java 8
    public static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    public static void main(String[] args) {
        // Example usage of ofDays
        Duration duration = ofDays(1); // 1 day
        System.out.println("Duration of 1 day in seconds: " + duration.getSeconds());

        // Formatting duration to HH:MM:SS
        String formattedDuration = formatDuration(duration);
        System.out.println("Formatted Duration: " + formattedDuration);
    }
}