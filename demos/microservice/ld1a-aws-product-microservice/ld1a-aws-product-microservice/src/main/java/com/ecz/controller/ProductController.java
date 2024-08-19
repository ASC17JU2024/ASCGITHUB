package com.ecz.controller;

import com.ecz.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> productList = new ArrayList<>();

    public ProductController() {
        // Initialize with some sample data
        productList.add(new Product("1", "Laptop", 1200.00, 10));
        productList.add(new Product("2", "Smartphone", 800.00, 20));
    }

@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productList;
    }
}