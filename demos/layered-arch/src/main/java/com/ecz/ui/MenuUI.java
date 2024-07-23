package com.ecz.ui;

import com.ecz.model.Product;
import com.ecz.service.ProductService;

public class MenuUI {
    ProductService productService = new ProductService();
//    What is UI?
//    UI stands for User Interface. It is the part of the application that the user interacts with
    void accessMenu() {
        System.out.println("Welcome to ECommerce App!");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Exit");
    }
    void addProduct() {
//        System.out.println("Enter Product ID: ");
//        System.out.println("Enter Product Name: ");
//        System.out.println("Enter Product Price: ");
        Product product =  new Product("100", "Laptop", 999.99, 1);
        boolean  isAdded = productService.addProduct(product);
        if (isAdded) {
            System.out.println("Product added successfully");
        } else {
            System.out.println("Product not added");
        }
    }
}
