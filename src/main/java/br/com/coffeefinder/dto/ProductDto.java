package br.com.coffeefinder.dto;

import java.math.BigDecimal;
import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.entity.Product;

/** Represents a product data transfer object. */
public record ProductDto(Long id, String name, String description, BigDecimal price, Long merchantId) {
	/**
	 * Creates a new Product instance from a DTO.
	 *
	 * @return the Product instance
	 */
	public Product toEntity() {
		return new Product(
					id,
					name,
					description,
					price,
					new Merchant(merchantId)
		);
	}

	public ProductDto toDto() {
		return new ProductDto(
					this.id,
					this.name,
					this.description,
					this.price,
					this.merchantId
		);
	}

}
