package br.com.coffeefinder.interfaces;

import br.com.coffeefinder.dto.MerchantDto;
import br.com.coffeefinder.entity.Merchant;
import java.util.List;

public interface MerchantService {
	List<MerchantDto> getAllMerchants();

	Merchant getMerchantById(Long id);

	Merchant createMerchant(Merchant merchant);

	Merchant updateMerchant(Merchant merchant);

	void deleteMerchant(Long id);
}
