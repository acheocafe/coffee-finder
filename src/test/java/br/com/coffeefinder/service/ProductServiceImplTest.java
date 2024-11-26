package br.com.coffeefinder.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.coffeefinder.dto.ProductDto;
import br.com.coffeefinder.entity.Product;
import br.com.coffeefinder.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;

	@Test
	public void testGetAllProducts() {
		// Arrange
		List<Product> products = List.of(new ProductDto(1L, "Café especial da Cachoeirinha",
					"Grão de café torrado no lenheiro, 100% arábica", null, null).toEntity(),
					new ProductDto(2L, "Café com notas de frutas",
								"Grão de café com notas de frutas vermelhas e florais", null, null).toEntity());
		when(productRepository.findAll()).thenReturn(products);

		// Act
		List<Product> result = productService.getAllProducts();

		// Assert
		assertThat(result).isNotNull().hasSize(2);
		verify(productRepository, times(1)).findAll();
	}

	@Test
	public void testGetProductById() {
		// Arrange
		Long id = 1L;
		Product product = new Product();
		when(productRepository.findById(id)).thenReturn(Optional.of(product));

		// Act
		Product result = productService.getProductById(id);

		// Assert
		assertThat(result).isNotNull();
		verify(productRepository, times(1)).findById(id);
	}

	@Test
	public void testGetProductByIdNotFound() {
		// Arrange
		Long id = 1L;
		when(productRepository.findById(id)).thenReturn(Optional.empty());

		// Act
		Product result = productService.getProductById(id);

		// Assert
		assertThat(result).isNull();
		verify(productRepository, times(1)).findById(id);
	}

	@Test
	public void testCreateProduct() {
		// Arrange
		Product product = new Product();
		when(productRepository.save(any(Product.class))).thenReturn(product);

		// Act
		Product result = productService.createProduct(product);

		// Assert
		assertThat(result).isNotNull();
		verify(productRepository, times(1)).save(any(Product.class));
	}

	@Test
	public void testUpdateProduct() {
		// Arrange
		Product product = new Product();
		product.setId(1L);
		when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
		when(productRepository.save(any(Product.class))).thenReturn(product);

		// Act
		Product result = productService.updateProduct(product);

		// Assert
		assertThat(result).isNotNull();
		verify(productRepository, times(1)).findById(product.getId());
		verify(productRepository, times(1)).save(any(Product.class));
	}

	@Test
	public void testUpdateProductNotFound() {
		// Arrange
		Product product = new Product();
		product.setId(1L);
		when(productRepository.findById(product.getId())).thenReturn(Optional.empty());

		// Act
		Product result = productService.updateProduct(product);

		// Assert
		assertThat(result).isNull();
		verify(productRepository, times(1)).findById(product.getId());
	}

	@Test
	public void testDeleteProduct() {
		// Act
		productService.deleteProduct(1L);

		// Assert
		verify(productRepository, times(1)).deleteById(1L);
	}
}
