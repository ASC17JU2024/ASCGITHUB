package com.ecz.model;

// Import static methods from Assertions class for easier readability in tests
import static org.junit.jupiter.api.Assertions.*;
// Import BeforeEach annotation to specify a method to run before each test
import org.junit.jupiter.api.BeforeEach;
// Import Test annotation to denote test methods
import org.junit.jupiter.api.Test;

public class CartTest {
    // Declare Cart instance to test
    private Cart cart;
    // Declare Product instances for testing
    private Product product1;
    private Product product2;

    @BeforeEach
        // Setup method to initialize common objects before each test
    void setUp() {
        cart = new Cart(); // Initialize Cart
        product1 = new Product("1", "Laptop", 999.99); // Initialize first test Product
        product2 = new Product("2", "Smartphone", 499.99); // Initialize second test Product
    }

    @Test
        // Test adding a product to the cart
    void testAddProduct() {
        cart.addProduct(product1); // Add product1 to cart
        assertEquals(1, cart.getProductCount()); // Assert cart contains one product
        assertTrue(cart.getProducts().contains(product1)); // Assert cart contains product1
    }

    @Test
        // Test removing a product from the cart
    void testRemoveProduct() {
        cart.addProduct(product1); // Add product1 to cart
        cart.removeProduct(product1); // Remove product1 from cart
        assertEquals(0, cart.getProductCount()); // Assert cart is empty
        assertFalse(cart.getProducts().contains(product1)); // Assert cart does not contain product1
    }

    @Test
        // Test calculating the total price of products in the cart
    void testGetTotalPrice() {
        cart.addProduct(product1); // Add product1 to cart
        cart.addProduct(product2); // Add product2 to cart
        double expectedTotalPrice = product1.getPrice() + product2.getPrice(); // Calculate expected total price
        assertEquals(expectedTotalPrice, cart.getTotalPrice()); // Assert total price matches expected value

    }

}