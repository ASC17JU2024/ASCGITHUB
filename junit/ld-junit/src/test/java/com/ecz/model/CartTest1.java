package com.ecz.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CartTest1 {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        product1 = new Product("1", "Laptop", 999.99);
        product2 = new Product("2", "Smartphone", 499.99);
    }

    @Test
    void testAddProduct() {
        cart.addProduct(product1);
        // assertEquals checks if two values are equal. It's used here to verify that the cart contains one product after adding.
        assertEquals(1, cart.getProductCount(), "Cart should contain one product after adding.");
        // assertTrue checks if a condition is true. It's used here to verify that the added product is in the cart.
        assertTrue(cart.getProducts().contains(product1), "Cart should contain the added product.");
        // assertNotNull checks if an object is not null. It's used here to verify that the product list in the cart is not null.
        assertNotNull(cart.getProducts(), "Product list should not be null after adding a product.");
    }

    @Test
    void testRemoveProduct() {
        cart.addProduct(product1);
        cart.removeProduct(product1);
        assertEquals(0, cart.getProductCount(), "Cart should be empty after removing the product.");
        assertFalse(cart.getProducts().contains(product1), "Cart should not contain the removed product.");
    }

    @Test
    void testCartTotalValue() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        double expectedTotal = product1.getPrice() + product2.getPrice();
        // assertEquals checks if two values are equal. It's used here to verify that the calculated total value of the cart
        // matches the expected total, which is the sum of the prices of the products added to the cart.
        assertEquals(expectedTotal, cart.calculateTotalValue(), "Total cart value should be the sum of the product prices.");
    }
    
    @Test
    void testEmptyCart() {
        // assertTrue checks if a condition is true. It's used here to verify that the cart is empty upon initialization.
        assertTrue(cart.getProducts().isEmpty(), "Newly initialized cart should be empty.");
    }
    
    @Test
    void testProductNotInCart() {
        // assertThrows checks if executing a specific action throws a specific type of exception.
        // It's used here to verify that attempting to remove a product not present in the cart throws an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> cart.removeProduct(product1), "Removing a product not in the cart should throw an exception.");
    }
    
    @Test
    void testClearCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.clearCart();
        // assertAll is used to group multiple assertions, all of which must pass. If any assertion fails, the test fails.
        // It's used here to verify both that the product count is 0 and the products list is empty after clearing the cart.

 /*        The key difference between using individual asserts and assertAll in a testing framework like JUnit for Java lies in how they handle multiple assertions within a single test method:

 Individual Asserts: When you use individual asserts (e.g., assertEquals, assertTrue, etc.) in a test method, the test execution stops at the first assertion that fails. Any subsequent assertions in the same test method are not executed. This approach can make it quicker to identify a failure, but it may not give a complete picture of all issues present if multiple assertions would fail.

 assertAll: This approach allows you to group multiple assertions together. When using assertAll, all assertions within the assertAll block are executed, regardless of whether some of them fail. Only after all assertions have been executed will any failures be reported. This means you get a comprehensive report of all assertions that failed in the assertAll block, allowing you to see all issues at once instead of discovering them one by one through successive test runs.

 In summary, the use of assertAll is beneficial when you want to ensure that all assertions are checked and reported in a single test run, providing a more complete assessment of the test's success or failure. */

        assertAll("Cart should be empty after clearing",
                () -> assertEquals(0, cart.getProductCount(), "Cart product count should be 0."),
                () -> assertTrue(cart.getProducts().isEmpty(), "Cart products list should be empty.")
        );
    }



    @Test
    void testProductEquality() {
        Product anotherProduct1 = new Product("1", "Laptop", 999.99);
        assertEquals(product1, anotherProduct1, "Two products with the same ID, name, and price should be equal.");
    }

    @Test
    void testCartNotNull() {
        assertNotNull(cart, "Cart instance should not be null after initialization.");
    }

    @Test
    void testAddMultipleProducts() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertIterableEquals(Arrays.asList(product1, product2), cart.getProducts(), "Cart should contain both added products.");
    }

    @Test
    void testProductNotSame() {
        Product anotherProduct1 = new Product("1", "Laptop", 999.99);
        assertNotSame(product1, anotherProduct1, "Two product instances with the same properties should not be the same instance.");
    }
}