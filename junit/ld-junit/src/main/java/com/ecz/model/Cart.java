package com.ecz.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if(product.getPrice()<0) {
            System.out.println("Dear sir/sirlu or madam/madamlu the price of the product is negative. Please enter a positive price.");
            return;
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException("Product not found in the cart.");
        }
        products.remove(product);
    }

    public double getTotalPrice() {
        //iterate through the products and sum up the prices
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getProductCount() {
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void clearCart() {
        products.clear(); // Clears the list of products
    }

    public double calculateTotalValue() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice(); // Sums up the price of each product
        }
        return total;
    }


}
