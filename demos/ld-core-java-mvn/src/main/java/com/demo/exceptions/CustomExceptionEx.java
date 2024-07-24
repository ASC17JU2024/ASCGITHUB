package exceptions;

public class CustomExceptionEx {
    public static void main(String[] args) {
//        Object object = new Object();
//        throw object;
        int age = 130;
        try {
            if (age < 21 || age > 80) {
                AgeInvalidException ageInvalidException = new AgeInvalidException("You are too young or too experienced to work!");
                throw ageInvalidException;
            }
            System.out.println("Great! get the work done!");
        }
        catch(AgeInvalidException ageInvalidException) {
            System.out.println(ageInvalidException.getMessage());
//            ageInvalidException.getMyMessage();
        }

    }
}
 class AgeInvalidException extends RuntimeException {
    private String message;
    public AgeInvalidException(String message) {
        //stroring the message internally
//        will expose it throgh getMessage()
        super(message);
//        this.message = message;
    }

//    public String getMyMessage(){
//        return message;
//    }
}
