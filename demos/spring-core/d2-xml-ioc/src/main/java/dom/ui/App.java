package dom.ui;

import dom.model.Product;
import dom.repository.ProductRepository;
import dom.repository.ProductRepositoryImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepositoryImpl();
        List<Product> productList = productRepository.findAll();
        for(int i = 0; i<productList.size(); i++){
            System.out.println(productList.get(i));
        }
        for (Product product : productList) {
            System.out.println(product);
        }
        // java 8 forEach and method-reference operator
        // java 8 provides concise-syntax
        productList.forEach(System.out::println);
    }
}
