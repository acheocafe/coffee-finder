package br.com.coffeefinder.dto;

public record MerchantDto(
	Long id, String name, String phoneNumber, String email, String website, LocationDto location) {
	public MerchantDto {
		// Validation logic or other processing can be added here if needed
	}
}
