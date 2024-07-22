package com.ecz.repository;

import com.ecz.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    //What is a repository?
    //A repository is a class that provides CRUD operations on the model.
    Map<String, Product> cart = new HashMap<String,Product>();
    public boolean addProductToCart(Product product) {
        cart.put(product.getId(), product);
//        System.out.println("Product added to cart " );
        System.out.println("Updated cart is " + cart);
        return true;
    }
}
