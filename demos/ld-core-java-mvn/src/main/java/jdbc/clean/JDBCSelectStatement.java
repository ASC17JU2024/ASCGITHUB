package jdbc.clean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCSelectStatement {
    private static  String loggerName =   JDBCSelectStatement.class.getName();
    private static final Logger LOGGER = Logger.getLogger(loggerName);

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mysql");
            LOGGER.info("Connection established!");

            statement = connection.createStatement();
            LOGGER.info("Statement created");

            resultSet = statement.executeQuery("SELECT user_id, email, last_name FROM user ORDER BY user_id");
            LOGGER.info("Result set returned");

            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String userIdString = String.format("User ID: %d" , userId);
                LOGGER.log( Level.INFO, userIdString);
                LOGGER.info("Email: " + resultSet.getString("email"));
                LOGGER.info("Last Name: " + resultSet.getString("last_name"));
                LOGGER.info("********");
            }
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "JDBC Driver not found", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL Exception occurred", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Failed to close ResultSet", e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Failed to close Statement", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Failed to close Connection", e);
                }
            }
        }
    }
}