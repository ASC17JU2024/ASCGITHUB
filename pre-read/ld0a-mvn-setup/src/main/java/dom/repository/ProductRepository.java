package dom.repository;

import java.util.List;

import dom.model.Product;

// Write to interface (Interface Driven Development)
public interface ProductRepository {
	public List<Product> findAll();
}
