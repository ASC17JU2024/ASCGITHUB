package com.ecz.model;

public class GSJunitProduct {
    // Declare Product class with three fields: id, name, and price
    private String id;
    private String name;
    private double price;

    public  GSJunitProduct() {
            throw new UnsupportedOperationException();
    }

    public  GSJunitProduct(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
