package exceptions_work;

public class UserDefinedExceptionWo1 {
    public static void main(String[] args) {
        Object object = new Object();
        int age = 500;
        try {
            if (age < 21 || age > 80) {
                AgeInvalidException1 ageInvalidException = new AgeInvalidException1("You are too young or too experienced to work!");
                throw ageInvalidException;
            }

            System.out.println("Great! get the work done!");
        } catch (AgeInvalidException1 ageInvalidException) {
//            System.out.println("You are too young or too experienced to work!");
            System.out.println(ageInvalidException.getMessage());
            System.out.println(">" + ageInvalidException.toString());
            System.out.println(">" + ageInvalidException.hashCode());
        }
    }
}


class AgeInvalidException1 extends RuntimeException {
    AgeInvalidException1(String message) {

        System.out.println("Overridden getMessage() method");

    }
}
