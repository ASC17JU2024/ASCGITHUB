package exceptions;

class Test50 {
	int value = 10;
}

public class MultipleExceptionsSingleCatch {
	public static void main(String[] args) {
		System.out.println();
		Test50 test50 = null;
		 test50 = new Test50();
		try {
			System.out.println(test50.value);
			int i = 200;
			// ArithmeticException
			int result = i / 100;
			System.out.println(result);
			// System.out.println(Test50.value);

		} catch (NullPointerException  | ArithmeticException e) {
			System.out.println("Exception occured");
			System.out.println(e.getMessage());
		}
	}
}
