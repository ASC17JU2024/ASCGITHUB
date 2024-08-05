package dom.ui;

import java.util.List;

import dom.model.Product;
import dom.repository.ProductRepository;
import dom.repository.ProductRepositoryImpl;

public class App {
	public static void main(String[] args) {
		System.out.println("Starter Enterprise App Setup");
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