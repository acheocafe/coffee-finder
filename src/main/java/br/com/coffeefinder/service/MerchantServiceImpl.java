package br.com.coffeefinder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.coffeefinder.entity.Merchant;
import br.com.coffeefinder.exception.MerchantNotFoundException;
import br.com.coffeefinder.repository.MerchantRepository;
import br.com.coffeefinder.service.interfaces.MerchantService;

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
	public Merchant getMerchantById(Long id) throws MerchantNotFoundException{
		return merchantRepository.findById(id)
					.orElseThrow(() -> new MerchantNotFoundException(id));
	}

	@Override
	public Merchant createMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	@Override
	public Merchant updateMerchant(Merchant merchant) throws MerchantNotFoundException{
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

	public MerchantRepository getMerchantRepository() {
		return merchantRepository;
	}
}
