
package br.com.coffeefinder.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import br.com.coffeefinder.entity.Location;
import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.repository.MerchantRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MerchantServiceImplTest {

    @Mock
    private MerchantRepository merchantRepository;

    @InjectMocks
    private MerchantServiceImpl merchantService;

    private Merchant merchant;

    @BeforeEach
    void setup() {
   Location location = new Location(1L,
            "Rua Visconde do Rio Branco, 123",
            "Municipio de São Joaquim da Barra",
            "SP",
            "14600-000",
            "Brazil"
        );

        merchant = new Merchant(
            1L,
            "Tocaya Café",
            "55 16 99111-1111",
            "contato@tocaya.com.br",
            "https://tocaya.com.br",
            location
        );
    }


    @Test
    void testGetAllMerchants() {
        // Arrange
        when(merchantRepository.findAll()).thenReturn(List.of(merchant));

        // Act
        var result = merchantService.getAllMerchants();

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(merchant);
    }

    @Test
    void testGetMerchantById() {
        // Arrange
        when(merchantRepository.findById(any())).thenReturn(Optional.of(merchant));

        // Act
        var result = merchantService.getMerchantById(1L);

        // Assert
        assertThat(result).isEqualTo(merchant);
    }

    @Test
    void testCreateMerchant() {
        // Arrange
        when(merchantRepository.save(any())).thenReturn(merchant);

        // Act
        var result = merchantService.createMerchant(merchant);

        // Assert
        assertThat(result).isEqualTo(merchant);
    }

    @Test
    void testUpdateMerchant() {
        // Arrange
        when(merchantRepository.findById(any())).thenReturn(Optional.of(merchant));
        when(merchantRepository.save(any())).thenReturn(merchant);

        // Act
        var result = merchantService.updateMerchant(merchant);

        // Assert
        assertThat(result).isEqualTo(merchant);
    }

    @Test
    void testUpdateMerchantNotFound() {
        // Arrange
        when(merchantRepository.findById(any())).thenReturn(Optional.empty());

        // Act
        var result = merchantService.updateMerchant(merchant);

        // Assert
        assertThat(result).isNull();
    }

    @Test
    void testDeleteMerchant() {
        // Act
        merchantService.deleteMerchant(1L);

        // Assert
        verify(merchantRepository, times(1)).deleteById(1L);
    }
}
