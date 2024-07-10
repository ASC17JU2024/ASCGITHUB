package com.ecz;

import com.ecz.model.Cart;
import com.ecz.model.Product;
public class App 
{
    public static void main( String[] args )
    {
       Cart cart = new Cart();
         Product product1 = new Product("1", "Laptop", 999.99);
         cart.addProduct(product1);
         cart.addProduct(new Product("2", "Smartphone", 499.99));
            System.out.println("Total price: " + cart.getTotalPrice());
    }
}
