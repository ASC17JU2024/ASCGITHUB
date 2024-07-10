package com.ecz.model;

import com.ecz.exceptions.InvalidProductException;

public class GSJunitProduct {
    // Declare Product class with three fields: id, name, and price
    private String id;
    private String name;
    private double price;

    public  GSJunitProduct() {
            throw new UnsupportedOperationException();
    }

    public  GSJunitProduct(String id, String name, double price) {
        if(price <= 0) {
           throw new InvalidProductException("Price must be greater than 0");
        }
        this.id = id;
        this.name = name;
        this.price = price;

    }
}
