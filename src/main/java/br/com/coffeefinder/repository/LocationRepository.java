package br.com.coffeefinder.repository;

import br.com.coffeefinder.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** LocationRepository */
@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
