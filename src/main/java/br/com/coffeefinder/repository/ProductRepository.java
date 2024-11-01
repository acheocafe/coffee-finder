package br.com.coffeefinder.repository;

import br.com.coffeefinder.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** ProductRepository */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
