package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDelete {
    public static void main(String[] args) {
        // Load the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "mysql");
            System.out.println("Driver Loaded!");
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
            int noOfRowsAffected = statement.executeUpdate("delete from `user`");
            System.out.println("No of rows deleted: " + noOfRowsAffected);
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

