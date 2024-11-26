package br.com.coffeefinder.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.coffeefinder.entity.Product;
/**
 * ProductServiceImpl
 */
import br.com.coffeefinder.repository.ProductRepository;
import br.com.coffeefinder.service.interfaces.ProductService;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = getProductById(product.getId());
		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setPrice(product.getPrice());
			return productRepository.save(existingProduct);
		}
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
