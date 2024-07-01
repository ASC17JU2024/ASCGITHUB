package collections;

import java.util.ArrayList;
import java.util.List;

// An ordered collection (also known as a sequence).
// The user of this interface has precise control over where in the list each element is inserted.
// The user can access elements by their integer index (position in the list), and search for elements in the list.
//Unlike sets, lists typically allow duplicate elements. 
// More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2), 
// and they typically allow multiple null elements if they allow null elements at all. 
//It is not inconceivable that someone might wish to implement a list that prohibits duplicates, 
// by throwing runtime exceptions when the user attempts to insert them, 
// but we expect this usage to be rare.
public class ArrayListEx {
	public static void main(String[] args) {
		begin();
	}

	private static void begin() {
		// IP : Create Integer ArraysList of ages.
		List<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Orange");
		colors.add("Yellow");
		colors.add(3, "Violet");
		colors.add("Orange");
		colors.add(null);
		colors.add("Apple");
		colors.add(null);
		System.out.println(colors);
		String color1 = colors.get(4);
		String color2 = colors.get(6);
		if(color1.equals(color2))
			{
			System.out.println("Colors are same");
			}
		else {
			 System.err.println ("Colors are not same");
		}
		if(color1 == color2){
			System.err.println("Identical");
		}
		System.out.println(colors.get(4));
		System.out.println(colors);
		System.err.println(colors.size());
		System.err.println(colors.isEmpty());
		colors.remove("Blue");
		System.err.println(colors.size());
		System.out.println(colors);
		colors.clear();
		System.err.println(colors.isEmpty());
		System.out.println(colors);

//		for (String colorString : colors) {
//			System.out.println(colorString);
//		}
//
//		String second = colors.get(1);
//		System.out.println(second);
//
//		colors.remove(1);
//		colors.remove("Green");
		
		
//		ArrayList<String> colorsToBeRemovedList = new ArrayList<String>();
//		colorsToBeRemovedList.add("Red");
//		colorsToBeRemovedList.add("Green");
//		colors.removeAll(colorsToBeRemovedList);
//		System.out.println(colors);
	}
}
