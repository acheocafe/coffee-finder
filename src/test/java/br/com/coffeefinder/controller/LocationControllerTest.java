package br.com.coffeefinder.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import br.com.coffeefinder.entity.Location;
import br.com.coffeefinder.exception.ResourceNotFoundException;
import br.com.coffeefinder.service.LocationServiceImpl;

public class LocationControllerTest extends ControllerConfig {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationServiceImpl locationService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() throws ResourceNotFoundException {
        Location location = new Location(
                1L,
                "Rua Visconde do Rio Branco, 123",
                "Municipio de São Joaquim da Barra",
                "SP",
                "14600-000",
                "Brazil"
        );

        when(locationService.getAllLocations()).thenReturn(List.of(location));

        when(locationService.getLocationById(1L)).thenReturn(location);

        when(locationService.createLocation(any(Location.class)))
                .thenReturn(location);

        when(locationService.updateLocation(any(Location.class)))
                .thenReturn(location);
        Mockito.doNothing().when(locationService).deleteLocation(1L);
    }

    @Test
    public void testGetAllLocations() throws Exception {
        mockMvc.perform(get("/api/locations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetLocationById() throws Exception {
        mockMvc.perform(get("/api/locations/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateLocation() throws Exception {
        Location location = new Location(
                1L,
                "Rua Visconde do Rio Branco, 123",
                "Municipio de São Joaquim da Barra",
                "SP",
                "14600-000",
                "Brazil"
        );

        mockMvc.perform(post("/api/locations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(location)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testUpdateLocation() throws Exception {
        Location location = new Location(
                1L,
                "Rua Visconde do Rio Branco, 123",
                "Municipio de São Joaquim da Barra",
                "SP",
                "14600-000",
                "Brazil"
        );

        mockMvc.perform(put("/api/locations/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(location)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDeleteLocation() throws Exception {
        mockMvc.perform(delete("/api/locations/1"))
                .andExpect(status().isNoContent());
    }
}
