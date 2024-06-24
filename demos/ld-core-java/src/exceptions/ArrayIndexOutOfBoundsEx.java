package exceptions;

// IP : divide by a string accepted from user.
// Exception : abnormal situations that occur during the execution of a program
// java.lang.ArithmeticException
public class ArrayIndexOutOfBoundsEx {
	public static void main(String[] args) {

		int numbers[] = { 2, 3, 5 };
//		for (int i = 0; i <= numbers.length; i++) {
//			System.err.println(numbers[i]);
//		}
		System.out.println(numbers[0]);
		try {
		System.out.println(numbers[3]);
		}
		catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
			System.err.println("Check the index...");
		}
		System.out.println(numbers[2]);
		
	}
}
