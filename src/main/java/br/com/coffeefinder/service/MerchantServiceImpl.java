package br.com.coffeefinder.service;

import br.com.coffeefinder.dto.MerchantDto;
import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.interfaces.MerchantService;
import br.com.coffeefinder.repository.MerchantRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

	private final MerchantRepository merchantRepository;

	public MerchantServiceImpl(MerchantRepository merchantRepository) {
		this.merchantRepository = merchantRepository;
	}

	@Override
	public List<MerchantDto> getAllMerchants() {
		return merchantRepository.findAllDtoeBy();
	}

	@Override
	public Merchant getMerchantById(Long id) {
		return merchantRepository.findById(id).orElse(null);
	}

	@Override
	public Merchant createMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	@Override
	public Merchant updateMerchant(Merchant merchant) {
		Merchant existingMerchant = getMerchantById(merchant.getId());
		if (existingMerchant != null) {
			existingMerchant.setName(merchant.getName());
			return merchantRepository.save(existingMerchant);
		}
		return null;
	}

	@Override
	public void deleteMerchant(Long id) {
		merchantRepository.deleteById(id);
	}
}
