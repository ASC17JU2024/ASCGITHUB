package dom.ui;

import dom.model.Product;
import dom.repository.ProductRepository;
import dom.repository.ProductRepositoryImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
//        ProductRepository productRepository = new ProductRepositoryImpl();
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object object = context.getBean("productRepository");
//        ProductRepository productRepository = (ProductRepository) object;

//        ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");

        ProductRepository productRepository = classPathXmlApplicationContext.getBean("productRepository", ProductRepository.class);

        List<Product> productList = productRepository.findAll();
//        for(int i = 0; i<productList.size(); i++){
//            System.out.println(productList.get(i));
//        }
//        for (Product product : productList) {
//            System.out.println(product);
//        }
        // java 8 forEach and method-reference operator
        // java 8 provides concise-syntax
        productList.forEach(System.out::println);
        classPathXmlApplicationContext.close();
    }
}
