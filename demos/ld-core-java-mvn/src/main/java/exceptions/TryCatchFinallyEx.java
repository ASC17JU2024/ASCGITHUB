package exceptions;

public class TryCatchFinallyEx {
	public static void main(String[] args) {
//	tryCatch();
		tryFinally();
//		tryCatchFinally();
	}

	private static void tryCatch() {
		int result = 0, num1 = 100, num2 = 10;
//	num2 = 0;
		System.err.println("Switching the calculator on");
		try {
			result = num1 / num2;
			Object object = null;
//		NullPointerException
			object.toString();
			System.err.println(result);
		} catch (ArithmeticException arithmeticException) {
			System.err.println("Don't divide by zero");
		}
		System.err.println("Shutting down the calculator");
	}

	private static void tryFinally() {
		int result = 0, num1 = 100, num2 = 10;
//		num2 = 0;
		try {
			result = num1 / num2;
		} finally {
			System.err.println("Shtting down the calculator");
		}
		System.err.println(result);
	}

	private static void tryCatchFinally() {
		int result = 0, num1 = 100, num2 = 10;
		num2 = 0;
		try {
			Object object = null;
//			NullPointerException
			object.toString();
			result = num1 / num2;
		} catch (ArithmeticException arithmeticException) {
			System.err.println("Don't divide by zero");
		} 
		catch (NullPointerException nullPointerException) {
			System.err.println("use new keword to create an instance.");
		}finally {
			System.err.println("Shtting down the calculator");
		}
		System.err.println(result);
	}
}
