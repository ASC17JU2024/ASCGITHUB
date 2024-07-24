package com.ecz.repository;

import com.ecz.model.Product;

public interface ProductRepository {
    boolean addProductToCart(Product product);
}