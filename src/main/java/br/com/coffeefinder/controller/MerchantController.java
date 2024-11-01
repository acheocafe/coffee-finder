package br.com.coffeefinder.controller;

import br.com.coffeefinder.dto.MerchantDto;
import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.interfaces.MerchantService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

	private MerchantService merchantService;

	public MerchantController(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@GetMapping
	public List<MerchantDto> getAllMerchants() {
		return merchantService.getAllMerchants();
	}

	@GetMapping("/{id}")
	public Merchant getMerchantById(@PathVariable Long id) {
		return merchantService.getMerchantById(id);
	}

	@PostMapping
	public Merchant createMerchant(@RequestBody Merchant merchant) {
		return merchantService.createMerchant(merchant);
	}

	@PutMapping("/{id}")
	public Merchant updateMerchant(@PathVariable Long id, @RequestBody Merchant merchant) {
		merchant.setId(id);
		return merchantService.updateMerchant(merchant);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMerchant(@PathVariable Long id) {
		merchantService.deleteMerchant(id);
		return ResponseEntity.noContent().build();
	}
}
