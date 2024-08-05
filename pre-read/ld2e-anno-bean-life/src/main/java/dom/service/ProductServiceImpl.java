package dom.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// import javax.annotation.PostConstruct
// import javax.annotation.PreDestroy
import dom.model.Product;
import dom.repository.ProductRepository;

//ProductService productService = new ProductServiceImpl(productRepository);
@Component("productService")
@Scope("singleton")
//@Scope("prototype")
public class ProductServiceImpl implements ProductService {
// The dependency is taken care by spring.
	
// FIELD BASED DI
//	@Autowired

//	@Qualifier("mySQLProductRepository")
	@Qualifier("oracleProductRepository")
	private ProductRepository productRepository;

	@PostConstruct
	public void init() {
		System.out.println("BEAN INIT");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("BEAN CLEANUP");
	}
	
// Spring injects the dependency through constructor base DI
//	@Autowired
//	public ProductServiceImpl(ProductRepository productRepository) {
//		System.out.println("CONS BASED DI public ProductServiceImpl(ProductRepository productRepository);");
//		this.productRepository = productRepository;
//	}

//	public ProductServiceImpl() {
//		System.out.println("Default Constructor !!!");
//	}

	@Override
	public List<Product> findAll() {

		return this.productRepository.findAll();
	}
	// Spring injects the dependency through setter based DI
//	@Autowired
//	public void setProductRepository(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//		System.out.println("SETTER BASED DI : public void setProductRepository(ProductRepository productRepository)");
//	}
}
