package com.ecz.service;

import com.ecz.model.Product;
import com.ecz.repository.ProductRepository;
import com.ecz.repository.ProductRepositoryDbImpl;

import java.util.Collections;
import java.util.List;

public class ProductServiceAIImpl implements ProductService{

    //What is a service?
    //A service is a class that provides business logic to the application.
    ProductRepository productRepository = new ProductRepositoryDbImpl();
    public boolean addProduct(Product product) {
        boolean isAdded = validateProductPriceAI(product);
        return isAdded;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }


    public boolean validateProductPriceAI(Product product) {
        System.out.println("AI validation for product price");
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

