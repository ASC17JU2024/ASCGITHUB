package com.ecz.model;


//What is JUnit?
//JUnit is a simple framework to write repeatable tests.
//Why JUnit?
//JUnit is a unit testing framework for the Java programming language.
// JUnit has been important in the development of test-driven development.
// JUnit is suitable for only unit testing, not for integration testing.
// JUnit is an open-source framework that is used to write and run repeatable tests.
// JUnit is a Regression Testing Framework used by developers to implement unit testing in Java, and accelerate programming speed and increase the quality of code.
// What is regression?
// Regression is a type of software testing that verifies that software previously developed and tested still performs correctly after it was changed or interfaced with other software.

//Research
// What is BDD?
// BDD (Behavior Driven Development) is a software development process that emerged from TDD (Test Driven Development).
// BDD uses examples to illustrate the behavior of the system that are written in a readable and understandable language for everyone involved in the development.

// Steps to write unit tests
// 1. Create a new Java class in the test folder.
// 2. Add the @Test annotation to the method you want to test.
// 3. Add the code to test your method.
// 4. Run the test.

// Test Case to Test GSJunitProduct Class
// Create a new Java class named GSJunitProductTest in the test folder.
// Add the following code to the GSJunitProductTest class:
// package com.ecz.model;
// class GSJunitProductTest {
//     // Declare GSJunitProduct instance for testing
//     private GSJunitProduct product;
//  Add test cases to test the GSJunitProduct class.
//     @Test
//     void testProduct() {
//         product = new GSJunitProduct(); // Initialize GSJunitProduct
//         assertNotNull(product); // Assert GSJunitProduct is not null
//     }
// }

// JUnit Lifecycle
// JUnit provides annotations to define the lifecycle of a test case.
// These annotations are used to perform actions before and after the test methods.

import com.ecz.exceptions.InvalidProductException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GSJunitProductTest {
    private GSJunitProduct product;
    @Test
    void testProductShouldNotBeCreated() {
        assertThrows(UnsupportedOperationException.class, () -> new GSJunitProduct());
//       void method() {
//            new GSJunitProduct();
//        }
    }

    @Test
    void testProductCreation() {
        product = new GSJunitProduct("1", "Laptop", -999.99);
        assertNotNull(product);
    }

    @Test
    void testProductCreationWithNegativePrice() {
        assertThrows(InvalidProductException.class, () -> new GSJunitProduct("1", "Laptop", -999.99));
    }
}
