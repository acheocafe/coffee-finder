package br.com.coffeefinder.service.interfaces;

import java.util.List;

import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.exception.MerchantNotFoundException;

public interface MerchantService {
	List<Merchant> getAllMerchants();

	Merchant getMerchantById(Long id) throws MerchantNotFoundException;

	Merchant createMerchant(Merchant merchant);

	Merchant updateMerchant(Merchant merchant) throws MerchantNotFoundException;

	void deleteMerchant(Long id);
}
