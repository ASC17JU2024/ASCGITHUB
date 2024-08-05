package dom.service;

import java.util.List;

import dom.model.Product;
import dom.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
// The dependency is taken care by spring.
	private ProductRepository productRepository;

// Spring injects the dependency through constructor base DI
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {

		return this.productRepository.findAll();
	}

}
