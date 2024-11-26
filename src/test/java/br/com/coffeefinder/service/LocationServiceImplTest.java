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
import br.com.coffeefinder.exception.ResourceNotFoundException;
import br.com.coffeefinder.repository.LocationRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationServiceImpl locationService;

    private Location location;

    @BeforeEach
    void setup() {
        location = new Location(1L,
                "Rua Visconde do Rio Branco, 123",
                "Municipio de São Joaquim da Barra",
                "SP",
                "14600-000",
                "Brazil"
        );
    }

    @Test
    void testGetAllLocations() {
        // Arrange
        when(locationRepository.findAll()).thenReturn(List.of(location));

        // Act
        var result = locationService.getAllLocations();

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(location);
    }

    @Test
    void testGetLocationById() throws ResourceNotFoundException {
        // Arrange
        when(locationRepository.findById(any())).thenReturn(Optional.of(location));

        // Act
        var result = locationService.getLocationById(1L);

        // Assert
        assertThat(result).isEqualTo(location);
    }

    @Test
    void testCreateLocation() {
        // Arrange
        when(locationRepository.save(any())).thenReturn(location);

        // Act
        var result = locationService.createLocation(location);

        // Assert
        assertThat(result).isEqualTo(location);
    }

    @Test
    void testUpdateLocation() throws ResourceNotFoundException {
        // Arrange
        when(locationRepository.findById(any())).thenReturn(Optional.of(location));
        when(locationRepository.save(any())).thenReturn(location);

        // Act
        var result = locationService.updateLocation(location);

        // Assert
        assertThat(result).isEqualTo(location);
    }

    @Test
    void testUpdateLocationNotFound() {
        // Arrange
        when(locationRepository.findById(any())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> locationService.updateLocation(location));
    }

    @Test
    void testDeleteLocation() {
        // Act
        locationService.deleteLocation(1L);

        // Assert
        verify(locationRepository, times(1)).deleteById(1L);
    }
}
