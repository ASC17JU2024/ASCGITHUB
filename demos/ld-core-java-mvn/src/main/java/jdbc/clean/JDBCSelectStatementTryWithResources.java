package jdbc.clean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

// The "try-with-resources" statement in Java is a helpful language feature designed to simplify resource management and ensure proper cleanup of resources. Here are the key reasons to use it:

// Automatic resource management: It automatically closes resources when they're no longer needed, even if exceptions occur.
// Cleaner code: It reduces boilerplate code, making your program more readable and maintainable.
// Exception handling: It handles exceptions more effectively, including those that might occur during resource closing.
// Multiple resource support: You can manage multiple resources in a single try block.
// Guaranteed cleanup: Resources are closed in the reverse order of their creation, ensuring proper cleanup sequence.
public class JDBCSelectStatementTryWithResources {
    private static final Logger LOGGER = Logger.getLogger(JDBCSelectStatementTryWithResources.class.getName());

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "JDBC Driver not found", e);
            return;
        }

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "mysql";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM user ORDER BY user_id")) {

            LOGGER.info("Connection established!");
            LOGGER.info("Statement created");
            LOGGER.info("Result set returned");

            while (resultSet.next()) {
                LOGGER.info("User ID: " + resultSet.getInt(1));
                LOGGER.info("Email: " + resultSet.getString("email"));
                LOGGER.info("Last Name: " + resultSet.getString("last_name"));
                LOGGER.info("********");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL Exception occurred", e);
        }
    }
}