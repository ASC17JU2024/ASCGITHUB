package dom.repository;

import java.util.ArrayList;
import java.util.List;

import dom.model.Product;

// POJO which is used by the Spring Framework for creating beans.
// Interface Driven Development
public class ProductRepositoryImpl implements ProductRepository {
	
	public ProductRepositoryImpl() {
		System.out.println("ProductRepositoryImpl()");
	}
	public void init() {
		System.out.println("bean initialization");
	}
	public void destroy() {
		System.out.println("bean clean up operations");
	}
	
	public void initBean() {
		System.out.println("bean initialization 1");
	}
	public void destroyBean() {
		System.out.println("bean clean up operations 1");
	}
	public List<Product> findAll() {
//		A STUB FOR PRODUCTS
		List<Product> products = new ArrayList<>();
		products.add(new Product("P01", "Man's Search For Meaning", 300));
		products.add(new Product("P02", "Awaken the Giant Within", 500));
		return products;
	}

}
