package datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;

class DateEx {
    public static void main(String[] args) {
        LocalTime maxTime = LocalTime.MAX;
        Duration duration = Duration.ZERO;

        duration.abs();
    }
}