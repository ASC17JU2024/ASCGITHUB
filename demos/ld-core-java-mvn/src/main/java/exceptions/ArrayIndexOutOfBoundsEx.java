package exceptions;

import java.util.logging.Level;

import java.util.logging.Logger;
//The java.util.logging package provides several logging levels to categorize the importance and severity of log messages. Here are the different logging levels, from highest to lowest severity:
//SEVERE: Indicates a serious failure.
//WARNING: Indicates a potential problem.
//INFO: Provides informational messages that highlight the progress of the application.
//        ALL: Enables logging of all messages.
//        OFF: Disables logging.

public class ArrayIndexOutOfBoundsEx {
    private static final Logger logger = Logger.getLogger("ArrayIndexOutOfBoundsEx");

    public static void main(String[] args) {

        int[] numbers = {2, 3, 5};

        logger.info(String.valueOf(numbers[0]));
        try {
            logger.info(String.valueOf(numbers[3]));
//            logger.info(String.valueOf(numbers[1]));
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            logger.log(Level.SEVERE, "Check the index...", arrayIndexOutOfBoundsException);
        }
        logger.info(String.valueOf(numbers[2]));
    }
}