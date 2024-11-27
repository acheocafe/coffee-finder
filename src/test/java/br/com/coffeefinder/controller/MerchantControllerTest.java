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
import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.exception.EntityNotFoundException;
import br.com.coffeefinder.exception.MerchantNotFoundException;
import br.com.coffeefinder.service.MerchantServiceImpl;

public class MerchantControllerTest extends ControllerConfig {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MerchantServiceImpl merchantService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setup() throws EntityNotFoundException, MerchantNotFoundException {
		Merchant merchant = new Merchant(
					1L,
					"Tocaya Café",
					"55 16 99111-1111",
					"contato@tocaya.com.br",
					"https://tocaya.com.br",
					null
		);

		when(merchantService.getAllMerchants()).thenReturn(List.of(merchant));

		when(merchantService.getMerchantById(1L)).thenReturn(merchant);

		when(merchantService.createMerchant(any(Merchant.class)))
					.thenReturn((merchant));

		when(merchantService.updateMerchant(any(Merchant.class)))
					.thenReturn(merchant);
		Mockito.doNothing().when(merchantService).deleteMerchant(1L);
	}

	@Test
	public void testGetAllMerchants() throws Exception {
		mockMvc.perform(get("/api/merchants"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetMerchantById() throws Exception {
		mockMvc.perform(get("/api/merchants/1"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testCreateMerchant() throws Exception {
		Merchant merchant = new Merchant(
					1L,
					"Tocaya Café",
					"55 16 99111-1111",
					"contato@tocaya.com.br",
					"https://tocaya.com.br",
					null
		);

		mockMvc.perform(post("/api/merchants")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(merchant)))
					.andExpect(status().isCreated())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testUpdateMerchant() throws Exception {
		Merchant merchant = new Merchant(
					1L,
					"Toca Café",
					"55 16 99111-1111",
					"contato@tocaya.com.br",
					"https://tocaya.com.br",
					null
		);

		mockMvc.perform(put("/api/merchants/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(merchant)))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testDeleteMerchant() throws Exception {
		mockMvc.perform(delete("/api/merchants/1"))
					.andExpect(status().isNoContent());
	}

}
