package br.com.coffeefinder.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.math.BigDecimal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import br.com.coffeefinder.dto.ProductDto;
import br.com.coffeefinder.entity.Product;


class ProductControllerTest extends ControllerConfig
{

	private static final String ApiUrl = "/api/products";

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testGetAllProducts() throws Exception {
		mockMvc.perform(get(ApiUrl)).andExpect(status().isOk());
	}

	@Test
	void testGetProductById() throws Exception {
		mockMvc.perform(get(ApiUrl + "/1")).andExpect(status().isOk())
					.andExpect(jsonPath("$.id").value(1))
					.andExpect(jsonPath("$.name").value("Café especial da Cachoeirinha"));
	}

	@Test
	void testGetProductByIdNotFound() throws Exception {
		mockMvc.perform(get(ApiUrl + "/100")).andExpect(status().isNotFound());
	}

	@Test
	void testCreateProduct() throws Exception {
		Product product =
					new ProductDto( null, "Product1", "Description", BigDecimal.TEN, null).toEntity();
		mockMvc.perform(post(ApiUrl).contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(product))).andExpect(status().isCreated());
	}

	@Test
	void testUpdateProduct() throws Exception {
		Product product =
					new ProductDto(1L, "Product1", "Description", BigDecimal.TEN, null).toEntity();
		mockMvc.perform(put(ApiUrl + "/1").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(product))).andExpect(status().isOk());
	}

	@Test
	void testUpdateProductNotFound() throws Exception {
		Product product =
					new ProductDto(1L, "Product1", "Description", BigDecimal.TEN, null).toEntity();
		mockMvc.perform(put(ApiUrl + "/100").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(product)))
					.andExpect(status().isNotFound());
	}

	@Test
	void testDeleteProduct() throws Exception {
		mockMvc.perform(delete(ApiUrl + "/1")).andExpect(status().isNoContent());
	}
}


//where and which .sql files should i use to initialize the database for testing?
//

