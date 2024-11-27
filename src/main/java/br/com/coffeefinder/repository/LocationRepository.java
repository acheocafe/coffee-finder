package br.com.coffeefinder.repository;

import br.com.coffeefinder.entity.Location;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/** LocationRepository */
@Repository
public interface LocationRepository extends ListCrudRepository<Location, Long> {
}
