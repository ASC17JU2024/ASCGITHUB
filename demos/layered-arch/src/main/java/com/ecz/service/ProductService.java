package com.ecz.service;

import com.ecz.model.Product;
import com.ecz.repository.ProductRepository;

public class ProductService {

    //What is a service?
    //A service is a class that provides business logic to the application.
    ProductRepository productRepository = new ProductRepository();
    public boolean addProduct(Product product) {
        boolean isAdded = false;
        if (product.getPrice() < 0) {
            System.out.println("Price cannot be negative");
        } else {
//           isAdded =  productRepository.addProductToCollectionCart(product);
            isAdded =  productRepository.addProducttoCart(product);
        }
        return isAdded;
    }
}

