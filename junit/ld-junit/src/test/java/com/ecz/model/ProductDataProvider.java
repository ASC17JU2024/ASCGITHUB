package com.ecz.model;

import java.util.stream.Stream;

public class ProductDataProvider {
    public static Stream<Product> productProvider() {
        return Stream.of(
            new Product("1", "Laptop", 999.99),
            new Product("2", "Smartphone", 499.99),
            new Product("3", "Tablet", 299.99)
        );
    }
}