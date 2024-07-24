package exceptions;

public class ThrowEx {
	public static void main(String[] args) {
		System.out.println("do");
		try {
			// caller / calling function
			int returnValue = notHandledButThrown();
			System.out.println(returnValue);
		} catch (NumberFormatException exception) {
			System.out.println("MAIN");
			System.err.println("finally  " + exception);
		}
		System.err.println("done");
	}

	// callee / called function
	private static Integer handledAndThrown() throws NumberFormatException {
		System.out.println("do1");
		try {
			Integer.parseInt("123X");
//			Integer.parseInt("123");
		} catch (NumberFormatException exception) {
			System.err.println(">>>>  " + exception);
//			rethrowing the exception
			throw exception;
		} finally {
			System.err.println("finally1 ");
		}
		System.err.println("done1");
		return 100;
	}
	
	private static Integer notHandledButThrown() throws NumberFormatException {
		System.out.println("do1");
		try {
			Integer.parseInt("123X");
//			Integer.parseInt("123");
		} finally {
			System.err.println("finally1 ");
		}
		System.err.println("done1");
		return 100;
	}
}
