package com.ecz.repository;

import com.ecz.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductRepositoryDbImpl implements  ProductRepository {
    //What is a repository?
    //A repository is a class that provides CRUD operations on the model.

    public boolean addProductToCart(Product product) {
        // Load the driver class
        try {
            Connection connection = getConnection();
            System.out.println("Driver Loaded!");
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
            // INSERT INTO product (id, name, price, quantity) VALUES ('1', 'Laptop', 999.99, 1);

            String insertQuery = "INSERT INTO product (id, name, price, quantity) VALUES ('" + product.getId()
                    + "', '" + product.getName() + "'," + product.getPrice() + "," + product.getQuantity() + ");";
            int noOfRowsAffected = statement.executeUpdate(insertQuery);
            System.out.println("No of rows affected: " + noOfRowsAffected);
            return noOfRowsAffected > 0;
        }

        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return false;
    }


    private static Connection getConnection()   {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ladb", "root", "mysql");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    // method to return all the products from the database as a list
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = getConnection();
//            Connection connection = DbConnectionSingleton.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                Product product = new Product(id, name, price, quantity);
                products.add(product);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return products;
    }


}



