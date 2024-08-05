package dom.ui;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dom.configuration.AppConfig;
import dom.model.Product;
import dom.repository.ProductRepository;
import dom.repository.ProductRepositoryImpl;


public class App {
	public static void main(String[] args) {
		System.out.println("Starter Enterprise App Setup");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductRepository productRepository = (ProductRepository) applicationContext.getBean("productRepository");
		productRepository.findAll().forEach(System.out::println);
		((AnnotationConfigApplicationContext)applicationContext).close();
// What is ApplicationContext?
//		ApplicationContext is a container that contains all the beans, and it is responsible for instantiating, configuring, and assembling the beans.
	}

	private static void tradionalWay() {
		ProductRepository productRepository = new ProductRepositoryImpl();
		List<Product> products = productRepository.findAll();
//		System.out.println(products);
// oldest method
//		for (int i = 0; i < products.size(); i++) {
//			System.out.println(products.get(i));
//		}
//		enhanced for loop
		/*
		 * for (Product product : products) { System.out.println(product); }
		 */
// java 8 way with lambda
//		products.forEach((product) -> System.out.println(product));
		// java 8 way with method references
		products.forEach(System.out::println);
	}
}