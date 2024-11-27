//generate a java record MerchantDto like Product dto with methods to entity and ToDto but add A list of ProductDto field
package br.com.coffeefinder.dto;

import java.util.List;

import br.com.coffeefinder.entity.Location;
import br.com.coffeefinder.entity.Merchant;

/**
 * Represents a merchant data transfer object.
 */
public record MerchantDto(
    Long id,
    String name,
    String phoneNumber,
    String email,
    String website,
    Long locationId,
    List<ProductDto> products
) {
    /**
     * Creates a new Merchant instance from a DTO.
     *
     * @return the Merchant instance
     */
    public Merchant toEntity() {
        return new Merchant(
            id,
            name,
            phoneNumber,
            email,
            website,
            new Location(locationId)
        );
    }

    /**
     * Creates a new MerchantDto instance from a Merchant entity.
     *
     * @param merchant the Merchant entity
     * @param products the list of ProductDto instances
     * @return the MerchantDto instance
     */
    public static MerchantDto toDto(Merchant merchant, List<ProductDto> products) {
        return new MerchantDto(
            merchant.getId(),
            merchant.getName(),
            merchant.getPhoneNumber(),
            merchant.getEmail(),
            merchant.getWebsite(),
            merchant.getLocation() == null ? null : merchant.getLocation().getId(),
            products
        );
    }
}
