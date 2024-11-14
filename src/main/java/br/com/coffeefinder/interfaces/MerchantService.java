package br.com.coffeefinder.interfaces;

import java.util.List;
import br.com.coffeefinder.entity.Merchant;

public interface MerchantService {
	List<Merchant> getAllMerchants();

	Merchant getMerchantById(Long id);

	Merchant createMerchant(Merchant merchant);

	Merchant updateMerchant(Merchant merchant);

	void deleteMerchant(Long id);
}
