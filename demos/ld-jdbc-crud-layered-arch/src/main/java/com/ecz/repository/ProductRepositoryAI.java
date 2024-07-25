package com.ecz.repository;

import com.ecz.model.Product;

import java.util.List;

public interface ProductRepositoryAI extends ProductRepository {
    boolean updateProduct(Product product);
}