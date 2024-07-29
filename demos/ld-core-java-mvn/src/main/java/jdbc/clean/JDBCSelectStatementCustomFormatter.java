package jdbc.clean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class JDBCSelectStatementCustomFormatter {
    private static final Logger LOGGER = Logger.getLogger(JDBCSelectStatement.class.getName());

    static {
        // Set custom formatter
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(handler);
        LOGGER.setUseParentHandlers(false); // Prevent logging to the parent handlers
    }

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
            LOGGER.log(Level.SEVERE, "SQL Exception occurred" +  e);
        }
    }

    // Custom formatter class
    static class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getMessage() + System.lineSeparator();
        }
    }
}