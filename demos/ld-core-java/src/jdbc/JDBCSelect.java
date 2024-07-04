package jdbc;

import java.sql.*;

public class JDBCSelect {
    public static void main(String[] args) {
        // Load the driver class
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "mysql");
            System.out.println("Driver Loaded!");
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
            ResultSet resultSet = statement.executeQuery("select * from user order by user_id");
            System.out.println("Result set returned");
//            if(resultSet.next()) {
//                System.out.println("user id " + resultSet.getInt(1));
//                System.out.println("user id " + resultSet.getInt("user_id"));
//            }
            boolean noRecord = true;
            while(resultSet.next()) {
                noRecord = false;
                System.out.println("User Id: " + resultSet.getInt(1) + " Email: " + resultSet.getString("email") + " Last Name: " + resultSet.getString("last_name"));
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

