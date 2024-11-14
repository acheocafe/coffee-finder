package br.com.coffeefinder.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.interfaces.MerchantService;
import br.com.coffeefinder.repository.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

	private final MerchantRepository merchantRepository;


	public MerchantServiceImpl(MerchantRepository merchantRepository) {
		this.merchantRepository = merchantRepository;
	}



	@Override
	public List<Merchant> getAllMerchants() {
		return merchantRepository.findAll();

	}

	@Override
	public Merchant getMerchantById(Long id) {
		// return merchantRepository.findByIdDTOeBy(id);
		return null;
	}

	@Override
	public Merchant createMerchant(Merchant merchant) {
		// return merchantRepository.
		return null;
	}

	@Override
	public Merchant updateMerchant(Merchant merchant) {
		// Merchant existingMerchant = getMerchantById(merchant.getId());
		// if (existingMerchant != null) {
			// existingMerchant.setName(merchant.getName());
			// return merchantRepository.save(existingMerchant);
			// return new Merchant();
		// }
		return null;
	}

	@Override
	public void deleteMerchant(Long id) {
		// merchantRepository.deleteById(id);
	}

	public MerchantRepository getMerchantRepository() {
		return merchantRepository;
	}
}
