package jdbc;

import java.sql.*;

public class JDBCInsert {
    public static void main(String[] args) {
        // Load the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "mysql");
            System.out.println("Driver Loaded!");
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
            int noOfRowsAffected = statement.executeUpdate("INSERT INTO user (user_id, email, first_name, last_name) VALUES(101, 'user1@example.com', 'Sanjay', 'The Boss!')");
            System.out.println("No of rows affected: " + noOfRowsAffected);
        }
//       catch (ClassNotFoundException e) {
//           System.out.println(e.getMessage());
//           System.out.println(e);
//        }
catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Driver Loaded!");
        }
    }
}

