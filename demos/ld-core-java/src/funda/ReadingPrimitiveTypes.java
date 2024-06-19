package funda;

import java.util.Scanner;

public class ReadingPrimitiveTypes {

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);


        // Read a String input (item name)
        System.out.print("Enter the name of the item: ");
        String itemName = scanner.nextLine();

        // Read a byte input (rating out of 5)
        System.out.print("Enter the rating of the item (0-5): ");
        byte rating = scanner.nextByte();

        // Read a short input (number of items in stock)
        System.out.print("Enter the number of items in stock: ");
        short stock = scanner.nextShort();

        // Read an integer input (quantity to purchase)
        System.out.print("Enter the quantity of the item you want to purchase: ");
        int quantity = scanner.nextInt();

        // Read a long input (product ID)
        System.out.print("Enter the product ID: ");
        long productId = scanner.nextLong();

        // Read a float input (price per item)
        System.out.print("Enter the price of the item (float value): ");
        float price = scanner.nextFloat();

        // Read a double input (discount percentage)
        System.out.print("Enter the discount percentage (e.g., 15.5 for 15.5%): ");
        double discount = scanner.nextDouble();

        // Read a boolean input (membership status)
        System.out.print("Are you a member? (true/false): ");
        boolean isMember = scanner.nextBoolean();

        // Read a char input (category code)
        System.out.print("Enter the category code of the item (single character): ");
        char categoryCode = scanner.next().charAt(0);

        // Display the collected inputs
        System.out.println("\nE-commerce Order Details:");
        System.out.println("Item Name: " + itemName);
        System.out.println("Rating: " + rating);
        System.out.println("Items in Stock: " + stock);
        System.out.println("Quantity to Purchase: " + quantity);
        System.out.println("Product ID: " + productId);
        System.out.println("Price per Item: $" + price);
        System.out.println("Discount Percentage: " + discount + "%");
        System.out.println("Membership Status: " + (isMember ? "Member" : "Non-Member"));
        System.out.println("Category Code: " + categoryCode);

        // Calculate and display the total cost
        double totalCost = quantity * price;
        double discountAmount = totalCost * (discount / 100);
        double finalCost = totalCost - discountAmount;

        System.out.println("Total Cost before Discount: $" + totalCost);
        System.out.println("Discount Amount: $" + discountAmount);
        System.out.println("Final Cost after Discount: $" + finalCost);

        // Close the scanner
        scanner.close();
    }
}
