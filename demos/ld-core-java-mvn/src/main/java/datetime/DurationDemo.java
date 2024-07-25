package datetime;// Importing the Duration class from the java.time package.
// java.time.Duration: A time-based amount of time, such as '34.5 seconds'.
import java.time.Duration;

// How is duration stored internally:
// Duration in Java is stored internally as a combination of seconds and nanoseconds. 
// This design allows it to represent both large durations (with the seconds part) 
// and very precise durations (with the nanoseconds part). 
// - Seconds: This part stores the whole seconds of the duration. It's a long value.
// - Nanoseconds: This part stores the nanosecond adjustment to the duration, ensuring precision. It's an int value.

public class DurationDemo {

    public static void main(String[] args) {
        // Creating durations
        // Duration.ofHours(long hours): Creates a Duration representing a number of hours.
        Duration duration1 = Duration.ofHours(2); // Represents a duration of 2 hours.
        // Duration.ofMinutes(long minutes): Creates a Duration representing a number of minutes.
        Duration duration2 = Duration.ofMinutes(30); // Represents a duration of 30 minutes.

        // Adding durations
        // Duration.plus(Duration duration): Returns a copy of this duration with the specified duration added.
        Duration totalDuration = duration1.plus(duration2); // Adds duration2 to duration1.
        System.out.println("Total Duration: " + totalDuration); // Prints the total duration.

        // Subtracting durations
        // Duration.minus(Duration duration): Returns a copy of this duration with the specified duration subtracted.
        Duration remainingDuration = totalDuration.minus(Duration.ofMinutes(15)); // Subtracts 15 minutes from totalDuration.
        System.out.println("Remaining Duration: " + remainingDuration); // Prints the remaining duration.

        // Multiplying duration
        // Duration.multipliedBy(long multiplicand): Returns a copy of this duration multiplied by the scalar.
        Duration doubledDuration = duration2.multipliedBy(2); // Multiplies duration2 by 2.
        System.out.println("Doubled Duration: " + doubledDuration); // Prints the doubled duration.

        // Comparing durations
        // Duration.compareTo(Duration otherDuration): Compares this duration with another duration.
        if (duration1.compareTo(duration2) > 0) {
            System.out.println("Duration1 is longer than Duration2"); // Prints if duration1 is longer than duration2.
        } else if (duration1.compareTo(duration2) < 0) {
            System.out.println("Duration1 is shorter than Duration2"); // Prints if duration1 is shorter than duration2.
        } else {
            System.out.println("Both durations are equal"); // Prints if both durations are equal.
        }

        // Converting durations
        // Duration.getSeconds(): Gets the number of seconds in this duration.
        long seconds = duration1.getSeconds(); // Gets the seconds in duration1.
        System.out.println("Duration1 in seconds: " + seconds); // Prints the seconds in duration1.

        // Getting specific units from a duration
        // Duration.toMinutes(): Converts this duration to the total length in minutes.
        long minutes = duration1.toMinutes(); // Converts duration1 to minutes.
        System.out.println("Duration1 in minutes: " + minutes); // Prints the minutes in duration1.
    }
}