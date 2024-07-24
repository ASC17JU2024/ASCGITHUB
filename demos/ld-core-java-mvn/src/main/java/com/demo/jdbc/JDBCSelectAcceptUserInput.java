package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCSelectAcceptUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Load the driver class
        try {

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

//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "mysql");
            System.out.println("Driver Loaded!");
//            Statement statement = connection.createStatement();
            PreparedStatement statement = connection.prepareStatement("select * from user where user_id = ? and first_name = ?  order by user_id ;");
//            System.out.println("Statement created");
//            ResultSet resultSet = statement.executeQuery("select * from user where user_id = " + userId + " and first_name = '" + firstName  + "' order by user_id ;");
            statement.setInt(1, userId);
            statement.setString(2, firstName);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Result set returned");
//            if(resultSet.next()) {
//                System.out.println("user id " + resultSet.getInt(1));
//                System.out.println("user id " + resultSet.getInt("user_id"));
//            }
            boolean noRecord = true;
            while(resultSet.next()) {
                noRecord = false;
           System.out.println("User Id: " + resultSet.getInt(1) + " Email: " + resultSet.getString("email") + " Last Name: " + resultSet.getString("last_name")  + " First Name: " + resultSet.getString("first_name") )  ;
                System.out.println("********");
            }
            if(noRecord) {
                System.out.println("No data found!");
            }
        }
//       catch (ClassNotFoundException e) {
//           System.out.println(e.getMessage());
//           System.out.println(e);
//        }
catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Driver Loaded!");
        }
    }
}

