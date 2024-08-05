package dom.service;

import java.util.List;

import dom.model.Product;
import dom.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
// The dependency is taken care by spring.
	private ProductRepository productRepository;
	private String location;
	private String domainName;

	public ProductServiceImpl() {
	super();
	System.out.println(" ProductServiceImpl() ");
}

// Spring injects the dependency through constructor base DI
public ProductServiceImpl(ProductRepository productRepository) {
	super();
	this.productRepository = productRepository;
}


	@Override
	public List<Product> findAll() {

		return this.productRepository.findAll();
	}

	@Override
	public String getDomainName() {
		return domainName;
	}

// using a property from the properties file.
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

// setter based di
	public void setProductRepository(ProductRepository productRepository) {
		System.out.println("setProductRepository(ProductRepository productRepository)");
			this.productRepository = productRepository;
		}

	public String getLocation() {
		return location;
	}
	// using a literal from the xml config file.
	public void setLocation(String location) {
		this.location = location;
	}

}
