package com.ecz.model;

/*
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
*/
// JUnit Lifecycle
// JUnit provides annotations to define the lifecycle of a test case.
// These annotations are used to perform actions before and after the test methods.
// The lifecycle of a test case includes the following annotations:
// @BeforeAll: This annotation is used to signal that the annotated method should be executed before all tests in the current test class.
// @BeforeEach: This annotation is used to signal that the annotated method should be executed before each test in the current test class.
// @AfterEach: This annotation is used to signal that the annotated method should be executed after each test in the current test class.
// @AfterAll: This annotation is used to signal that the annotated method should be executed after all tests in the current test class.
// These annotations help in setting up the test environment, executing the test, and cleaning up the test environment after the test is executed.
// The lifecycle annotations are used to ensure that the test environment is properly set up and cleaned up before and after each test method is executed.
// The lifecycle annotations help in maintaining the state of the test environment and ensure that each test method is executed in isolation.
// The lifecycle annotations are used to manage the setup and teardown of the test environment and ensure that the test methods are executed correctly.




import com.ecz.exceptions.InvalidProductException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class GSJunitProductLifeCycleTest {
  private static Product product;
  @BeforeAll
  static void setupProduct(){
    System.out.println("Setting up product");
    product = new Product("1", "Laptop", 999.99);
  }
  @BeforeEach
  void setupProductBeforeTest(){
    System.out.println("Setting up product before each test");

  }
  @AfterEach
  void setupProductAfterTest(){
    System.out.println("Setting up product after each test");

  }
  @Test
    void testValidPrice(){
    System.out.println("Testing valid price");
     assertTrue(product.getPrice() > 0);
     assertEquals(999.99, product.getPrice());
  }
  @Test
  void testIsCostlyProduct(){
    System.out.println("Testing costly product");
    System.out.println(product.getPrice());
    assertTrue(product.getPrice() > 500);
  }
  @Test
  void testValidName(){
    System.out.println("Testing valid name");
    assertNotNull(product.getName());
    assertEquals("Laptop", product.getName());
  }
  @AfterAll
    static void tearDownProduct(){
        System.out.println("Tearing down product");
        product = null;
    }
}
