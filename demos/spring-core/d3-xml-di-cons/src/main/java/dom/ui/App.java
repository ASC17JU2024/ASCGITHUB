package dom.ui;

import dom.model.Product;
import dom.repository.ProductRepository;
import dom.repository.ProductRepositoryImpl;
import dom.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // What are types of ApplicationContexts?
        // 1. ClassPathXmlApplicationContext
        // 2. FileSystemXmlApplicationContext
        // 3. AnnotationConfigApplicationContext
        // 4. WebApplicationContext
    
//        ProductRepository productRepository = new ProductRepositoryImpl();
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
ProductService productService = classPathXmlApplicationContext.getBean("productService", ProductService.class);
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
        ((ClassPathXmlApplicationContext)classPathXmlApplicationContext).close();
    }
}
