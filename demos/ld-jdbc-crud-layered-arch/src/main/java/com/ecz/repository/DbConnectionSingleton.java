package com.ecz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionSingleton {
    //Create the Connection singleton
    private static Connection connection;
//    Why is the constructor private?
//    The constructor is private to prevent the creation of multiple instances of the class.
    private DbConnectionSingleton() {
    }
    public static Connection getInstance() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ladb", "root", "mysql");
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}
