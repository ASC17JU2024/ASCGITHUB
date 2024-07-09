package com.ecz.model;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private double price;

    // Constructors, getters, setters
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Product product = (Product) obj;
    return Double.compare(product.price, price) == 0 &&
           Objects.equals(id, product.id) &&
           Objects.equals(name, product.name);
}

@Override
public int hashCode() {
    return Objects.hash(id, name, price);
}
}
