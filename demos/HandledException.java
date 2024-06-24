
// IP : divide by a string accepted from user.
// Exception : abnormal situations that occur during the execution of a program
// java.lang.ArithmeticException
public class HandledException {

		public static void main(String[] args) {

			System.out.println("Caller begin");
			called();
			System.out.println("Back to caller");
		}

		private static void called() {
			System.err.println("The  app");
			int num1 = 0, num2 = 200;
			int result = 0;
			// exception occurs at thes line
			try {
				String testString = null;
				testString.toUpperCase();
				result = num2 / num1;
				System.out.println("Will this execute?");
			}
			catch (Throwable throwable)
			{
	System.out.println("Exception " + throwable);

			}
			// program shuts down improperly
			// code below does not get executed
			System.err.println(result);
			System.err.println("Called ending...");
		}
	}