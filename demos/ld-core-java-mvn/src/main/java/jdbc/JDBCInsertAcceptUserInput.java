package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertAcceptUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "mysql");
            System.out.println("Driver Loaded!");

            // Prompt for and read user input
            System.out.print("Enter user ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            // Prepare statement
            String sql = "INSERT INTO user (user_id, email, first_name, last_name) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameters
            statement.setInt(1, userId);
            statement.setString(2, email);
            statement.setString(3, firstName);
            statement.setString(4, lastName);

            // Execute update
            int noOfRowsAffected = statement.executeUpdate();
            System.out.println("No of rows affected: " + noOfRowsAffected);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // Close resources
            try {
                if (scanner != null) {
                    scanner.close();
                }
                System.out.println("Resources closed.");
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}