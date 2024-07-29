package exceptions;
import java.util.logging.Logger;
public class CustomCheckedExceptionEx {

    private static final Logger logger = Logger.getLogger(CustomCheckedExceptionEx.class.getSimpleName());
    public static void main(String[] args) {
        logger.info("Application started...");
        int age = 130;
        try {
            if (age < 21 || age > 80) {
                throw new AgeInvalidException1("You are too young or too experienced to work!");
            }
            logger.info("\"Great! get the work done!\"");

        }
        catch(AgeInvalidException1 ageInvalidException) {
            logger.severe("Exception occurred: " + ageInvalidException.getMessage());


        }

    }
}
 class AgeInvalidException1 extends Exception {

    public AgeInvalidException1(String message) {

        super(message);

    }
}
