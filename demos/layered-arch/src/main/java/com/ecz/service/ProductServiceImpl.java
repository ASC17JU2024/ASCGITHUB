package com.ecz.service;

import com.ecz.model.Product;
import com.ecz.repository.ProductRepository;
import com.ecz.repository.ProductRepositoryCollectionImpl;

public class ProductServiceImpl {

    //What is a service?
    //A service is a class that provides business logic to the application.
    ProductRepository productRepository = new ProductRepositoryCollectionImpl();
    public boolean addProduct(Product product) {
        boolean isAdded = false;
        if (product.getPrice() < 0) {
            System.out.println("Price cannot be negative");
        } else {
//           isAdded =  productRepository.addProductToCollectionCart(product);
            isAdded =  productRepository.addProductToCart(product);
        }
        return isAdded;
    }
}

