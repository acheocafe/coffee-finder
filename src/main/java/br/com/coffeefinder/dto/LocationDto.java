package br.com.coffeefinder.dto;

public record LocationDto(
	Long id, String address, String city, String state, String postalCode, String country) {
	public LocationDto {
		// Validation logic or other processing can be added here if needed
	}
}
