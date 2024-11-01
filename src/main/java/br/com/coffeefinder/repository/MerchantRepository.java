package br.com.coffeefinder.repository;

import br.com.coffeefinder.dto.MerchantDto;
import br.com.coffeefinder.entity.Merchant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
	List<MerchantDto> findAllDtoeBy();
}
