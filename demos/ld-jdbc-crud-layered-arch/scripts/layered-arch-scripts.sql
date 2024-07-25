-- Generate Database name ladb
CREATE DATABASE ladb;

-- Use Database ladb
USE ladb;

-- Generate MySQL table
CREATE TABLE product (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE,
    quantity INT
);

-- Insert a record into MySQL table
INSERT INTO product (id, name, price, quantity) VALUES ('1', 'Laptop', 999.99, 1);


-- Select all records from MySQL table
SELECT * FROM product ;


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
