package exceptions_work;

public class ExceptionWork {
    public static void main(String[] args) {
//  workOnException();
    }
    public static void  workOnException(){
        System.out.println("UE");
        int i = 100;
        int j=0;
        try {
            String string = null;
            System.out.println("try");
            j = i / 0;
            string.toUpperCase();
            System.out.println("Value : " + j);
        }
        catch (NullPointerException | ArithmeticException runtimeException){
            System.out.println(runtimeException.getMessage());
        }
//        catch(Throwable throwable){
//            System.out.println("catch");
//            System.out.println(throwable.getMessage());
//        }
        finally {
            System.out.println("finally");
        }

        System.out.println("? " + j);

    }
}

