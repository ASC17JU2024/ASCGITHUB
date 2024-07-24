package exceptions_work;

public class UserDefinedExceptionWo {
    public static void main(String[] args) {
        int age = 500;
        try {
            if (age < 21 || age > 80) {
                AgeInvalidException ageInvalidException = new AgeInvalidException();
                ageInvalidException.setDetailMessage("You are too young or too experienced to work!");
                throw ageInvalidException;
            }

            System.out.println("Great! get the work done!");
        } catch (AgeInvalidException ageInvalidException) {
//            System.out.println("You are too young or too experienced to work!");
            System.out.println(ageInvalidException.getMessage());
        }
    }
}

class AgeInvalidException extends RuntimeException{
    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    private String detailMessage;
@Override
    public String getMessage() {
       System.out.println("Overridden getMessage() method");
        return detailMessage;
    }

}
