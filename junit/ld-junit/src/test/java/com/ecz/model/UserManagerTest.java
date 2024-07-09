package com.ecz.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class UserManagerTest {
    private static Database database;
    private UserManager userManager;
    private User testUser;

    @BeforeAll
    static void setupDatabase() {
        // Initialize a shared database connection (simulated with an in-memory list for this example)
        database = new Database();
        System.out.println("Database initialized.");
    }

    @BeforeEach
    void setUp() {
        // Create a new instance of UserManager for each test
        userManager = new UserManager(database);
        // Create a test user that can be used in tests
        testUser = new User("testUser", "password123");
        // Add a test user to the database before each test
        userManager.addUser(testUser);
        System.out.println("Test user added.");
    }

    @Test
    void addUser() {
        // Create a new user and add it to the UserManager
        User newUser = new User("newUser", "password456");
        userManager.addUser(newUser);
        assertTrue(userManager.userExists(newUser.getUsername()), "User should exist after being added.");
    }

    @Test
    void removeUser() {
        // Remove the test user
        userManager.removeUser(testUser.getUsername());
        assertFalse(userManager.userExists(testUser.getUsername()), "User should not exist after being removed.");
    }

    @AfterEach
    void tearDown() {
        // Clear the database after each test
        database.clear();
        System.out.println("Database cleared.");
    }

    @AfterAll
    static void tearDownDatabase() {
        // Close database connection or clean up resources
        database = null;
        System.out.println("Database connection closed.");
    }
}
 
