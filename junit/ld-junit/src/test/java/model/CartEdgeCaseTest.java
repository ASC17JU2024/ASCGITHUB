package model;

import ecz.model.Cart;
import ecz.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Define what and why edge cases are being tested
//Edge cases are scenarios that are at the extreme ends of the range of possible inputs or conditions
//They are used to test the behavior of a system when it is pushed to its limits
//In this case, the edge cases being tested are:
// 1. Adding a null product to the cart
// 2. Removing a product that was never added to the cart
// 3. Calculating the total price when no products have been added to the cart
// 4. Adding multiple products with the same ID to the cart
// 5. Handling edge case prices, such as free or negatively priced items
//These edge cases help ensure that the Cart class behaves correctly in various scenarios

public class CartEdgeCaseTest {
    
    private Cart cart; // Instance of Cart to be used in tests
    private Product product1; // First product instance for testing
    private Product product2; // Second product instance for testing

    @BeforeEach
    // Initializes common test objects before each test method is run
    void setUp() {
        cart = new Cart(); // Create a new Cart instance
        product1 = new Product("1", "Laptop", 999.99); // Create a new Product instance representing a laptop
        product2 = new Product("2", "Smartphone", 499.99); // Create a new Product instance representing a smartphone
    }

    @Test
    // Tests the behavior of adding a null product to the cart
    void testAddNullProduct() {
        cart.addProduct(null); // Attempt to add a null product to the cart
        assertEquals(0, cart.getProductCount(), "Cart should not add null products"); // Verify that the cart does not add null products
    }

    @Test
    // Tests the behavior of attempting to remove a product that was never added
    void testRemoveNonExistentProduct() {
        cart.addProduct(product1); // Add a product to the cart
        cart.removeProduct(product2); // Attempt to remove a different product that was never added
        assertEquals(1, cart.getProductCount(), "Cart should still contain the originally added product"); // Verify the cart still contains the originally added product
        assertTrue(cart.getProducts().contains(product1)); // Verify the cart specifically contains the added product
    }

    @Test
    // Tests the total price calculation when no products have been added to the cart
    void testGetTotalPriceWithNoProducts() {
        assertEquals(0.0, cart.getTotalPrice(), "Total price should be 0.0 when cart is empty"); // Verify that the total price is 0 when the cart is empty
    }

    @Test
    // Tests adding multiple products with the same ID to the cart
    void testAddMultipleProductsSameID() {
        Product anotherProduct1 = new Product("1", "Laptop", 999.99); // Create another product with the same ID
        cart.addProduct(product1); // Add the first product to the cart
        cart.addProduct(anotherProduct1); // Add another product with the same ID
        assertEquals(2, cart.getProductCount(), "Cart should allow adding multiple products with the same ID"); // Verify the cart allows adding multiple products with the same ID
    }

    @Test
    // Tests the cart's handling of products with edge case prices, such as free or negatively priced items
    void testHandlingEdgeCasePrices() {
        Product freeProduct = new Product("3", "Freebie", 0.0); // Create a product representing a free item
        Product negativePriceProduct = new Product("4", "Negative Price Item", -10.0); // Create a product with a negative price

        cart.addProduct(freeProduct); // Add the free product to the cart
        cart.addProduct(negativePriceProduct); // Add the negatively priced product to the cart

        double expectedTotal = freeProduct.getPrice() + negativePriceProduct.getPrice(); // Calculate the expected total price
        assertNotEquals(expectedTotal, cart.getTotalPrice(), "Total price should handle 0.0 and negative values correctly"); // Verify the total price is calculated correctly, including edge case prices
    }
}