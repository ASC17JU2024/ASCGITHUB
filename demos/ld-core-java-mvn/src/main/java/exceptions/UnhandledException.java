package exceptions;
// IP : divide by a string accepted from user.
// Exception : abnormal situations that occur during the execution of a program
// java.lang.ArithmeticException
public class UnhandledException {
	public static void main(String[] args) {
//		Object testObject = null;
//		testObject.toString();
		String testString = "welcome";
		String upperCase = testString.toUpperCase();
		System.out.println(upperCase);
		System.out.println("Caller begin");
		called();
		System.out.println("Back to caller");
	}

	private static void called() {
		System.err.println("The calculator app");
		int num1 = 0, num2 = 200;
		// exception occurs at thes line
		int result = num2 / num1;
		// program shuts down improperly
		// code below does not get executed
		System.out.println(result);
		System.out.println("Shutting down calculator...");
	}
}
