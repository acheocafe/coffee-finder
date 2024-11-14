package br.com.coffeefinder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a geographical location.
 *
 * @author Nathan Martins Cunha
 * @since 2024-10-23
 */
@Entity(name = "Location")
@Table(name = "location")
public class Location {

	/** Unique identifier for the location. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The address of the location. This field cannot be null. */
	@Column(nullable = false)
	private String address;

	/** The city where the location is situated. This field cannot be null. */
	@Column(nullable = false)
	private String city;

	/** The state where the location is situated. This field cannot be null. */
	@Column(nullable = false)
	private String state;

	/** The postal code of the location. */
	private String postalCode;

	/** The country where the location is situated. This field cannot be null. */
	@Column(nullable = false)
	private String country;

	/** Default constructor for creating a new Location instance. */
	public Location() {
	}

	public Location(
	Long id, String address, String city, String state, String postalCode, String country) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	/**
	 Returns the unique identifier of the location.

	 @return the location ID
	*/
	public Long getId() {
		return id;
	}

	/**
	 Sets the unique identifier of the location.

	 @param locationId the location ID to set
	*/
	public void setId(Long locationId) {
		this.id = locationId;
	}

	/**
	 Returns the address of the location.

	 @return the address
	*/
	public String getAddress() {
		return address;
	}

	/**
	 Sets the address of the location.

	 @param address the address to set
	*/
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 Returns the city where the location is situated.

	 @return the city
	*/
	public String getCity() {
		return city;
	}

	/**
	 Sets the city where the location is situated.

	 @param city the city to set
	*/
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 Returns the state where the location is situated.

	 @return the state
	*/
	public String getState() {
		return state;
	}

	/**
	 Sets the state where the location is situated.

	 @param state the state to set
	*/
	public void setState(String state) {
		this.state = state;
	}

	/**
	 Returns the postal code of the location.

	 @return the postal code
	*/
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 Sets the postal code of the location.

	 @param postalCode the postal code to set
	*/
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 Returns the country where the location is situated.

	 @return the country
	*/
	public String getCountry() {
		return country;
	}

	/**
	 Sets the country where the location is situated.

	 @param country the country to set
	*/
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [locationId="
				+ id
				+ ", address="
				+ address
				+ ", city="
				+ city
				+ ", state="
				+ state
				+ ", postalCode="
				+ postalCode
				+ ", country="
				+ country
				+ "]";
	}
}
