package com.ecz.repository;

import com.ecz.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    //What is a repository?
    //A repository is a class that provides CRUD operations on the model.
    Map<String, Product> cart = new HashMap<String,Product>();
    private boolean addProductToCollectionCart(Product product) {
        cart.put(product.getId(), product);
//        System.out.println("Product added to cart " );
        System.out.println("Updated cart is " + cart);
        return true;
    }

    public boolean addProducttoCart(Product product) {

//        return addProductToCollectionCart(product);
        return addProducttoDBCart(product);
    }
    private  boolean addProducttoDBCart(Product product) {

        // Load the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ladb", "root", "mysql");
            System.out.println("Driver Loaded!");
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
            // INSERT INTO product (id, name, price, quantity) VALUES ('1', 'Laptop', 999.99, 1);

            String insertQuery = "INSERT INTO product (id, name, price, quantity) VALUES ('" + product.getId() 
            + "', '" + product.getName() + "'," + product.getPrice()+ "," + product.getQuantity() + ");";
            int noOfRowsAffected = statement.executeUpdate(insertQuery);
            System.out.println("No of rows affected: " + noOfRowsAffected);
            return noOfRowsAffected>0;
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
