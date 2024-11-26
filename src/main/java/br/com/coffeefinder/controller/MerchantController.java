package br.com.coffeefinder.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.exception.MerchantNotFoundException;
import br.com.coffeefinder.service.MerchantServiceImpl;
import br.com.coffeefinder.service.interfaces.MerchantService;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

	private MerchantService merchantService;

	public MerchantController(MerchantServiceImpl merchantService) {
		this.merchantService = merchantService;
	}

	@GetMapping
	public List<Merchant> getAllMerchants() {
		return merchantService.getAllMerchants();
	}

	@GetMapping("/{id}")
	public Merchant getMerchantById(@PathVariable Long id) throws MerchantNotFoundException {
		return merchantService.getMerchantById(id);
	}

	@PostMapping
	public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant) {
		Merchant createdMerchant = merchantService.createMerchant(merchant);
		return ResponseEntity.status(201).body(createdMerchant);
	}

	@PutMapping("/{id}")
	public Merchant updateMerchant(@PathVariable Long id, @RequestBody Merchant merchant) throws MerchantNotFoundException {
		merchant.setId(id);
		return merchantService.updateMerchant(merchant);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMerchant(@PathVariable Long id) {
		merchantService.deleteMerchant(id);
		return ResponseEntity.noContent().build();
	}
}
