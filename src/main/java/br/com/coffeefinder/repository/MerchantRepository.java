package br.com.coffeefinder.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import br.com.coffeefinder.entity.Merchant;

@Repository
public interface MerchantRepository extends ListCrudRepository<Merchant, Long> {
}
