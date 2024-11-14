package br.com.coffeefinder.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/** Represents a product in the application. */
@Entity
@Table(name = "product")
public class Product {
	/** The unique identifier of the product. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The name of the product. */
	@Column(nullable = false)
	private String name;

	/** The description of the product. */
	private String description;

	/** The price of the product. */
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal price;

	/** The merchant associated with the product. */
	@ManyToOne
	@JoinColumn(name = "merchant_id")
	private Merchant merchant;

	/** Constructs an empty Product object. */
	public Product() {
	}

	public Product(Long id, String name, String description, BigDecimal price, Merchant merchant) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.merchant = merchant;
	}

	/**
	 Returns the product ID.

	 @return the product ID
	*/
	public Long getId() {
		return id;
	}

	/**
	 Sets the product ID.

	 @param productId the product ID to set
	*/
	public void setId(Long productId) {
		this.id = productId;
	}

	/**
	 Returns the name of the product.

	 @return the name of the product
	*/
	public String getName() {
		return name;
	}

	/**
	 Sets the name of the product.

	 @param name the name to set
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 Returns the description of the product.

	 @return the description of the product
	*/
	public String getDescription() {
		return description;
	}

	/**
	 Sets the description of the product.

	 @param description the description to set
	*/
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 Returns the price of the product.

	 @return the price of the product
	*/
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 Sets the price of the product.

	 @param price the price to set
	*/
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 Returns the merchant associated with the product.

	 @return the merchant associated with the product
	*/
	public Merchant getMerchant() {
		return merchant;
	}

	/**
	 Sets the merchant associated with the product.

	 @param merchant the merchant to set
	*/
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Product{"
				+ "productId="
				+ id
				+ ", name="
				+ name
				+ ", description="
				+ description
				+ ", price="
				+ price
				+ ", merchant="
				+ merchant
				+ '}';
	}
}
