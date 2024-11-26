package br.com.coffeefinder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * Represents a merchant entity in the database.
 *
 * @author Nathan Martins Cunha
 * @since 2024-10-23
 */
@Entity(name = "Merchant")
@Table(name = "merchant")
public class Merchant {

	/** Unique identifier for the merchant, automatically generated. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The name of the merchant, required and cannot be null. */
	@Column(nullable = false)
	private String name;

	/** The phone number of the merchant.**/

	private String phoneNumber;

	/** The email address of the merchant. */
	private String email;

	/** The website URL of the merchant. */
	private String website;

	public Merchant() {
	}

	public Merchant(
	Long id, String name, String phoneNumber, String email, String website, Location location) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.website = website;
		this.location = location;
	}

	public Merchant(Long merchantId) {
		this.id = merchantId;
	}

	/**
	 The location associated with the merchant.

	 @see Location
	*/
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
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
		Merchant other = (Merchant) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
