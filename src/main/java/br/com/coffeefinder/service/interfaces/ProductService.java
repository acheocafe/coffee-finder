package br.com.coffeefinder.service.interfaces;

import java.util.List;

/**
 * ProductService
 */
import br.com.coffeefinder.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product createProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Long id);
}
