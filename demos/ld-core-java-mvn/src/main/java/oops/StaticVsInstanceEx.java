package oops;

public class StaticVsInstanceEx {
public static void main(String[] args) {
//	System.out.println("Start");
//	System.err.println(StaticBlockTest.var);
	StaticBlockTest staticBlockTest = new StaticBlockTest();
	System.out.println(staticBlockTest.instanceVar);
}
}

class StaticBlockTest {
	static String var = "Testing";
	String instanceVar = "Instance Var";
	static {
		var = "Value changed";
		System.out.println("1 This block gets executed when the class is loaded in the memory.");
	}
	static {
		System.out.println("2 This block gets executed when the class is loaded in the memory.");

	}
	static {
		System.out.println("3 This block gets executed when the class is loaded in the memory.");

	}
}