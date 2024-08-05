package dom.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dom.repository.ProductRepository;
import dom.service.ProductService;

public class App {
	public static void main(String[] args) {
		beanScope();
	}

	private static void beanScope() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		The traditional way
//		ProductRepository productRepository = (ProductRepository) applicationContext.getBean("productRepository");
//		The spring way
		ProductRepository productRepository = applicationContext.getBean("productRepository", ProductRepository.class);
//		productRepository.findAll().forEach(System.out::println);
		System.out.println(productRepository);
		
		 productRepository = applicationContext.getBean("productRepository", ProductRepository.class);
//			productRepository.findAll().forEach(System.out::println);
			System.out.println(productRepository);
		applicationContext.close();
	}

	private static void setterBasedDI() {
		// performIOC();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// The traditional way
		// ProductRepository productRepository = (ProductRepository)
		// applicationContext.getBean("productRepository");
		// The spring way
		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		productService.findAll().forEach(System.out::println);
//				fetching string literals from the xml config file.
		System.out.println(productService.getLocation());
//				fetching values from the properties file
		System.out.println(productService.getDomainName());
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

	private static void performIOC() {
		System.out.println("Starter Enterprise App Setup");
//		tradionalWay();
		/*
		 * Central interface to provide configuration for an application. This is
		 * read-only while the application is running ApplicationContext
		 */
		/*
		 * ApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); ProductRepository
		 * productRepository = (ProductRepository)
		 * applicationContext.getBean("productRepository");
		 * productRepository.findAll().forEach(System.out::println);
		 * ((ClassPathXmlApplicationContext) applicationContext).close();
		 */

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		The traditional way
//		ProductRepository productRepository = (ProductRepository) applicationContext.getBean("productRepository");
//		The spring way
		ProductRepository productRepository = applicationContext.getBean("productRepository", ProductRepository.class);
		productRepository.findAll().forEach(System.out::println);
		applicationContext.close();
	}

	private static void tradionalWay() {
//		ProductRepository productRepository = new ProductRepositoryImpl();
//		List<Product> products = productRepository.findAll();
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
//		products.forEach(System.out::println);
	}
}