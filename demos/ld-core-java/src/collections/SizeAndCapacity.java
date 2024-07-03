package collections;

import java.util.*;
import java.lang.reflect.Field;

public class SizeAndCapacity {
    public static void main(String[] args) throws Exception {
        // ArrayList - Product IDs
        ArrayList<String> productIds = new ArrayList<>();
        System.out.println("ArrayList initial size: " + productIds.size());
        productIds.addAll(Arrays.asList("P100", "P101", "P102"));
        System.out.println("ArrayList size after adding elements: " + productIds.size());
        System.out.println("ArrayList capacity: " + getArrayListCapacity(productIds));
        for(int i = 0; i < 10; i++) {
            productIds.add("P" + i);
        }
        System.out.println("ArrayList size after adding elements: " + productIds.size());
        System.out.println("ArrayList capacity: " + getArrayListCapacity(productIds));
        // Vector - Product reviews
        Vector<String> productReviews = new Vector<>();
        System.out.println("Vector initial size: " + productReviews.size());
        productReviews.addAll(Arrays.asList("Review1", "Review2", "Review3"));
        System.out.println("Vector size after adding elements: " + productReviews.size());
        System.out.println("Vector capacity: " + productReviews.capacity());
        for(int i = 0; i < 10; i++) {
            productReviews.add("Review" + i);
        }
System.out.println("Vector size after adding elements: " + productReviews.size());
        System.out.println("Vector capacity: " + productReviews.capacity());
        // Stack - Navigation history in an e-commerce app
        Stack<String> navigationHistory = new Stack<>();
        System.out.println("Stack initial size: " + navigationHistory.size());
        navigationHistory.addAll(Arrays.asList("Home", "Category: Electronics", "Product: P100"));
        System.out.println("Stack size after adding elements: " + navigationHistory.size());
        System.out.println("Stack capacity: " + navigationHistory.capacity());
        for(int i = 0; i < 10; i++) {
            navigationHistory.push("Product: P" + i);
        }
        System.out.println("Stack size after adding elements: " + navigationHistory.size());
        System.out.println("Stack capacity: " + navigationHistory.capacity());
    }

    // Reflective method to access ArrayList capacity
    private static int getArrayListCapacity(ArrayList<?> arrayList) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(arrayList)).length;
    }
}