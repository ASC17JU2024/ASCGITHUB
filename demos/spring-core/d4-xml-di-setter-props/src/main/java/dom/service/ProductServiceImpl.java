package dom.service;

import java.util.List;

import dom.model.Product;
import dom.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
// The dependency is taken care by spring.
	private ProductRepository productRepository;

	 public  ProductServiceImpl() {
		System.out.println("ProductServiceImpl() called");
	}
// Spring injects the dependency through constructor base DI
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

//  <property name="productRepository" ref="productRepository"/>
	public void setProductRepository(ProductRepository productRepository) {
		System.out.println("Setter method called setProductRepository(ProductRepository productRepository) ");
		this.productRepository = productRepository;
	}
}
