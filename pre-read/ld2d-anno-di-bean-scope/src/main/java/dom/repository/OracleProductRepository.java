package dom.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dom.model.Product;

// POJO which is used by the Spring Framework for creating beans.
// Interface Driven Development
@Component("oracleProductRepository")
public class OracleProductRepository implements ProductRepository {
	public List<Product> findAll() {
//		A STUB FOR PRODUCTS
		List<Product> products = new ArrayList<>();
		products.add(new Product("P03", "Man's Search For Meaning", 300));
		products.add(new Product("P04", "Awaken the Giant Within", 500));
		return products;
	}

}
