package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


// An ordered collection (also known as a sequence).
// The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.
//Unlike sets, lists typically allow duplicate elements. 
// More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2), 
// and they typically allow multiple null elements if they allow null elements at all. 
//It is not inconceivable that someone might wish to implement a list that prohibits duplicates, 
// by throwing runtime exceptions when the user attempts to insert them, 
// but we expect this usage to be rare.
public class SetEx {
	public static void main(String[] args) {
//		begin();
		treeSet();
	}

	private static void begin() {
		// No duplicates / no insertion order / only single null / no indexing
		Set<String> colors = new HashSet<String>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Orange");
		colors.add("Yellow");
//		colors.add(3, "Violet");
//		The method add(String) in the type Set<String> is not applicable for the arguments (int, String)
		colors.add("Orange");
		colors.add(null);
		colors.add("Apple");
		colors.add(null);
		System.out.println(colors);
//		String color1 = colors.get(4);
//		String color2 = colors.get(6);
		System.out.println(colors);
		System.err.println(colors.size());
		System.err.println(colors.isEmpty());
		colors.remove("Blue");
		System.err.println(colors.size());
		System.out.println(colors);
		colors.clear();
		System.err.println(colors.isEmpty());
		System.out.println(colors);
	}
	private static void treeSet() {
		System.err.println("********************");
		// No duplicates / no insertion order / only single null / no indexing
		Set<String> colors = new TreeSet<String>();
//		colors.add(null);
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Orange");
		colors.add("Yellow");
		colors.add("orange");
//		colors.add(3, "Violet");
//		The method add(String) in the type Set<String> is not applicable for the arguments (int, String)
		colors.add("Orange");
		colors.add("oRange");
		colors.add("oRAnge");
//		colors.add(null);
		System.out.println(colors);
//		String color1 = colors.get(4);
//		String color2 = colors.get(6);
		System.out.println(colors);
		System.err.println(colors.size());
		System.err.println(colors.isEmpty());
		colors.remove("Blue");
		System.err.println(colors.size());
		System.out.println(colors);
		colors.clear();
		System.err.println(colors.isEmpty());
		System.out.println(colors);
	}
}
